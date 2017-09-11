package com.kyungseok.java.generic;

public class NewList<T> {
	public Object list[];
	
	// ���� ���� ���� ���¿��� ������ ���� üũ�� �� �� �ֱ� ������ ����Ҹ� �ʱ�ȭ ���ִ� �۾��� �ʿ��ϴ�.
	public NewList() { 
		// if( type instanceOf target) : Ÿ���� ������ true�� ��ȯ
		list =new Object[0];
	}
	
	// size
	public int size() {
		return list.length;
	}
	
	// add	
	public void add(T item) {
		// �迭�� ũ�⸦ �ӽ÷� �÷��� ���
		Object tempList[] = new Object[list.length+1];
		for(int i=0 ; i<list.length ; i++) {
			tempList[i] = list[i];
		}
		tempList[list.length] = item;
		list = tempList;
	}
	
	// remove
	public void remove(int position) {
		//�迭�� ũ�⸦ �ӽ÷� �÷��� ���
		Object tempList[] = new Object[size()-1];
		//position ������ �����͸� �ӽð������� ����
		for(int i=0 ; i<position ; i++) {
			tempList[i] = list[i];
		}
		//position ������ �����͸� �ӽð������� ����
		for(int i=position+1 ; i<list.length ; i++) {
			tempList[i-1] = list[i];
		}
		list = tempList;
	}
	
	// get
	public Object get(int i) {
		Object result = 0;
		result = list[i];
		return result;
	}
}
