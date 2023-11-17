package com.raka.textextractor.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TextOCR {

	public static void main(String[] args) {
		ITesseract tesseract = new Tesseract();
		
		try {
			tesseract.setDatapath("D:\\Tesseract-OCR\\tessdata");
			
			String text = tesseract.doOCR(new File("C:\\Users\\RAKESH KUMAR\\Pictures\\Screenshots\\certificate.png"));
			
			FileWriter out = new FileWriter(new File("D:\\Tesseract-OCR\\data\\text.txt"));
			
			BufferedWriter writer = new BufferedWriter(out);
			
			writer.write(text);
			
			writer.close();
		}
		catch(TesseractException | IOException e) {
			e.printStackTrace();
		}

	}

}
