package com.mangocity.guava.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.io.Files;

public class FileTest {

	@Test
	public void testMoveFiles() throws IOException{
		Files.move(new File("1.txt"),new File("2.txt"));
	}
	
	@Test
	public void testReadLines() throws IOException{
		List<String> resultList = Files.readLines(new File("2.txt"), Charsets.UTF_8);
		System.out.println(resultList);
	}
	
	@Test
	public void testAppendFiles() throws IOException{
		Files.append("\r\n bad boy.", new File("2.txt"), Charsets.UTF_8);
	}
	
	@Test
	public void testFileHash() throws IOException{
		HashCode  hashCode = Files.hash(new File("2.txt"), null);
		System.out.println(hashCode);
	}
}
