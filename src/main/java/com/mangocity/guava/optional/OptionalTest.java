package com.mangocity.guava.optional;

import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
 * Optional.absent()：获得一个Optional对象，其内部包含了空值
 * Optional.fromNullable(T)：将一个T的实例转换为Optional对象
 * T的实例可以不为空，也可以为空[Optional.fromNullable(null)，和Optional.absent()等价。
 * Optional.fromNullable(T).or(E):如果T为null,则返回E.如果T不为null,则返回T
 */
public class OptionalTest {
	
	/**
	 *  a: 3
		b: 1
		r: 7
		w: 4
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Long i = null;
		Long a = Optional.fromNullable(i).or(3L);
		System.out.println("a: " + a);
		
		Long j = 1L;
		Long b = Optional.fromNullable(j).or(2L);
		System.out.println("b: " + b);
		
		Long n = null;
		Long r = Optional.fromNullable(n).or(7L);
		System.out.println("r: " + r);
		
		Long m = 4L;
		Long w = Optional.fromNullable(m).or(6L);
		System.out.println("w: " + w);
	}

	@Test
	public  void testOptional1() throws Exception {
		String name = null;
		Optional<String> possibleName = Optional.of(name);
		Optional<Integer> possible = Optional.of(6);
		// Present中的isPresent()为true,Absent中的isPresent()为false
		if (possible.isPresent()) {// isPresent()来判断是否返回了期望的值（原本期望返回null或者返回不为null，其意义不清晰）
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
	}

	@Test
	public void testOptional2() throws Exception {
		Optional<Integer> possible = Optional.of(6);
		Optional<Integer> absentOpt = Optional.absent();// fromNullable一样,可以为空
		Optional<Integer> NullableOpt = Optional.fromNullable(null);// 如果不为空,和of()等价,为空,和absent()等价
		Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
		if (possible.isPresent()) {// 永远是true
			System.out.println("possible isPresent:" + possible.isPresent());
			System.out.println("possible value:" + possible.get());
		}
		if (absentOpt.isPresent()) {
			System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
		}
		if (NullableOpt.isPresent()) {
			System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());
		}
		if (NoNullableOpt.isPresent()) {
			System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());
		}
	}

	@Test
	public void testOptional3() {
		Optional<Long> value = Optional.fromNullable(null);
		if (value.isPresent()) {
			System.out.println("获得返回值: " + value.get());
		} else {
			System.out.println("获得返回值: " + value.or(-12L));// 如果是Absent对象,or(T):
															// T如果为空,则抛出异常,否则返回T.如果是Present,T如果不为空,则返回of(E)对应的E
		}
		System.out.println("获得返回值 orNull: " + value.orNull());// 如果是Absent,则返回Null.如果是Present,则返回of(E)对应的E
		Optional<Long> valueNoNull = Optional.fromNullable(15L);
		if (valueNoNull.isPresent()) {
			Set<Long> set = valueNoNull.asSet();// 转成set
			System.out.println("获得返回值 set 的 size : " + set.size());
			System.out.println("获得返回值: " + valueNoNull.get());
		} else {
			System.out.println("获得返回值: " + valueNoNull.or(-12L));
		}
		System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
	}

	@Test
	public void testOptional4() {
		Optional<Long> optionalLong = Optional.of(1L);
		System.out.println("of(1L)=isPresent(): " + optionalLong.isPresent() + " ,get(): " + optionalLong.get()
				+ " ,or(3L): " + optionalLong.or(3L) + " ,orNull(): " + optionalLong.orNull());
		System.out.println("88888888888888888888888888888888888888888888888888888888");
		Optional<Long> optionalLong2 = Optional.of(0L);
		System.out.println("of(0L)=isPresent(): " + optionalLong2.isPresent() + " ,get(): " + optionalLong2.get()
				+ " ,or(3L): " + optionalLong2.or(3L) + " ,orNull(): " + optionalLong2.orNull());

		System.out.println("88888888888888888888888888888888888888888888888888888888");
		Optional<Long> optionalLong3 = Optional.absent();// 空引用
		// 如果是absent(),则get()会抛出IllegalStateException
		System.out.println("absent()=isPresent(): " + optionalLong3.isPresent() + " ,or(3L): " + optionalLong3.or(3L)
				+ " ,orNull(): " + optionalLong3.orNull());
	}

	@Test
	public void testOptional5() {
		sayHello("Jerrik");
		sayHello(null);
	}

	/**
	 * or用法 文艺青年说：Hello, Jerrik 文艺青年说：Hello, 火星人
	 * 
	 * @param name
	 */
	public void sayHello(String name) {
		name = Optional.fromNullable(name).or("火星人");// or主要针对absent返回。都不能为空
		System.out.println("文艺青年说：Hello, " + name);
	}
	
	@Test
	public void testHelloWorld(){
		doHelloWorld(null);
		doHelloWorld("Hi Hi Hi ~~");
	}
	
	public void doHelloWorld(String userName){
		String ruserName = Optional.fromNullable(userName).or("默认打招呼...");
		System.out.println("userName: " + ruserName);
		
		System.out.println("88888888888888888888888888888888888888888888888888888888");
		userName = Optional.fromNullable(userName).orNull();//如果是absent,返回null.否则返回reference
		System.out.println("userName: " + userName);
		
		System.out.println("88888888888888888888888888888888888888888888888888888888");
		userName = Optional.fromNullable(userName).or(userName);
		System.out.println("userName: " + userName);
	}

}
