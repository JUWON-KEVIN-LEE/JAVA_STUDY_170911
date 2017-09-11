package com.juwon.boardProgram;

import java.util.*;

public class View {
	Scanner sc = new Scanner(System.in);
	//---------------WRITE--------------------------
	public String[] writeMemo() {
		String[] memoArray = new String[3];
		print("|작성자 : ");
		memoArray[0] = sc.nextLine();
		print("|제목    : ");
		memoArray[1] = sc.nextLine();
		print("|내용    : ");
		memoArray[2] = sc.nextLine();
		printLine();
		return memoArray;
	}
	//---------------READ---------------------------
	public int readMessage() {
		println("----- 읽고 싶은 게시글의 번호를 입력해주세요 -----");
		print(">>> ");
		int index = Integer.parseInt(sc.nextLine());
		return index;
	}
	//---------------UPDATE-------------------------
	public int updateMessage(Scanner sc) {
		println("----- 수정 하실 게시글의 번호를 입력해주세요 -----");
		print(">>> ");
		int index = Integer.parseInt(sc.nextLine());
		printLine();
		return index;
	}
	public String[] updateMemoReturn() {
		printLine();
		String[] memoArray = new String[3];
		print("|작성자: ");
		memoArray[0] = sc.nextLine();
		print("|제목: ");
		memoArray[1] = sc.nextLine();
		print("|내용: ");
		memoArray[2] = sc.nextLine();
		
		return memoArray;
	}	
	//---------------DELETE-------------------------
	public int deleteMessage(Scanner sc) {
		println("----- 삭제 하실 게시글의 번호를 입력해주세요 -----");
		print(">>> ");
		int index = Integer.parseInt(sc.nextLine());
		return index;
	}
	//---------------LIST---------------------------
	public void listPrint(List<Memo> memoList) {
		int totalNumberOfMemo = memoList.size();
		
		for(int i = 0; i < totalNumberOfMemo; i++) {
			printLine();
			printMemo(memoList.get(i));
		}
	}
	//---------------PRINT--------------------------
	public void printMemo(Memo memo) {
		println("|번호: " + memo.index);
		println("|작성자: " + memo.author);
		println("|제목: " + memo.subject);
		println("|내용: " + memo.content);
		println("|작성날짜: " + memo.date);
		println("|작성시간: " + memo.time);
	}
	public void printLine() {	
		println("-----------------------------------");
	}
	public String introMessage(Scanner sc) {
		println("---------- 안녕하세요 반갑습니다 ----------");
		println("---------- 명령어를 입력해주세요 ----------");
		println("| w : 쓰기 | r : 읽기 | u : 수정 | d : 삭제 | l : 리스트 | x : 종료 |");
		print(">>> "); String command = sc.nextLine();
		println("-----------------------------------");
		return command;
	}
	public void outroMessage() {
		println("---------- 프로그램이 종료됩니다 ----------");
	}
	public void workCompleteAndModeSelectMessage() {
		println("---------- 작업이 완료되었습니다 ----------");
		println("------ 다음 작업의 명령어를 입력해주세요 -------");
		print(">>> ");
	}
	public void wrongInputMessage() {
		println("------- 잘못된 명령어를 입력하셨습니다 --------");
		println("-------- 올바른 명령어를 입력해주세요 --------");
		print(">>> ");
	}
	public void print(String str) {
		System.out.print(str);
	}
	public void println(String str) {
		System.out.println(str);
	}
	public void nextLine() {
		System.out.println();
	}
}
