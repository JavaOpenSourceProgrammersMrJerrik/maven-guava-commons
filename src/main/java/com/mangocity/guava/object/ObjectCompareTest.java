package com.mangocity.guava.object;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Ints;

public class ObjectCompareTest {

	private static class Person implements Comparable<Person> {
		private String name;
		private Long age;
		

		public Person() {
			super();
		}
		
		public Person(String name, Long age) {
			this.name = Preconditions.checkNotNull(name);
			this.age = Preconditions.checkNotNull(age);;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getAge() {
			return age;
		}

		public void setAge(Long age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("name", name).add("age", age).toString();
		}

		@Override
		public int compareTo(Person p) {
			return ComparisonChain.start().
					compare(this.age, p.age).compare(this.name, p.name).result();
		}
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("Jerrik",24L);
		Person p2 = new Person("Aerrik",25L);
		System.out.println(p1.compareTo(p2));
	}
}
