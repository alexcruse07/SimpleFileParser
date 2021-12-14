package com.test.simplefileparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.simplefileparser.config.SimpleFileParserConfig;

@SpringBootApplication
public class SimpleFileParserApplication {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.println("Enter source path : ");
		// Reading data using readLine
		String sourcePath = reader.readLine();

		SimpleFileParserConfig.sourcePath = sourcePath;
		File destPath = new File(SimpleFileParserConfig.sourcePath+"/"+"processed");
		destPath.mkdir();
		SimpleFileParserConfig.destPath = destPath.getPath();
		SpringApplication.run(SimpleFileParserApplication.class, args);
	}

}
