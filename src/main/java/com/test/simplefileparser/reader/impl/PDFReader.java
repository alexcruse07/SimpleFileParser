package com.test.simplefileparser.reader.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.test.simplefileparser.reader.IReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader implements IReader {

	@Override
	public Stream<String> readFile(String filePath) {
		try (PDDocument document = PDDocument.load(new File(filePath))) {

			document.getClass();

			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);

				PDFTextStripper tStripper = new PDFTextStripper();

				String pdfFileInText = tStripper.getText(document);

				String lines[] = pdfFileInText.split("\\r?\\n");

				return (Stream<String>) Arrays.stream(lines);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

}
