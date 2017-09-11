package com.juwon.interface_study;

import com.juwon.interface_study2.C;
import com.juwon.interface_study2.InterfaceC;

public class A implements InterfaceC {
	public void process() {
		C c = new C();
		c.process(this); // InterfaceC ifc = [this �� new A() ����]; ��, memory �� �ö󰡸鼭 �ʱ�ȭ�ȴ�.
	}
	
	public void afterProcess() {
		System.out.println("Complete!");
	}

	@Override
	public void callback() {
		afterProcess();
	}
}
