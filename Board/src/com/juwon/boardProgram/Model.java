package com.juwon.boardProgram;

import java.sql.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Model {
	private final String URL = "jdbc:mysql://localhost:3306/memo";
	private final String ID = "root";
	private final String PASSWORD = "dlwndnjs1";
	private static int count = 0;
	// Connection DriverManager statement
	public Model() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Ư�� ����̹� �̸��ΰ�?
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//---------------WRITE--------------------------
	public Memo writeMemo(String[] memoArray) {
		Memo memo = new Memo();
		plusCount();
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			String query = " insert into memoDB values(?, ?, ?, ?, ?, ?)";
			PreparedStatement psmt = connection.prepareStatement(query);
			
			memo.index = count;
			memo.author = memoArray[0];
			memo.subject = memoArray[1];
			memo.content = memoArray[2];
			memo.date = Date.valueOf(LocalDate.now()); 
			memo.time = Time.valueOf(LocalTime.now());
			
			psmt.setInt(1, memo.index);
			psmt.setString(2, memo.author);
			psmt.setString(3, memo.subject);
			psmt.setString(4, memo.content);
			psmt.setDate(5, memo.date);
			psmt.setTime(6, memo.time);
			
			psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		return memo;
	}
	//---------------READ---------------------------
	public Memo readMemo(int index) {
		Memo memo = new Memo();
		
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			String query = "select * from memoDB where `index`=" + index;
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				memo.index = rs.getInt("index");
				memo.author = rs.getString("author");
				memo.subject = rs.getString("subject");
				memo.content = rs.getString("content");
				memo.date = rs.getDate("date");
				memo.time = rs.getTime("time");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return memo;
	}
	//---------------UPDATE-------------------------
	public void updateMemo(String[] memoArray, int index) {
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			String query = "update memoDB set author = '" + memoArray[0]
					+ "', subject = '" + memoArray[1] + "', content = '" + memoArray[2]
							+ "', date = CURDATE(), time = CURTIME()" + " where `index` = " + index+';';
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.executeUpdate();
			//memo.date = ;
			//memo.time = ;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//---------------DELETE-------------------------
	public void deleteMemo(int index) {
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			String query = "delete from memoDB where `index` = " + index;
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateIndex(int index) {
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			for(int i = index; i < count; i++) {
				String query = "update memoDB set `index` = " + i +" where `index` = " + (i+1);
				PreparedStatement psmt = connection.prepareStatement(query);
				psmt.executeUpdate();
			}
			minusCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//---------------LIST---------------------------
	public List<Memo> getMemoList() {
		List<Memo> memoList = new ArrayList<>();
		
		try(Connection connection = DriverManager.getConnection(URL, ID, PASSWORD)) {
			String query = "select * from memoDB";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Memo memo = new Memo();
				memo.index = rs.getInt("index");
				memo.author = rs.getString("author");
				memo.subject = rs.getString("subject");
				memo.content = rs.getString("content");
				memo.date = rs.getDate("date");
				memo.time = rs.getTime("time");
				memoList.add(memo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memoList;
	}
	//manage count
	public void minusCount() {
		count -= 1;
	}
	public void plusCount() {
		count += 1;
	}
}
