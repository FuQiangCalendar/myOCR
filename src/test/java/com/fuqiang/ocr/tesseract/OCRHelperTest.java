package com.fuqiang.ocr.tesseract;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuqiang.ocr.utils.ClearImageHelper;

public class OCRHelperTest {
	@Test
	public void test01 () {
		try {
			File testDataDir = new File("E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\test01.jpg");
			System.out.println(testDataDir.listFiles().length);
			int i = 0;
			for (File file : testDataDir.listFiles()) {
				i++;
				String recognizeText = new OCRHelper().recognizeText(file);
				System.out.print(recognizeText + "\t");

				if (i % 5 == 0) {
					System.out.println();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02 () {
		try {
			File testFile = new File("E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\喝红酒.jpg");
			String recognizeText = new OCRHelper().recognizeText(testFile);
			System.out.print(recognizeText + "\t");
			ClearImageHelper.cleanImage(testFile, 
					"E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\ocr1");
			testFile = new File("E:\\tools\\Tesseract-OCR\\tessdata\\temp\\img\\ocr1\\喝红酒.jpg");
			recognizeText = new OCRHelper().recognizeText(testFile);
			System.out.print(recognizeText + "\t");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
