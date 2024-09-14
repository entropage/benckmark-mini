package com.entropool.benchmark.jndi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Controller
@RequestMapping("/jndi-demo")
public class JNDIDemoController {
    @PostMapping("/test")
    public void test(@RequestParam String name) throws NamingException {
        Context context = new InitialContext();
        context.lookup(name);
    }
}
