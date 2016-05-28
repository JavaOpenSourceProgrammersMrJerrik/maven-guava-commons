package com.mangocity.guava.immutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class UnmodifiableList {

	public static void main(String[] args) {
		List<String> preList = Lists.newArrayList();
		preList.addAll(Arrays.asList(new String[] { "hello", "world", "test" }));
		System.out.println("preList: " + preList);

		List<String> unmodifiableList = Collections.unmodifiableList(preList);
		System.out.println("preUnmodifiableList: " + unmodifiableList);
		
		preList.add("bad girl.");
		
		System.out.println("afterUnmodifiableList: " + unmodifiableList);
	}
}
