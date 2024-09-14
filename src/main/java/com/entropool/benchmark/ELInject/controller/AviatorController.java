package com.entropool.benchmark.ELInject.controller;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;
import com.mysql.cj.CacheAdapterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
@Controller
public class AviatorController {
    @RequestMapping("/AviatorTest")
    public String AviatorTest(@RequestParam String shell)
    {
        AviatorEvaluatorInstance evaluator = AviatorEvaluator.newInstance();
        evaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        evaluator.execute(shell);
        return "success";
    }

    @RequestMapping("/AviatorTest2")
    public String AviatorTest2(@RequestParam String shell)
    {
        AviatorEvaluatorInstance evaluator = AviatorEvaluator.newInstance();
        evaluator.execute(shell);
        return "success";
    }

    @RequestMapping("/AviatorTest3")
    public String AviatorTest3(@RequestParam String shell) throws ScriptException {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine engine = m.getEngineByName("aviator");
        engine.eval(shell);
        return "success";
    }

}
