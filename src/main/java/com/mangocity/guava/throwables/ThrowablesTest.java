package com.mangocity.guava.throwables;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Throwables;

/**
 * 　1.RuntimeException
 * propagate(Throwable)：把throwable包装成RuntimeException，用该方法保证异常传递
 * ，抛出一个RuntimeException异常 　　 2.void propagateIfInstanceOf(Throwable, Class<X
 * extends Exception>) throws X：当且仅当它是一个X的实例时，传递throwable 　　 3.void
 * propagateIfPossible(Throwable)：当且仅当它是一个RuntimeException和Error时，传递throwable
 * 4.void propagateIfPossible(Throwable, Class<X extends Throwable>) throws
 * X：当且仅当它是一个RuntimeException和Error时，或者是一个X的实例时，传递throwable。
 * 
 * @author YangJie
 *
 */
public class ThrowablesTest {

	@Test
	public void testThrowables() {
		try {
			throw new Exception("瞎起哄");
		} catch (Throwable t) {
			String ss = Throwables.getStackTraceAsString(t);
			System.out.println("ss:" + ss);
			Throwables.propagate(t);// propagate: 传播
		}

		System.out.println("stop...");
	}

	@Test
	public void call() throws IOException {
		try {
			throw new IOException();
		} catch (Throwable t) {
			Throwables.propagateIfInstanceOf(t, IOException.class);// 如果抛出的异常是IOException,则直接抛出异常,不用执行下面的语句
			System.out.println("do execute...");
			throw Throwables.propagate(t);
		}
	}

	@Test
	public void testPropagateIfPossible() throws Exception {
		try {
			throw new RuntimeException("哈哈");
		} catch (Throwable t) {
			Throwables.propagateIfPossible(t, RuntimeException.class);// 当且仅当它是一个RuntimeException和Error时，或者是一个X的实例时，传递throwable。
			System.out.println("....");
			Throwables.propagate(t);
		}
	}

	@Test
	public void testThrowableCause() {
		try {
			throw new RuntimeException("rootCause...");
		} catch (Exception e) {
			try {
				System.out.println("getStackTraceAsString: " + Throwables.getStackTraceAsString(e));
				System.out.println("first exception");
				Throwables.propagateIfInstanceOf(e, RuntimeException.class);
			} catch (RuntimeException e1) {
				System.out.println("secode exception");
				List<Throwable> exceptionList = Throwables.getCausalChain(e1);
				System.out.println("exception size: " + exceptionList.size());
				System.out.println("print exception stackprace: " + exceptionList);
			}
		}
	}
}
