package com.test.simplefileparser.statprocessor.impl;

import java.util.stream.Stream;

import com.test.simplefileparser.statprocessor.IStatProcessor;

public class WordCountProcessor implements IStatProcessor {

	public String processorName;

	public WordCountProcessor() {
		processorName = "Word Count";
	}

	@Override
	public Long processForStat(Stream<String> fileLines) {
		Long wordsCount = fileLines.flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
				.filter(s->s.length()>0).count();
		return wordsCount;
	}

	@Override
	public String getProcessorName() {
		return processorName;
	}

}
