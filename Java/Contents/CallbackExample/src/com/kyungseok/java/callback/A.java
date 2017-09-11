package com.kyungseok.java.callback;

import com.kyungseok.java.inter.C;
import com.kyungseok.java.inter.InterfaceC;

public class A implements InterfaceC{

	public void process(){
		C c = new C();
		c.process(this);
		// ������ ���������� afterProcess
	}
	
	public void afterProcess(){
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	@Override
	public void callback() {
		afterProcess();
	}
}