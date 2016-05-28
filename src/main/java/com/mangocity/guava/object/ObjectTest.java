package com.mangocity.guava.object;

import org.junit.Test;

import com.google.common.base.Objects;

public class ObjectTest {

	@Test
	public void equalTest() {
		System.out.println(Objects.equal("a", "a"));
		System.out.println(Objects.equal(null, "a"));
		System.out.println(Objects.equal("a", null));
		System.out.println(Objects.equal(null, null));
	}

	@Test
	public void equalPersonTest() {
		System.out.println(Objects.equal(new Person("peida", 23), new Person("peida", 23)));// 去掉equals和hashCode结果不同
		Person person = new Person("peida", 23);
		System.out.println(Objects.equal(person, person));
	}

	@Test
	public void hashcodeTest() {
		System.out.println(Objects.hashCode("a"));
		System.out.println(Objects.hashCode("a"));
		System.out.println(Objects.hashCode("a", "b"));
		System.out.println(Objects.hashCode("b", "a"));
		System.out.println(Objects.hashCode("a", "b", "c"));

		Person person = new Person("peida", 23);
		System.out.println(Objects.hashCode(person));
		System.out.println(Objects.hashCode(person));
	}
}

class Person {
	public String name;
	public int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}