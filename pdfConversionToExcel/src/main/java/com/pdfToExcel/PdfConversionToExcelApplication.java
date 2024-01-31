package com.pdfToExcel;

import com.aspose.pdf.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class PdfConversionToExcelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PdfConversionToExcelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Document doc = new Document("C:\\Users\\SSLTP11229\\Desktop\\D\\dat.pdf");


		doc.save("C:\\Users\\SSLTP11229\\Desktop\\D\\workbook.xls", SaveFormat.Excel);


	}

}

