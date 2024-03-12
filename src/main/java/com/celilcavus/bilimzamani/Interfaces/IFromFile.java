package com.celilcavus.bilimzamani.Interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IFromFile {

    String SaveImage(MultipartFile multipartFile);
    int DeleteImage(String Path);
}
