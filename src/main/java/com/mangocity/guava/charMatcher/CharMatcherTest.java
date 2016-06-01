package com.mangocity.guava.charMatcher;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.common.base.CharMatcher;

public class CharMatcherTest {

	@Test
	public void testCharMatcher(){
		assertEquals("87654", CharMatcher.DIGIT.retainFrom("I am not 87654 a student."));
		assertEquals("I am not  a student.", CharMatcher.DIGIT.removeFrom("I am not 87654 a student."));
	}
}
