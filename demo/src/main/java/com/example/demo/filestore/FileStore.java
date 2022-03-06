package com.example.demo.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    // Amazon S3
    private final AmazonS3 s3;

    // File it self
    // Dependency injection
    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    // Save to bucket
    public void save(
            String path,        // Path for file
            String fileName,    // Name of file
            Optional<Map<String, String>> optionalMetadata, // Optional metadata for File
            InputStream inputStream) {      // Input stream
        ObjectMetadata metadata = new ObjectMetadata();

        // Metadata if exists save it
        optionalMetadata.ifPresent(map -> { // For each save objects metadata key + value
            if(!map.isEmpty()) {
                map.forEach(metadata:: addUserMetadata);    // Same as (down)
                // map.forEach((key, value) -> metadata.addUserMetadata(key, value));
            }
        });

        // Try for objects
        try {
            s3.putObject(path, fileName, inputStream, metadata);
        } catch (AmazonServiceException e) {
            // Failed to store file s3
            throw new IllegalStateException("Failed to store file to s3", e);
        }
    }
}
