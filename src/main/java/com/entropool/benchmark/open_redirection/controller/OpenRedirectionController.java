package com.entropool.benchmark.open_redirection.controller;
import org.apache.commons.collections.MapUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Map;


/**
 */

@Controller
@RequestMapping("/OpenRedirect")
public class OpenRedirectionController {

    @GetMapping("/redirect1")
    public String redirect1(@RequestParam Map param, HttpServletRequest request) {
        String url = MapUtils.getString(param, "url");
        return "redirect:" + url;
    }


    @GetMapping("/redirect2")
    public String redirect2(@RequestParam Map param, HttpServletRequest request) {
        String url = MapUtils.getString(param, "url");
        return "redirect:" + "http://www.baidu.com" + url;
    }

}