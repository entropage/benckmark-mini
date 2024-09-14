package com.entropool.benchmark.upload.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
public class ZhouPuUploadFileController {

    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");
    private static final Map<String, String> FILE_TYPE = new HashMap<>();

    static {
        FILE_TYPE.put("FFD8FF", "pic");
        FILE_TYPE.put("89504E47", "pic");
        FILE_TYPE.put("47494638", "pic");
        FILE_TYPE.put("424D", "pic");
        FILE_TYPE.put("D0CF11E0", "excel");
        FILE_TYPE.put("504B0304", "zip");
    }

    @RequestMapping(value = {"/saas/uploadFilesImage"}, method = {RequestMethod.POST})
    public String uploadFilesImage(@RequestParam("mFiles") List<MultipartFile> files, HttpServletRequest request) throws IOException {
        String imageData = request.getParameter("imageData");
        String versionStr = request.getParameter("version");


        // 参数检查
        if (StringUtils.isBlank(versionStr)) {
            return "version 不能为空！";
        }

        int version;
        version = Integer.parseInt(versionStr);
        JSONObject json = JSONObject.parseObject(imageData);

        if (version < 38) {
            return uploadFiles(files); // 上传文件
        } else {
            return "version not supported！";
        }
    }

    public String uploadFiles(List<MultipartFile> files) throws IOException {
        StringBuilder resultPaths = new StringBuilder();
        for (MultipartFile file : files) {
            getFileType(file);
            if (file.isEmpty()) {
                return "file not empty！";
            }

            String fileName = file.getOriginalFilename();
            if (fileName == null || !fileName.contains("_")) {
                return "The file name must contain underscores";
            }
            Path uploadPath = Paths.get(TEMP_DIR, fileName);
            try {
                Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                resultPaths.append(uploadPath.toAbsolutePath().toString()).append("\n");
            } catch (IOException e) {
                return "upload fail: " + fileName;
            }
        }

        return resultPaths.toString(); //
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
        return "file invalid";
    }

    static String bytesToHexString(byte[] src) {
        if (src == null || src.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}