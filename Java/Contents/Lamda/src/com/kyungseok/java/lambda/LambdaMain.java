package com.kyungseok.java.lambda;

public class LambdaMain {
	public static void main(String[] args) {
		
		// Thread(runnable) �� ���
		// ���� ��� ���
		Runnable two = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello");
			}
		};
		
		// ���ٽ� �̿�
		Runnable two2 = () -> {
			System.out.println("Hello");
		};
		
		// ����
		new Thread(two2).start();
		
		//========================================================
		
		// Ŭ���� ����
		OneProcess processOne = new OneProcess();
		
		// ���� ��� ���
		processOne.process( new One() {
			@Override
			public void run(int x) {
				System.out.println(x);
				}
			}
		);
		
		// ���ٽ� �̿�
		processOne.process( x -> System.out.println(x) );
	}
}

class OneProcess{
	public void process(One one) {
		one.run(10002);
	}
}

interface One{
	public void run(int x);
}
