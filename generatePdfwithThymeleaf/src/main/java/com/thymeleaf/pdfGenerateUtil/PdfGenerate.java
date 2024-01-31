package com.thymeleaf.pdfGenerateUtil;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;

@Component
public class PdfGenerate {

    @Autowired
    private TemplateEngine templateEngine;

    public String createPdf(String templateName, Map map) throws IOException, DocumentException {

        String fileNameUrl = "";

        Context ctx = new Context();

        if (map != null) {

            Iterator itMap = map.entrySet().iterator();

            while (itMap.hasNext()) {

                Map.Entry pair = (Map.Entry) itMap.next();

                ctx.setVariable(pair.getKey().toString(), pair.getValue());

            }

        }

        String processedHtml = templateEngine.process(templateName, ctx);

        FileOutputStream os = null;

        assert map != null;
        String customerId = map.get("id").toString();

        try {

            final File outputFile = File.createTempFile("Student_"+customerId+"_", ".pdf");

            os = new FileOutputStream(outputFile);

            ITextRenderer itr = new ITextRenderer();

            itr.setDocumentFromString(processedHtml);

            itr.layout();

            itr.createPDF(os, false);

            itr.finishPDF();

            fileNameUrl = outputFile.getName();

        }

        finally {

            if (os != null) {

                try {

                    os.close();

                } catch (IOException ignored) { }

            }

        }

        return fileNameUrl;

    }

}

