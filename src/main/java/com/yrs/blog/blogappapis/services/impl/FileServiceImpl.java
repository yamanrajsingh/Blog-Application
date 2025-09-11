package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        // file Name
        String name = file.getOriginalFilename();
        // abc.png

        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(name.substring(name.lastIndexOf(".")));

        String fullPath = path + File.separator + fileName;

        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(fullPath));


        return fileName;
    }

    @Override
    public InputStream downloadFile(String path, String file_Name) throws FileNotFoundException {
        String fullPath = path + File.separator + file_Name;
        InputStream in = new FileInputStream(fullPath);
        return in;
    }
}
