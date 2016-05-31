package com.mangocity.guava.multimap;

import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

/**
 * Multimap的数据结构对应的的就是:
 * new HashMultiMap(K,new HashSet)
 * 
 * 在 Map 的 value 里面放多个元素 设想你对 Map 调了 2 次参数 key 一样的 put 方法，结果就是第 2 次的 value 覆盖了第
 * 1 次的 value。但是对 Muitimap 来说这个 key 同时对应了 2 个 value。所以 Map 看上去是 : {k1=v1,
 * k2=v2,...}，而 Muitimap 是 :{k1=[v1, v2, v3], k2=[v7, v8],....}
 * 
 * HashMultimap: key 放在 HashMap，而 value 放在 HashSet，即一个 key 对应的 value 不可重复
 * ArrayListMultimap: key 放在 HashMap，而 value 放在 ArrayList，即一个 key 对应的 value
 * 有顺序可重复 LinkedHashMultimap: key 放在 LinkedHashMap，而 value 放在 LinkedHashSet，即一个
 * key 对应的 value 有顺序不可重复 TreeMultimap: key 放在 TreeMap，而 value 放在 TreeSet，即一个 key
 * 对应的 value 有排列顺序 ImmutableMultimap: 不可修改的 Multimap
 */
public class MultimapTest {

	@Test
	public void testMultimap() {
		Multimap<String, String> multimap = HashMultimap.create();
		multimap.put("hello", "3");
		multimap.put("hello", "5");
		multimap.put("hello", "good girl");
		multimap.put("world", "bad body");
		multimap.put("world", "IBM");

		System.out.println("values: " + multimap.values());// values
		printSeparatorLine();

		System.out.println("hello: " + multimap.get("hello"));

		printSeparatorLine();
		System.out.println("containsKey: " + multimap.containsKey("hello"));
		printSeparatorLine();

		System.out.println("containsValue: " + multimap.containsValue("5"));

		printSeparatorLine();
		multimap.removeAll("hello");// 移除该key对应的所有value
		System.out.println(multimap);

		printSeparatorLine();
		multimap.remove("world", "bad body");// 只移除该key对应的一个value
		System.out.println(multimap);
	}

	private void printSeparatorLine() {
		System.out.println("=============");
	}

	// value对应的是HashSet不能出现重复值
	@Test
	public void testHashMultiMap() {
		Multimap<String, String> multimap = HashMultimap.create();
		multimap.put("hello", "111");
		multimap.put("hello", "222");
		multimap.put("hello", "111");
		System.out.println(multimap);
	}

	// value对应的是ArrayList能出现重复值
	@Test
	public void testArrayListMultiMap() {
		Multimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("hello", "111");
		multimap.put("hello", "222");
		multimap.put("hello", "111");
		System.out.println(multimap);
	}

	// value对应的是ArrayList能出现重复值
	@Test
	public void testImmutableMultimap() {
		Multimap<String, String> multimap = ImmutableMultimap.of("hello",
				"world", "hello", "123");
		System.out.println(multimap);
	}
	
	/**
	 * {hello=[good boy, world], world=[222]}
		good boy
		world
	 */
	@Test
	public void testHashMultimap() {//new HashMap<K, HashSet<V>>()
		Multimap<String, String> multimap = HashMultimap.create();
		multimap.put("hello", "world");
		multimap.put("hello", "good boy");
		multimap.put("hello", "good boy");
		multimap.put("world", "222");
		System.out.println(multimap);
		
		for(String str : multimap.get("hello")){
			System.out.println(str);
		}
	}
	
	/**
	 * {hello=[world, good boy, good boy], world=[222]}
		world
		good boy
		good boy
	 */
	@Test
	public void testArrayListMultimap() {//new HashMap<K, <V>>()
		Multimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("hello", "world");
		multimap.put("hello", "good boy");
		multimap.put("hello", "good boy");
		multimap.put("world", "222");
		System.out.println(multimap);
		
		for(String str : multimap.get("hello")){
			System.out.println(str);
		}
	}
}
