package com.mangocity.guava.object;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class ObjectToStringTest {

	private static class Person {
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
	}
	
	public static void main(String[] args) {
		System.out.println(new Person("Jerrik",25L));
	}
}
