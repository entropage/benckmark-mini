package com.entropool.benchmark.Deserialize.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

@Controller
@RequestMapping("/unsafeXMLDecoder")
public class UnsafeXMLDecoder {
    /*
    Content-Type: application/xml
     */
    @RequestMapping(value = "/unsafeXMLBody", method = RequestMethod.POST)
    public Object unsafeXMLTest(@RequestBody String xml) {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new ByteArrayInputStream(xml.getBytes())));
        Object obj = decoder.readObject();
        decoder.close();
        return obj;
    }
}
