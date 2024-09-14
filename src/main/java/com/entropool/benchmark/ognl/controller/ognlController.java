package com.entropool.benchmark.ognl.controller;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@Controller
public class ognlController {
    @RequestMapping(value = "/ognlGetValue1")
    public String ognlGetValue(@RequestParam String value) throws OgnlException {
        OgnlContext context = new OgnlContext();
        Object ognl = Ognl.parseExpression(value);
        Ognl.getValue(ognl,context,context.getRoot());
        return "success";
    }

    @RequestMapping(value = "/ognlGetValue2")
    public String ognlGetValue2(@RequestParam String value) throws OgnlException, IOException {
        OgnlContext context = new OgnlContext();
        Ognl.getValue(value,context,context.getRoot());
        return "success";
    }

    @RequestMapping(value = "/ognlSetValue")
    public String ognlSetValue(@RequestParam String value) throws OgnlException {
        OgnlContext context = new OgnlContext();
        Ognl.setValue(value,context,context.getRoot(),"test");
        return "success";
    }


}
