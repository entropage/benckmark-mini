package com.entropool.benchmark.Deserialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Controller
@RequestMapping("/deserialize")
public class SimpleUnsafeDeserialize {

    @RequestMapping(value = "/unsafeBase64")
    public  String UnsafeBase64(@RequestParam String payload) throws IOException, ClassNotFoundException
    {
            byte[] bytes = Base64.getDecoder().decode(payload);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            return "ok";
    }
}
