package com.generate.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.itextpdf.text.pdf.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.itextpdf.text.*;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

@Service
public class PdfServiceUtils {

    static Document document = new Document(PageSize.A4);

    public ByteArrayInputStream pdfWriter() throws IOException, DocumentException, URISyntaxException {

        Paragraph paragraph = new Paragraph();


        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SSLTP11229\\Desktop\\text\\World.pdf"));


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final byte[] bytes = out.toByteArray();
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(" WELCOME SUN ", font);


        document.add(chunk);
        document.add(new Paragraph("\n"));

        // To add a Image
        Image img = Image.getInstance("C:\\Users\\SSLTP11229\\Desktop\\image\\sun.png");

        document.add(new Paragraph("The Sun is a 4.5 billion-year-old yellow dwarf star – " +
                "a hot glowing ball of hydrogen and helium – at the center of our solar system"));


        document.add(img);
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));


        // Add Link to the pdf
        document.add(new Paragraph("Link to Visit openAI page"));

        Font linkFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE, new BaseColor(0, 0, 255));
        Anchor anchor = new Anchor("Click Here", linkFont);
        anchor.setReference("https://openai.com");
        paragraph.add(anchor);

        // Add the paragraph to the document
        document.add(paragraph);


        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        // Create a table with 3 columns
        document.newPage();

        PdfPTable table = new PdfPTable(3);

        table.addCell(createHeaderCell("Column 1", BaseColor.ORANGE));
        table.addCell(createHeaderCell("Column 2", BaseColor.GRAY));
        table.addCell(createHeaderCell("Column 3", BaseColor.CYAN));

        // Add table headers
        table.addCell("id");
        table.addCell("First_Name");
        table.addCell("Last_Name");

        // Add table rows
        table.addCell("1001");
        table.addCell("Ayothi");
        table.addCell("Raman");

        table.addCell("1002");
        table.addCell("Sara");
        table.addCell("Khan");

        table.addCell("1003");
        table.addCell("Dhru");
        table.addCell("Dear");

        document.add(table);

        document.close();
        System.out.println("Done");



        return new ByteArrayInputStream(bytes);

    }

    private PdfPCell createHeaderCell(String text, BaseColor backgroundColor) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(backgroundColor);
        cell.setPhrase(new Phrase(text));
        return cell;
    }

}