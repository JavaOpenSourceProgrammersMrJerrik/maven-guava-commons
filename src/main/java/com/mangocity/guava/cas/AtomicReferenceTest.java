package com.mangocity.guava.cas;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	static class ReferenceObject{
		private Integer id;
		private String userName;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		@Override
		public String toString() {
			return "ReferenceObject [id=" + id + ", userName=" + userName + "]";
		}
	}

	public static void main(String[] args) {
		ReferenceObject obj = new ReferenceObject();
		obj.setId(1);
		obj.setUserName("hello");
		
		ReferenceObject obj2 = new ReferenceObject();
		obj2.setId(2);
		obj2.setUserName("jerrik");
		
		AtomicReference<ReferenceObject> reference = new AtomicReference<ReferenceObject>();
		reference.set(obj);
		
		reference.compareAndSet(obj, obj2);
		
		System.out.println(reference.get().getUserName());
		
		
	}

}
