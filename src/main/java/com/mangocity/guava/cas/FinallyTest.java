package com.mangocity.guava.cas;

public class FinallyTest {

	public static void main(String[] args) {
		System.out.println("return: " + returnInt());
		System.out.println("test: " + test());
	}
	
	public static int returnInt(){
		int i = 1;
		try {
			i++;
			System.out.println("干啥。。" + i);
			return i;
		} catch (Exception e) {
			i = i+3;
			System.out.println("exception.." + i);
			return i;
		}finally{
			i++;
			System.out.println("finally。。" + i);
			return i;
		}
	}
	
	static int test()
	{
		int x = 1;
		try
		{
			x++;
			return x;
		}
		finally
		{
			++x;
		}
	}

}
