package com.framework.utilities;

public class ReadPdfMain {
	public static void main(String[] args) {

		String documentText = PdfUtil.data("Hello.pdf");
		System.out.println(documentText);

	}

}
