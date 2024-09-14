package com.entropool.benchmark.upload.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
public class MagicByteBypassController {

    private static final Map<String, String> FILE_TYPE = new HashMap<>();

    static {
        FILE_TYPE.put("FFD8FF", "pic");
        FILE_TYPE.put("89504E47", "pic");
        FILE_TYPE.put("47494638", "pic");
        FILE_TYPE.put("424D", "pic");
        FILE_TYPE.put("D0CF11E0", "excel");
        FILE_TYPE.put("504B0304", "zip");
    }


    String getFileType(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            byte[] buf = new byte[50];
            inputStream.read(buf);
            String fileTypeHex = bytesToHexString(buf);
            System.out.println("fileTypeHex:" + fileTypeHex);
            for (Map.Entry<String, String> e : FILE_TYPE.entrySet()) {
                if (fileTypeHex.toUpperCase(Locale.ROOT).startsWith(e.getKey())) {
                    return e.getValue();
                }
            }
        }
        return null;
    }

    static String bytesToHexString(byte[] src) {
        if (src == null || src.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    @PostMapping("/saas/uploadFiles")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("mFiles") List<MultipartFile> files) throws IOException {
        Map<String, String> uploadedFiles = new HashMap<>();
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            if (getFileType(file) == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>());
            }
            Path tempDir = Paths.get("/tmp");
            Path uploadPath = tempDir.resolve(filename);
            Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            // 构建文件的访问URL
            String fileUrl = "http://your-domain.com/uploads/" + uploadPath.getFileName();
            String absoluteFilePath = uploadPath.toAbsolutePath().toString();
            uploadedFiles.put(fileUrl, absoluteFilePath);
        }
        return ResponseEntity.ok().body(uploadedFiles);
    }
}
