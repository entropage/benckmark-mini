package com.entropool.benchmark.upload.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class ZhouPuUploadBlacklistBypass {

    public static boolean checkFileType(String suffix) {
        if (StrUtil.isBlank(suffix) || StrUtil.equalsAny(suffix.toLowerCase(), "sh", "bat", "exe", "com", "php", "html", "css", "js", "asp", "xml", "jsp")) {
            return false;
        }
        return true;
    }

    @PostMapping("/saas/printtemplate")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("文件名不能为空");
        }

        // 确保文件名不含不安全字符
        if (!fileName.matches("[^<>:\"/\\\\|?*]+")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("文件名包含非法字符");
        }

        String fileSuffix = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (!checkFileType(fileSuffix)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("不允许上传该类型的文件");
        }

        try {
            String tempDir = System.getProperty("java.io.tmpdir");
            Path targetLocation = Paths.get(tempDir).resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return ResponseEntity.ok("文件上传成功，路径为: " + targetLocation.toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace(); // 打印异常堆栈，便于调试
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败: " + e.getMessage());
        }
    }
}