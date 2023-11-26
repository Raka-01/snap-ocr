package com.raka.textextractor.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TextOCR {
	private String imageFilePath;
	private String textFilePath;
	
	public TextOCR(String imageFilePath, String textFilePath) {
		this.imageFilePath = imageFilePath;
		this.textFilePath = textFilePath;
	}
	
	public void runOCR() throws TesseractException, IOException {
		ITesseract tesseract = new Tesseract();
		
		tesseract.setDatapath("D:\\Tesseract-OCR\\tessdata");
		
		String text = tesseract.doOCR(new File(imageFilePath));
		
		FileWriter out = new FileWriter(new File(textFilePath));
		
		BufferedWriter writer = new BufferedWriter(out);
		
		writer.write(text);
		
		writer.close();
		
	}

}
