package com.bezkoder.spring.files.uploadmultiple;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bezkoder.spring.files.uploadmultiple.service.FilesStorageService;

@SpringBootApplication
public class SpringBootUploadMultipleFilesApplication{
  
  @Resource
  FilesStorageService fileStorageService;
  public static void main(String[] args) {
    SpringApplication.run(SpringBootUploadMultipleFilesApplication.class, args);
   
  }
 
}
