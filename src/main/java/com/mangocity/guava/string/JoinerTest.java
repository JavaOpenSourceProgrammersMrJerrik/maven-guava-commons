package com.mangocity.guava.string;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class JoinerTest {

	@Test
	public void testJoinerA(){
		String result = Joiner.on("-").useForNull("HAHA").join(new String[]{"Hello","World","B","A",null,"DD"});//替代空
		System.out.println(result);
		
		result = Joiner.on("-").skipNulls().join(new String[]{"Hello","World","B","A",null,"DD"});//跳过空
		System.out.println(result);
		
	}
	
	@Test
	public void testJoinerList(){
		List<String> strList = Lists.newArrayList("hello","world","IBM","Oracle",null,"Admin");
		String result = Joiner.on("#").skipNulls().join(strList);
		System.out.println(result);
	}
	
	
}
