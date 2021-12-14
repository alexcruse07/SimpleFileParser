package com.test.simplefileparser.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.test.simplefileparser.reader.IReader;

public class TextReader implements IReader {

	@Override
	public Stream<String> readFile(String filePath) {
		try {
			return Files.lines(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
