package com.mangocity.guava.immutable;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Multiset常用实现类:
HashMultiset: 元素存放于 HashMap
LinkedHashMultiset: 元素存放于 LinkedHashMap，即元素的排列顺序由第一次放入的顺序决定
TreeMultiset:元素被排序存放于TreeMap
EnumMultiset: 元素必须是 enum 类型
ImmutableMultiset: 不可修改的 Mutiset
 */
public class MultisetTest {

	@Test
	public void testMultiSet() {
		Multiset<String> multiSet = HashMultiset.create();
		multiSet.addAll(Arrays.asList(new String[] { "admin", "3", "Jerrik",
				"admin", "Jerrik", "5", "Jerrik" }));
		int size = multiSet.size();
		System.out.println("size: " + size);
		Object[] strs = multiSet.toArray();
		System.out.println("Object[]: " + Arrays.toString(strs));

		printMultiset(multiSet);

		String removeKey = "admin";
		int count = multiSet.count(removeKey);
		
		multiSet.remove("admin", count);// remove(key)只移除一个
		
		System.out.println("==============");
		printMultiset(multiSet);
		System.out.println("**************");
		
		multiSet.setCount("world", 5);//设置元素的重复次数
		printMultiset(multiSet);
	}

	private void printMultiset(Multiset<String> multiSet) {
		for (String key : multiSet.elementSet()) {
			System.out
					.println("key: " + key + " ,size: " + multiSet.count(key));
		}
	}
}
