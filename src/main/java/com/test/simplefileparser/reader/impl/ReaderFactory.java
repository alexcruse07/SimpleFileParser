package com.test.simplefileparser.reader.impl;

import com.test.simplefileparser.reader.IReader;

public class ReaderFactory {

    public static IReader buildReader(String fileExtension)
    {
        IReader iReader = null;
        switch (fileExtension) {
            case "pdf":
                iReader = new PDFReader();
                break;
            case "txt":
                iReader = new TextReader();
                break;
        }
        return iReader;
    }

}
