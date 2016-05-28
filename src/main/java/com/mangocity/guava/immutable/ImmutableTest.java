package com.mangocity.guava.immutable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Collections.unmodifiableList虽然本身不提供修改操作,但是它指向的引用可以被修改
 * 可变集合类型	可变集合源：JDK or Guava?	Guava不可变集合
Collection	JDK	ImmutableCollection
List	JDK	ImmutableList
Set	JDK	ImmutableSet
SortedSet/NavigableSet	JDK	ImmutableSortedSet
Map	JDK	ImmutableMap
SortedMap	JDK	ImmutableSortedMap
Multiset	Guava	ImmutableMultiset
SortedMultiset	Guava	ImmutableSortedMultiset
Multimap	Guava	ImmutableMultimap
ListMultimap	Guava	ImmutableListMultimap
SetMultimap	Guava	ImmutableSetMultimap
BiMap	Guava	ImmutableBiMap
ClassToInstanceMap	Guava	ImmutableClassToInstanceMap
Table	Guava	ImmutableTable
 * @author YangJie
 */
public class ImmutableTest {

	public static void main(String[] args) {
		ImmutableList<String> immutableList = ImmutableList.of("hello");
		System.out.println(immutableList.toString());
	}

	@Test
	public void testGuavaImmutable() {
		List<String> list = Lists.newArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("list1：" + list);

		ImmutableList<String> imlist = ImmutableList.copyOf(list);
		System.out.println("imlist1：" + imlist);

		list.add("hello world");

		System.out.println("imlist2：" + imlist);

		System.out.println("list2：" + list);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
		System.out.println("imOflist：" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		System.out.println("imSortList：" + imSortList);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after imlist:" + imlist);

		// 链式编程 builder()创建一个能提供add方法的对象
		ImmutableSet<Color> imColorSet = ImmutableSet.<Color> builder().add(new Color(0, 255, 255))
				.add(new Color(0, 191, 255)).build();

		System.out.println("imColorSet:" + imColorSet);
	}

	@Test
	public void testCotyOf() {
		ImmutableSet<String> imSet = ImmutableSet.of("peida", "jerry", "harry", "lisa");
		System.out.println("imSet：" + imSet);
		ImmutableList<String> imlist = ImmutableList.copyOf(imSet);
		System.out.println("imlist：" + imlist);
		ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSet);
		System.out.println("imSortSet：" + imSortSet);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(i + "x");
		}
		System.out.println("list：" + list);
		ImmutableList<String> imInfolist = ImmutableList.copyOf(list.subList(2, 18));
		System.out.println("imInfolist：" + imInfolist);
		int imInfolistSize = imInfolist.size();
		System.out.println("imInfolistSize：" + imInfolistSize);
		ImmutableSet<String> imInfoSet = ImmutableSet.copyOf(imInfolist.subList(2, imInfolistSize - 3));
		System.out.println("imInfoSet：" + imInfoSet);
	}

	@Test
	public void testAsList() {
		ImmutableList<String> imList = ImmutableList.of("peida", "jerry", "harry", "lisa", "jerry");
		System.out.println("imList：" + imList);
		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.copyOf(imList);
		System.out.println("imSortList：" + imSortList);
		System.out.println("imSortList as list：" + imSortList.asList());
	}

}
