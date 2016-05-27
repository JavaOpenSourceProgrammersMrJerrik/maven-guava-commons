package com.mangocity.guava.precondition;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class PreconditionsTest {
	public static void main(String[] args) {
		try {
			throw new NullPointerException("空指针");
		} catch (Exception e) {
			System.out.println("不做操作");
		}
		System.out.println("haha");
		
		//Preconditions.checkArgument(false, "自定义参数错误");
		Preconditions.checkNotNull(null, "自定义NotNull");
		//Preconditions.checkState(false);//抛出IllegalStateException
		//Preconditions.checkElementIndex(4, 4);//index不能大于size
	}

	/**
		1.
		Person[age:8 ,neme:peida]
		2.
		Exception: age 必须大于0
		3.
		Exception: neme为''
		4.
		Exception: neme为null
	 */
	@Test
	public void testPreconditions() throws Exception {
		try {
			System.out.println("1.");
			getPersonByPrecondition(8, "peida");
		} catch (Exception e1) {
			System.out.println("Exception: " + e1.getMessage());
		}
		try {
			System.out.println("2.");
			getPersonByPrecondition(-9, "peida");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		try {
			System.out.println("3.");
			getPersonByPrecondition(8, "");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		try {
			System.out.println("4.");
			getPersonByPrecondition(8, null);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

	public static void getPersonByPrecondition(int age, String name) throws Exception {
		Preconditions.checkNotNull(name, "neme为null");
		Preconditions.checkArgument(name.length() > 0, "neme为\'\'");
		Preconditions.checkArgument(age > 0, "age 必须大于0");
		System.out.println("Person[age:" + age + " ,neme:" + name + "]");
	}
}
