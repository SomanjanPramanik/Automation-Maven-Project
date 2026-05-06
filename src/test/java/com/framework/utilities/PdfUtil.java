package com.framework.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfUtil {

	public static String data(String fileName) {
		String data = "";
		// accessing the file
		try (FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\pdf files\\" + fileName)) {
			// converting raw text data into byte for better memory optimization for bigger
			// PDF files
			byte[] dataConversion = file.readAllBytes();
			// Only the Document needs to be cleaned up!
			// new Loader class in 3.X version of pdf-box maven dependency
			
//			// 1. Grab just the first 20 bytes 
//			byte[] first20Bytes = Arrays.copyOfRange(dataConversion, 0, 20);
//
//			System.out.println("--- RAW BINARY (0s and 1s) ---");
//
//			// 2. Loop through each byte
//			for (byte b : first20Bytes) {
//			    // This forces Java to print the exact 8-bit binary sequence for each byte
//			    String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//			    System.out.println(binaryString);
//			}
//			
			try (PDDocument document = Loader.loadPDF(dataConversion)) {
				// getting text file from byte version of the document
				PDFTextStripper textInFile = new PDFTextStripper();
				// putting all text data in string type variable for accessing later
				data = textInFile.getText(document);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
