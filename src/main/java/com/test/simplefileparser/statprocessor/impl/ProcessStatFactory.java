package com.test.simplefileparser.statprocessor.impl;


import com.test.simplefileparser.statprocessor.IStatProcessor;
import com.test.simplefileparser.statprocessor.StatType;

public class ProcessStatFactory {

    public static IStatProcessor buildStatProcessor(StatType statType)
    {
        IStatProcessor iStatProcessor = null;
        switch (statType) {
            case WORD_COUNT:
                iStatProcessor = new WordCountProcessor();
                break;
            case SPECIAL_CHAR_COUUNT:
                iStatProcessor = new SpecialCharCountProcessor();
                break;
        }
        return iStatProcessor;
    }


}
