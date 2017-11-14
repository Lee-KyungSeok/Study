package com.kyungseok.java.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaInterfaceBasic {
	public void run() {
		/*
		 * ���� �������̽�
		 */
		// 1. Supplier : �Է°��� ����, ��ȯ���� ������ ���
		Supplier<Integer> supplier = () -> 180 + 20;
		System.out.println(supplier.get());
		
		// 2. Consumer : �Է°��� �ְ�, ��ȯ���� ������ ���
		//				  �ڵ� ������ ���ó���� �Ǿ�� �Ѵ�. 
		Consumer<Integer> consumer = System.out::println;
		consumer.accept(100);
		
		// 3. Function : �Է°��� �ְ�, ��ȯ���� �ִ�.
		//				  �Է°��� ��ȯ���� Ÿ���� ���׸����� ����
		Function<Integer, Double> function = x -> x*0.55;
		System.out.println(function.apply(50));
		
		// 4. Predicate : �Է°��� ���� �� ������ �Ǵ�. return type = boolean
		Predicate<Integer> predicate = x -> x <100;
		System.out.println("50�� 100���� �۽��ϴ� : " + predicate.test(50));
		
		// 5. UnaryOperator : �Է°� ��ȯ Ÿ���� ������ �� ���
		UnaryOperator<Integer> unary = x -> x+20;
		System.out.println(unary.apply(100));
		
		/*
		 * ���� �������̽�
		 */
		// 1. BiConsumer  	 : Consumer  �� �Է°��� �ΰ�
		BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println( x + y) ;
		biConsumer.accept(30, 27); // ����� 57
		
		// 2. BiFunction  	 : Function   	"
		BiFunction<Integer, Integer, Double> biFunction = (x,y) -> x+y*0.55;
		System.out.println(biFunction.apply(50,20));
		
		// 3. BiPredicate 	 : Predicate  	"
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> x+y <100;
		System.out.println("50+20�� 100���� �۽��ϴ� : " + biPredicate.test(50,20));
		
		
		// 4. BinaryOperator : 				"
		BinaryOperator<Integer> binaryOperator = (x,y) -> x+y+20;
		System.out.println(binaryOperator.apply(100,30));
		
	}

}
