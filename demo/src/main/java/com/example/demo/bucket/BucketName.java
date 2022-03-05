package com.example.demo.bucket;

public enum BucketName {
    PROFILE_IMAGE("prog3app-123");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
