package com.mangocity.guava.immutable;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Sets;

public class ImmutableTest2 {

	@Test
	public void testImmutableBuilder() {
		// 从构造的方式来说，ImmutableSet 集合还提供了 Builder 模式来构造一个集合 :
		Set<String> set = Sets.newHashSet();
		set.add("1");
		set.add("2");
		Builder<String> builder = ImmutableSet.builder();
		ImmutableSet<String> immutableSet = builder.add("RED").addAll(set)
				.build();
		
		System.out.println(immutableSet);
	}
}
