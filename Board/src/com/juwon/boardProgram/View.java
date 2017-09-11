package com.juwon.boardProgram;

import java.util.*;

public class View {
	Scanner sc = new Scanner(System.in);
	//---------------WRITE--------------------------
	public String[] writeMemo() {
		String[] memoArray = new String[3];
		print("|�ۼ��� : ");
		memoArray[0] = sc.nextLine();
		print("|����    : ");
		memoArray[1] = sc.nextLine();
		print("|����    : ");
		memoArray[2] = sc.nextLine();
		printLine();
		return memoArray;
	}
	//---------------READ---------------------------
	public int readMessage() {
		println("----- �а� ���� �Խñ��� ��ȣ�� �Է����ּ��� -----");
		print(">>> ");
		int index = Integer.parseInt(sc.nextLine());
		return index;
	}
	//---------------UPDATE-------------------------
	public int updateMessage(Scanner sc) {
		println("----- ���� �Ͻ� �Խñ��� ��ȣ�� �Է����ּ��� -----");
		print(">>> ");
		int index = Integer.parseInt(sc.nextLine());
		printLine();
		return index;
	}
	public String[] updateMemoReturn() {
		printLine();
		String[] memoArray = new String[3];
		print("|�ۼ���: ");
		memoArray[0] = sc.nextLine();
		print("|����: ");
		memoArray[1] = sc.nextLine();
		print("|����: ");
		memoArray[2] = sc.nextLine();
		
		return memoArray;
	}	
	//---------------DELETE-------------------------
	public int deleteMessage(Scanner sc) {
		println("----- ���� �Ͻ� �Խñ��� ��ȣ�� �Է����ּ��� -----");
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
		println("|��ȣ: " + memo.index);
		println("|�ۼ���: " + memo.author);
		println("|����: " + memo.subject);
		println("|����: " + memo.content);
		println("|�ۼ���¥: " + memo.date);
		println("|�ۼ��ð�: " + memo.time);
	}
	public void printLine() {	
		println("-----------------------------------");
	}
	public String introMessage(Scanner sc) {
		println("---------- �ȳ��ϼ��� �ݰ����ϴ� ----------");
		println("---------- ��ɾ �Է����ּ��� ----------");
		println("| w : ���� | r : �б� | u : ���� | d : ���� | l : ����Ʈ | x : ���� |");
		print(">>> "); String command = sc.nextLine();
		println("-----------------------------------");
		return command;
	}
	public void outroMessage() {
		println("---------- ���α׷��� ����˴ϴ� ----------");
	}
	public void workCompleteAndModeSelectMessage() {
		println("---------- �۾��� �Ϸ�Ǿ����ϴ� ----------");
		println("------ ���� �۾��� ��ɾ �Է����ּ��� -------");
		print(">>> ");
	}
	public void wrongInputMessage() {
		println("------- �߸��� ��ɾ �Է��ϼ̽��ϴ� --------");
		println("-------- �ùٸ� ��ɾ �Է����ּ��� --------");
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
