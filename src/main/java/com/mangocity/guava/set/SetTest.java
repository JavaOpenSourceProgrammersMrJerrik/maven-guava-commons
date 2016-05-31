package com.mangocity.guava.set;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class SetTest {

	@Test
	public void testSetA(){
		Set<String> setA = Sets.newHashSet();
		Set<String> setB = Sets.newHashSet();
		
		setA.add("hello");
		setA.add("aaa");
		
		setB.add("hello");
		setB.add("bbb");
		setB.add("bad");
		
		System.out.println("union: " + Sets.union(setA, setB));
		System.out.println("intersection: " + Sets.intersection(setA, setB));
		System.out.println("difference: " + Sets.difference(setA, setB));
		
		SetView<String> setView = Sets.union(setA, setB);
	}
}
