package com.entropool.benchmark.Deserialize.controller;

import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Xstream")
public class Xstream {
    /*
     * Content-Type: application/xml
     */
    @RequestMapping(value = "/NoEchoXstreamRequestBody", method = RequestMethod.POST)
    public String NoEchoXstreamRequestBody(@RequestBody String xml) {
        XStream xstream = new XStream();
        xstream.fromXML(xml);
        return "ok";
    }


}
