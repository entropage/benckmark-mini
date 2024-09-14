package com.entropool.benchmark.ELInject.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Controller
public class OfbizGroovyElController {
    @RequestMapping("/groovy/Ofbiz.groovy")
    @ResponseBody
    public String handleTestGroovyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String scriptPath = "groovy/Ofbiz.groovy";
        ClassPathResource resource = new ClassPathResource(scriptPath);
        if (!resource.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "Groovy script not found: " + scriptPath;
        }
        String scriptContent;
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream())) {
            char[] buffer = new char[1024];
            StringBuilder builder = new StringBuilder();
            int numRead;
            while ((numRead = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, numRead);
            }
            scriptContent = builder.toString();
        }
        Binding binding = new Binding();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            binding.setVariable(entry.getKey(), entry.getValue()[0]);
        }
        binding.setVariable("request", request);
        binding.setVariable("response", response);
        GroovyShell shell = new GroovyShell(binding);
        Object result = shell.evaluate(scriptContent);
        return result != null ? result.toString() : "";
    }
}
