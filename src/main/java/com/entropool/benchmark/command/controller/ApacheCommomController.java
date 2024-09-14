package com.entropool.benchmark.command.controller;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApacheCommomController {

    @RequestMapping("/ApacheCommonTest")
    public String ApacheCommonTest(@RequestParam String shell)
    {
        StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        interpolator.replace(shell);
        return "OK";
    }

}
