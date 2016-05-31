package com.mangocity.guava.throwables;

import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Throwables;

public class ThrowablesTestB {

	@Test
	public void testThrowablesA() throws IOException {
		try {
			throw new GuavaTestException("test异常...");
		} catch (Exception e) {
			System.out.println(Throwables.getRootCause(e));
			//System.out.println(Throwables.getStackTraceAsString(e));
			System.out.println("propagateIfInstanceOf...");
			Throwables.propagateIfInstanceOf(e, IOException.class);
			System.out.println("propagate...");
			Throwables.propagate(e);
		}
	}
}
