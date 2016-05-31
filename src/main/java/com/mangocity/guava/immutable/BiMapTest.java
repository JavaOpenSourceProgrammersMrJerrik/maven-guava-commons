package com.mangocity.guava.immutable;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * BiMap: 双向 Map
   BiMap 实现了 java.util.Map 接口。
     它的特点是它的 value 和它 key 一样也是不可重复的，换句话说它的 key 和 value 是等价的。
     如果你往 BiMap 的 value 里面放了重复的元素，就会得到 IllegalArgumentException。
 */
public class BiMapTest {

	
	@Test
	public void testHashBiMap(){
		BiMap<String, String> hBiMap = HashBiMap.create();
		hBiMap.put("hello", "1");
		hBiMap.put("hello", "2");
		//hBiMap.put("hello", "2");//不能存放重复值2
		hBiMap.put("hello", "3");
		hBiMap.put("world", "2");
		System.out.println(hBiMap);
	}
}
