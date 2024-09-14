package com.entropool.benchmark.ELInject.controller;

import org.apache.commons.jxpath.JXPathContext;
import org.owasp.esapi.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JxPathController {
    public static class User {
        String name;

    }
    @RequestMapping("/jxpath")
    public String jxpath(@RequestParam String value) {
        JXPathContext jxPathContext = JXPathContext.newContext(new User());
        jxPathContext.getValue(value);
        return "success";
    }

}
