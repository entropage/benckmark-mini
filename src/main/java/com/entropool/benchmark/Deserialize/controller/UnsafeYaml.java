package com.entropool.benchmark.Deserialize.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;
import java.awt.*;
import java.io.StringReader;
import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/UnsafeYaml")
public class UnsafeYaml {
    /*
     */
    @RequestMapping(value = "/YamlTestParam", method = RequestMethod.POST)
    public String YamlTestParam(@RequestParam String context) {
        Yaml yaml = new Yaml();
        try {
            yaml.load(context);
        } catch (YAMLException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
