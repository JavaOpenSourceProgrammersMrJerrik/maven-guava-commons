package com.mangocity.guava.function;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FunctionTest {

	@Test
	public void testTransformValues(){
		Map<String,String> paramMap = Maps.newHashMap();
		paramMap.put("hello", "IBM");
		paramMap.put("world", "Oralce");
		paramMap.put("good", "SUN");
		
		paramMap = Maps.transformValues(paramMap, new Function<String,String>() {
			@Override
			public String apply(String input) {
				return input  + "@" + Math.random();
			}
		});
		
		System.out.println(paramMap);
	}
	
	@Test
	public void testListTransform(){
		List<String> list = Lists.newArrayList("hello","world","good");
		list = Lists.transform(list, new Function<String,String>() {
			@Override
			public String apply(String input) {
				return input + "#";
			}
		});
		System.out.println(list);
	}
}
