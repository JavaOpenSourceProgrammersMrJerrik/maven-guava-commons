package com.mangocity.guava.precondition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class PreconditionsExtTest {
	private static class PreconditionInner {
		private String name;
		private Long age;

		public PreconditionInner(String name, Long age) {
			this.name = Preconditions.checkNotNull(name,"name can't be null.");
			this.age = Preconditions.checkNotNull(age,"age can't be null.");
		}

		@Override
		public String toString() {
			return "PreconditionInner [name=" + name + ", age=" + age + "]";
		}
	}
	
	@Test
	public void testStaticClass(){
		PreconditionInner preconditionClass = new PreconditionInner("age", null);
	}

	@Test
	public void testLocalPreconditions() {
		List<String> resultList = Lists.newArrayList();
		buildPerson(resultList, 3);

	}

	private void buildPerson(List<String> resultList, int i) {
		Preconditions.checkPositionIndex(i, resultList.size(), "索引值不能大于List的个数");
		Preconditions.checkElementIndex(i, resultList.size());
	}

	@Test
	public void Preconditions() throws Exception {

		getPersonByPrecondition(8, "peida");

		try {
			getPersonByPrecondition(-9, "peida");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			getPersonByPrecondition(8, "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			getPersonByPrecondition(8, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			try {
				checkState(intList, 9);
				intList.add(i);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		try {
			checkPositionIndex(intList, 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkPositionIndex(intList, 13);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkPositionIndexes(intList, 3, 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkPositionIndexes(intList, 3, 17);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkPositionIndexes(intList, 13, 17);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkElementIndex(intList, 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			checkElementIndex(intList, 16);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getPersonByPrecondition(int age, String neme) throws Exception {
		Preconditions.checkNotNull(neme, "neme为null");
		Preconditions.checkArgument(neme.length() > 0, "neme为\'\'");
		Preconditions.checkArgument(age > 0, "age 必须大于0");
		System.out.println("a person age:" + age + ",neme:" + neme);

	}

	public static void checkState(List<Integer> intList, int index) throws Exception {
		// 表达式为true不抛异常
		Preconditions.checkState(intList.size() < index, " intList size 不能大于" + index);
	}

	public static void checkPositionIndex(List<Integer> intList, int index) throws Exception {
		Preconditions.checkPositionIndex(index, intList.size(),
				"index " + index + " 不在 list中， List size为：" + intList.size());
	}

	public static void checkPositionIndexes(List<Integer> intList, int start, int end) throws Exception {
		Preconditions.checkPositionIndexes(start, end, intList.size());
	}

	public static void checkElementIndex(List<Integer> intList, int index) throws Exception {
		Preconditions.checkElementIndex(index, intList.size(),
				"index 为 " + index + " 不在 list中， List size为： " + intList.size());
	}
}
