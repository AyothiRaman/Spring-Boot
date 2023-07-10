package com.generate.pdfController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generate.service.PdfServiceUtils;
import com.itextpdf.text.DocumentException;

@Controller
@RequestMapping("/api")
public class PdfController {
	
	 @Autowired
	    PdfServiceUtils pdfUtilsService;

	    @GetMapping("/create")
	    public ResponseEntity<ByteArrayInputStream> createPdf() throws IOException, DocumentException, URISyntaxException {
	        ByteArrayInputStream pdf = pdfUtilsService.pdfWriter();

	        return ResponseEntity.ok()
	                .header("hello", "world")
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(pdf);
	    }

}
