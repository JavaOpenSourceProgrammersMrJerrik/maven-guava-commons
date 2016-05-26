package com.mangocity.guava.optional;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
 * Optional.absent()：获得一个Optional对象，其内部包含了空值
 * Optional.fromNullable(T)：将一个T的实例转换为Optional对象
 * ，T的实例可以不为空，也可以为空[Optional.fromNullable(null)，和Optional.absent()等价。
 */
public class OptionalTest {

	public static void testOptional() throws Exception {
		String name = null;
		Optional<String> possibleName = Optional.of(name);
		Optional<Integer> possible = Optional.of(6);
		// Present中的isPresent()为true,Absent中的isPresent()为false
		if (possible.isPresent()) {// isPresent()来判断是否返回了期望的值（原本期望返回null或者返回不为null，其意义不清晰）
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
	}

	public static void main(String[] args) throws Exception {
		testOptional();
	}

	@Test
	public void testOptional2() throws Exception {
		Optional<Integer> possible = Optional.of(6);
		Optional<Integer> absentOpt = Optional.absent();// fromNullable一样,可以为空
		Optional<Integer> NullableOpt = Optional.fromNullable(null);// 如果不为空,和of()等价,为空,和absent()等价
		Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
		if (possible.isPresent()) {//永远是true
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
		if (absentOpt.isPresent()) {
			System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
		}
		if (NullableOpt.isPresent()) {
			System.out.println("fromNullableOpt isPresent:"
					+ NullableOpt.isPresent());
		}
		if (NoNullableOpt.isPresent()) {
			System.out.println("NoNullableOpt isPresent:"
					+ NoNullableOpt.isPresent());
		}
	}
}
