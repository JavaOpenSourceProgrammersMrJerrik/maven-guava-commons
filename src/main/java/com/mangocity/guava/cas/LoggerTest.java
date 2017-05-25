package com.mangocity.guava.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoggerTest {

	public static void main(String[] args) {
		//System.out.println("show error.userId: " + 1 + "_NullPointException");//-XX:+HeapDumpOnOutOfMemoryError
		
		List<String> list = new ArrayList<String>();
		for(;;){
			list.add(new String(UUID.randomUUID().toString()));
		}
	}

}
