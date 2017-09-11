package com.juwon.generic_study;

class NewList<T> {
	private Object[] list;
	
	public NewList() {
		list = new Object[1];
	}
	public void add(T item) {
		Object[] tempList = new Object[size() + 1];
		for(int i=0; i<list.length; i++) {
			tempList[i] = list[i];
		}
		tempList[list.length] = item;
		list = tempList;
	}
	public int size() {
		return list.length - 1;
	}
	public void remove(int position) {
		Object[] tempList = new Object[size() - 1];
		for(int i=0; i<position; i++)
			tempList[i] = list[i];
		for(int i=position+1; i<list.length; i++)
			tempList[i-1] = list[i];
		list = tempList;
	}
}
