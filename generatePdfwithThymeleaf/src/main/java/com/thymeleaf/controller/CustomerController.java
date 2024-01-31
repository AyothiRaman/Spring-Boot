package com.thymeleaf.controller;

import com.thymeleaf.entity.CustomerEntity;
import com.thymeleaf.pdfGenerateUtil.PdfGenerate;
import com.thymeleaf.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired

    private CustomerRepository customerRepository;

    @Autowired

    private PdfGenerate pdfGenerate;

    @GetMapping("hell")
    public String hello(){
        return "heloo buddy";
    }

    @GetMapping("student/{id}")
    public ResponseEntity getStudentInfoPdf(@PathVariable Integer id) throws Exception {

        CustomerEntity customer = customerRepository.findById(id).orElse(null);

        if(customer == null)

            throw new Exception("Student not present");

        Map<String,Object> customerMap = new HashMap<>();

        customerMap.put("ID",customer.getId());

        customerMap.put("Name",customer.getName());

        customerMap.put("Location",customer.getLocation());

        customerMap.put("City",customer.getCity());

        Resource resource = null;

        try {

            String property = "java.io.tmpdir";

            String tempDir = System.getProperty(property);

            String fileNameUrl = pdfGenerate.createPdf("Student", customerMap);

            Path path = Paths.get(tempDir+"/" + fileNameUrl);

            resource = new UrlResource(path.toUri());

        } catch (Exception e) {

            e.printStackTrace();

        }

        return ResponseEntity.ok()

                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_PDF_VALUE))

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")

                .body(resource);

    }

}


