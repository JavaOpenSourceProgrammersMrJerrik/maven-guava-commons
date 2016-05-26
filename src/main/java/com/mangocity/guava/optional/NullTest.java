package com.mangocity.guava.optional;

public class NullTest {

	public static void testNull() {
		int age = 0;
		System.out.println("user Age:" + age);

		long money;
		money = 10L;
		System.out.println("user money" + money);

		String name = null;
		System.out.println("user name:" + name);
	}
	
	public static void main(String[] args) {
		testNull();
	}
}
