package com.mangocity.guava.multiset;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetTest2 {

	/**
	 * Map<E,Count>:存了一个key,对应一个次数
	 * add(E){
	 * 		Map.put(E,Count(++1));
	 * }
	 */
	@Test
	public void testMultiSetA(){
		Multiset<String> multiSet = HashMultiset.create();
		multiSet.add("hello");
		multiSet.add("hello");
		multiSet.add("world");
		multiSet.add("3");
		
		System.out.println(multiSet);
		System.out.println(multiSet.count("hello"));
		
	}
}
