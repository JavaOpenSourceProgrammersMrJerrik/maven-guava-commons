package com.mangocity.guava.object;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class ObjectMixedTest {

	public static void main(String[] args) {
		Person p1 = new Person("bob",12L);
		Person p2 = new Person("bob1",12L);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1.compareTo(p2): " + p1.compareTo(p2));
		System.out.println("p1 hashCode(): " + p1.hashCode());
		System.out.println("p2 hashCode(): " + p2.hashCode());
	}

	private static class Person implements Comparable<Person> {
		private String name;
		private Long age;

		public Person(String name, Long age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Person o) {
			return ComparisonChain.start().compare(this.name, o.name).compare(this.age, o.age,
					Ordering.natural().nullsLast()).result();
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name, age);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Person) {
				Person p = (Person) obj;
				return Objects.equal(this.name, p.name) && Objects.equal(this.age, p.age);
			}
			return false;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("name", name).add("age", age).toString();
		}
	}

}
