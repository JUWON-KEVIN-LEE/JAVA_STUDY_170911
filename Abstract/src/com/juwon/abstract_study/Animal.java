package com.juwon.abstract_study;

interface a { // �������� �ο�..
	void create();
	void delete();
	void list();
	void update();
	void read();
}

abstract class Animal implements a {
	public abstract String type();
	
	@Override
	public void create() {
	}
	@Override
	public void delete() {
	}
	@Override
	public void list() {
	}
	@Override
	public void update() {
	}
	@Override
	public void read() {
	}
}

class Room extends Animal {
	String type = "������";
	public String type() { return type; }
}