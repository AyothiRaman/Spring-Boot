import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            // Load the PDF file
            FileInputStream pdfFile = new FileInputStream(new File("example.pdf"));
            PDDocument document = PDDocument.load(pdfFile);

            // Initialize PDFTextStripper
            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            // Extract text from the PDF
            String pdfText = pdfTextStripper.getText(document);

            // Create a new Excel workbook and sheet
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("PDFData");

            // Split the extracted text into rows and columns (assuming each line is a row)
            String[] lines = pdfText.split("\n");

            // Iterate through the lines and add them to the Excel sheet
            int rowNum = 0;
            for (String line : lines) {
                Row row = sheet.createRow(rowNum++);
                String[] columns = line.split("\t");  // Assuming tab-separated data, modify as needed

                for (int i = 0; i < columns.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(columns[i]);
                }
            }

            // Write the Excel workbook to a file
            FileOutputStream excelFile = new FileOutputStream("output.xlsx");
            workbook.write(excelFile);
            excelFile.close();

            // Close the PDF document
            document.close();

            System.out.println("PDF data has been successfully converted to an Excel file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}