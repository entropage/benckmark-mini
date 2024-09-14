package com.entropool.benchmark.xslt.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller

public class XSLTController {
    @RequestMapping(value = "/TransformerFactoryXSLT")
    public ResponseEntity<byte[]> transformXML(@RequestBody String xsltString) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new ByteArrayInputStream(xsltString.getBytes())));
            String xmlString = "<root><element>Value</element></root>";
            ByteArrayInputStream xmlInputStream = new ByteArrayInputStream(xmlString.getBytes());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            transformer.transform(new StreamSource(xmlInputStream), new StreamResult(outputStream));
            return ResponseEntity.status(200)
                    .body(outputStream.toByteArray());
        } catch (TransformerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
