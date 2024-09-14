package com.entropool.benchmark.ELInject.controller;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.util.Eval;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.mvel2.MVEL;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/EL")
public class ELInjectController {
    @PostMapping(value = "/juel")
    public void juel(@RequestParam String shell) {
        ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
        SimpleContext simpleContext = new SimpleContext();
        ValueExpression valueExpression = expressionFactory.createValueExpression(simpleContext, shell, String.class);
        valueExpression.getValue(simpleContext);
    }


    @PostMapping(value = "/SPElBypassQuote")
    public String SPElBypassQuote(@RequestParam String shell) {
        if (shell.contains("'"))
        {
            shell = shell.replace("'", "\"");
        }
        if(shell.contains("\""))
        {
            shell = shell.replace("\"", "'");
        }
        StandardEvaluationContext standardContext = new StandardEvaluationContext();
        String result = (String) new SpelExpressionParser().parseExpression(shell).getValue(standardContext);
        return result;
    }

    @PostMapping(value = "/SPElBypassT")
    public String SPElBypassT(@RequestParam String shell)
    {
        if (shell.contains("T(")|| shell.contains("new "))
        {
            return "error";
        }
        StandardEvaluationContext standardContext = new StandardEvaluationContext();
        String result = (String) new SpelExpressionParser().parseExpression(shell).getValue(standardContext);
        return result;
    }

    @PostMapping(value = "/SPElBypassClass")
    public String SPElBypassClass(@RequestParam String shell) {
        if (shell.contains("java.lang.Runtime")) {
            return "error";
        }
        StandardEvaluationContext standardContext = new StandardEvaluationContext();
        String result = (String) new SpelExpressionParser().parseExpression(shell).getValue(standardContext);
        return result;
    }

    @PostMapping(value = "/JEXl")
    public void JEXl(@RequestParam String shell) {
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression expression = engine.createExpression(shell);
        Object evaluate = expression.evaluate(new MapContext());
        System.out.println(evaluate);
    }

    @PostMapping(value = "/JEXlBypassQuote")
    public void JEXlBypassQuote(@RequestParam String shell) {
        if (shell.contains("'")) {
            shell = shell.replace("'", "\"");
        }
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression expression = engine.createExpression(shell);
        Object evaluate = expression.evaluate(new MapContext());
        System.out.println(evaluate);

    }

    @PostMapping(value = "/JEXlBypassNew")
    public void JEXlBypassNew(@RequestParam String shell) {
        if (shell.contains("new(")) {
            shell = shell.replace("new(", " ");
        }
        JexlEngine engine = new JexlBuilder().create();
        JexlExpression expression = engine.createExpression(shell);
        Object evaluate = expression.evaluate(new MapContext());
        System.out.println(evaluate);
    }


    @PostMapping(value = "/MVELEval")
    public String MVELEval(@RequestParam String shell) {
        String result = (String) MVEL.eval(shell);
        System.out.println(result);
        return result;
    }

    @PostMapping(value = "/GroovyClassLoad")
    public String GroovyClassLoad(@RequestParam String shell) throws InstantiationException, IllegalAccessException
    {
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class clazz = classLoader.parseClass(shell);
        GroovyObject object = (GroovyObject) clazz.newInstance();
        Object result = object.invokeMethod("run", null);
        return result.toString();
    }


    @PostMapping("/GroovySource")
    public  String GroovySource(@RequestParam URL url)
    {
        GroovyShell shell = new GroovyShell();
        GroovyCodeSource gcs = new GroovyCodeSource(url);
        shell.evaluate(gcs);
        return "success";
    }


    @PostMapping("/GroovyRun")
    public String GroovyRun(@RequestParam String cmdStr) throws IOException {
        GroovyShell shell = new GroovyShell();
        File scriptFile = new File("script.groovy");
        try (FileWriter writer = new FileWriter(scriptFile)) {
            writer.write(cmdStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object result = shell.run(scriptFile, Collections.singletonList("MyScript"));
        return "success";
    }


}
