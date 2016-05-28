package com.mangocity.guava.multiset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

/**
 * Multiset和Set的区别就是可以保存多个相同的对象 Multiset接口定义的接口主要有： 　　　　add(E element)
 * :向其中添加单个元素 　　　　add(E element,int occurrences) : 向其中添加指定个数的元素 　　　　count(Object
 * element) : 返回给定参数元素的个数 　　　　remove(E element) : 移除一个元素，其count值 会响应减少
 * 　　　　remove(E element,int occurrences): 移除相应个数的元素 　　　　elementSet() :
 * 将不同的元素放入一个Set中 　　　　entrySet(): 类似与Map.entrySet
 * 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount() 　　　　setCount(E
 * element ,int count): 设定某一个元素的重复次数 　　　　setCount(E element,int oldCount,int
 * newCount): 将符合原有重复个数的元素修改为新的重复次数 　　　　retainAll(Collection c) :
 * 保留出现在给定集合参数的所有的元素 　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
 * 
 * 　Guava提供了Multiset的多种实现，这些实现基本对应了JDK中Map的实现： 
　　Map                        Corresponding Multiset   Supports null elements
　　HashMap                  HashMultiset                      Yes
　　TreeMap                   TreeMultiset                       Yes (if the comparator does)
　　LinkedHashMap         LinkedHashMultiset             Yes
　　ConcurrentHashMap  ConcurrentHashMultiset       No
　　ImmutableMap          ImmutableMultiset               No
 * @author YangJie
 */
public class MultiSetTest {

	@Test
	public void testWordCount() {
		String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|"
				+ "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|"
				+ "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
		String[] words = strWorld.split("\\|");
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (String word : words) {
			Integer count = countMap.get(word);
			if (count == null) {
				countMap.put(word, 1);
			} else {
				countMap.put(word, count + 1);
			}
		}
		System.out.println("countMap：");
		for (String key : countMap.keySet()) {
			System.out.println(key + " count：" + countMap.get(key));
		}
	}

	@Test
	public void testMultsetWordCount() {
		String strWorld = "wer|dfd|dd|dfd|dda|de|dr|admin|jerrik|admin|3";
		String[] words = strWorld.split("\\|");
		List<String> wordList = new ArrayList<String>();
		for (String word : words) {
			wordList.add(word);
		}
		Multiset<String> wordsMultiset = HashMultiset.create();
		wordsMultiset.addAll(wordList);

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}
	}

	// 移除多个相同的值
	@Test
	public void testMultiSetRemoveMulValue() {
		List<String> list = Lists.newArrayList();
		list.addAll(Arrays.asList("admin|jerrik|admin|yangjie|jerrik2|1|3|world".split("\\|")));
		Multiset<String> multiSet = HashMultiset.create();
		multiSet.addAll(list);

		for (String key : multiSet.elementSet()) {
			System.out.println("key: " + key + " ,count: " + multiSet.count(key));
		}

		System.out.println();
		System.out.println("remove key [admin]...");
		System.out.println();

		multiSet.remove("admin", 2);

		System.out.println("multiSet: " + multiSet);
	}

	@Test
	public void testMultsetWordCount2() {
		String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
		String[] words = strWorld.split("\\|");
		List<String> wordList = new ArrayList<String>();
		for (String word : words) {
			wordList.add(word);
		}
		Multiset<String> wordsMultiset = HashMultiset.create();
		wordsMultiset.addAll(wordList);

		// System.out.println("wordsMultiset："+wordsMultiset);

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}

		if (!wordsMultiset.contains("peida")) {
			wordsMultiset.add("peida", 2);
		}
		System.out.println("============================================");
		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 23);
		}

		System.out.println("============================================");
		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 23, 45);
		}

		System.out.println("============================================");
		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 44, 67);
		}

		System.out.println("============================================");
		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}
	}

}
