package com.test.simplefileparser.statprocessor;

import java.util.stream.Stream;

public interface IStatProcessor {

	Long processForStat(Stream<String> stream);

	String getProcessorName();
	
}
