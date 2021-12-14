package com.test.simplefileparser.reader;

import java.util.stream.Stream;

public interface IReader {


	public Stream<String> readFile(String filePath);
	
}
