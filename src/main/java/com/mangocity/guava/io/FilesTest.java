package com.mangocity.guava.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class FilesTest {

	@Test
	public void testFilesWrite() throws IOException {
		String str = "hello world\r\nbad girl";// \r\n换行符
		final File newFile = new File("1.txt");
		Files.write(str.getBytes(), newFile);
	}

	@Test
	public void testFilesReadLine() throws IOException {
		List<String> readLineList = Files.readLines(new File("1.txt"),
				Charsets.UTF_8);
		System.out.println(readLineList);

	}
}
