package com.test.simplefileparser.statprocessor.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.simplefileparser.statprocessor.IStatProcessor;

public class SpecialCharCountProcessor implements IStatProcessor {


	public String processorName;

	public SpecialCharCountProcessor() {
		processorName = "Special Char Count";
	}
	@Override
	public Long processForStat(Stream<String> fileLines) {
		 Long specialCharCounter= 0L;
		List<String> inputStringList =  fileLines.flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
				.collect(Collectors.toList());
		for (String inputString:inputStringList) {
			specialCharCounter += countSpecialChar(inputString);
		}
		return specialCharCounter;
	}

	private Long countSpecialChar(String inputString) {
		Long counter = 0L;
		for (int i = 0; i < inputString.length(); i++) {
			if (!Character.isDigit(inputString.charAt(i))
					&& !Character.isLetter(inputString.charAt(i))
					&& !Character.isWhitespace(inputString.charAt(i))) {
				// Incrementing the countr for spl
				// characters by unity
				counter++;
			}
		}
		return counter;
	}

	@Override
	public String getProcessorName() {
		return processorName;
	}

}
