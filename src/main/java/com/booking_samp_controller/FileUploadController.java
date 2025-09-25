package com.booking_samp_controller;

import com.booking_samp_service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*") 

public class FileUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("text") String movieName) {
        String fileUrl = imageUploadService.uploadFile(file,movieName);
        return ResponseEntity.ok(fileUrl);
    }
}