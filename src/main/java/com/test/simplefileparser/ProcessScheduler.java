package com.test.simplefileparser;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import com.test.simplefileparser.reader.IReader;
import com.test.simplefileparser.reader.impl.ReaderFactory;
import com.test.simplefileparser.statprocessor.IStatProcessor;
import com.test.simplefileparser.statprocessor.StatType;
import com.test.simplefileparser.statprocessor.impl.ProcessStatFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.test.simplefileparser.config.SimpleFileParserConfig;

@Configuration
@EnableScheduling
public class ProcessScheduler {

    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() throws IOException {
        System.out.println("Checking for files in Path : " + SimpleFileParserConfig.sourcePath);

        File directoryPath = new File(SimpleFileParserConfig.sourcePath);
        //List of all files and directories
        if (directoryPath != null) {
            List<String> contents = Arrays.asList(directoryPath.list());

            for (String file : contents) {
                String fileExtension = getExtension(file);
                String fileSourcePath = SimpleFileParserConfig.sourcePath + "/" + file;
                String fileDestPath = SimpleFileParserConfig.destPath + "/" + file;

                IReader iReader = ReaderFactory.buildReader(fileExtension);
                if (iReader != null) {
                    for (StatType statType : StatType.values()) {
                        IStatProcessor iStatProcessor = ProcessStatFactory.buildStatProcessor(statType);
                        Long count = iStatProcessor.processForStat(iReader.readFile(fileSourcePath));
                        System.out.println(iStatProcessor.getProcessorName() + " for file " + file + " : " + count);
                    }
                    Files.move(Paths.get(fileSourcePath), Paths.get(fileDestPath), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    public String getExtension(String filename) {
        return com.google.common.io.Files.getFileExtension(filename);
    }
}
