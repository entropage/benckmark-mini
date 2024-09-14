package com.entropool.benchmark.path_traversal.controller;
//import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;

@Controller
@RequestMapping("/PathTraversal")
public class PathTraversalController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/read")
    @ResponseBody
    public String getImage(String filepath) throws IOException {
        return getImg(filepath);
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteFile(String filepath) throws IOException {
        File file = new File(filepath);
        if (file.exists()) {
            file.delete();
            return "File deleted successfully.";
        } else {
            return "File doesn't exist.";
        }
    }



    /**
     * @param imgFile
     * @return
     * @throws IOException
     */
    private String getImg(String imgFile) throws IOException {
        File f = new File(imgFile);
        if (f.exists() && !f.isDirectory()) {
            return new String(Files.readAllBytes(Paths.get(imgFile)), StandardCharsets.UTF_8);
        } else {
            return "File doesn't exist or is not a file.";
        }
    }

    @GetMapping("/ApacheReadFileToByteArray")
    public String readFileToByteArray(@RequestParam String filepath) {
        // Create a File object with the provided file path
        File file = new File(filepath);
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            // Convert the byte array to a String (assuming the file is a text file in UTF-8 encoding)
            return new String(fileContent, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            return "Error reading file: ";
        }
    }

    @GetMapping("/ApacheReadFileToString")
    public String ApacheReadFileToString(@RequestParam String filepath)
    {
        // Create a File object with the provided file path
        File file = new File(filepath);
        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            return "Error reading file: " + e.getMessage(); // Return an error message
        }

    }

    @GetMapping("/readLines")
    public ResponseEntity<List<String>> readFile(@RequestParam("file") String filePath) {
        try {
            File file = new File(filePath);
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            return new ResponseEntity<>(lines, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}