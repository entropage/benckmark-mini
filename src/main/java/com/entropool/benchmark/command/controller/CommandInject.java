package com.entropool.benchmark.command.controller;

import bsh.EvalError;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import bsh.Interpreter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class CommandInject {
    @RequestMapping(value = "/RuntimeEcho")
    public String command(@RequestParam String shell) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(shell);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        int exitCode = process.waitFor();
        return "Command output:\n" + output.toString() + "\nExit code: " + exitCode;
    }

    @RequestMapping(value = "/ProcessBuilder")
    public String ProcessBuilder(@RequestParam String v1,@RequestParam String v2) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(v1, v2);
        Process process = processBuilder.start();
        return "sucess";
    }
    @RequestMapping(value = "/Beanshell")
    public String Beanshell(@RequestParam String shell) throws IOException, InterruptedException, EvalError {
        Interpreter interpreter = new Interpreter();
        interpreter.eval(shell);
        return "sucess";
    }


}
