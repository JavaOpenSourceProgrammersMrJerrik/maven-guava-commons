package com.mangocity.guava.cas;

public class NPETest {

	public static void main(String[] args) {
		Long a = null;
		long b = a;
	}

}
