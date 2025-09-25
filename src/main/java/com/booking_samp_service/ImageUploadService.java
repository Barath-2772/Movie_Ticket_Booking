package com.booking_samp_service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadFile(MultipartFile file, String movieName) {
        try {
            // Upload file with custom public_id based on movie name
            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                Map.of(
                    "public_id", "movie_posters/" + movieName, 
                    "overwrite", true
                )
            );

            // Return the secure Cloudinary URL
            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Could not upload file to Cloudinary", e);
        }
    }
}
