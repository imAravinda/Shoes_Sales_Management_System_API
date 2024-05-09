package com.example.SSMS.utill;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Utills {
    public String convertToBase64(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            return java.util.Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            return null;
        }
    }
}
