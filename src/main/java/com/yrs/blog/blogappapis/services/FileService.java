package com.yrs.blog.blogappapis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
    String uploadFile(String path, MultipartFile file) throws IOException;

    InputStream downloadFile(String path, String file_Name) throws FileNotFoundException;
}
