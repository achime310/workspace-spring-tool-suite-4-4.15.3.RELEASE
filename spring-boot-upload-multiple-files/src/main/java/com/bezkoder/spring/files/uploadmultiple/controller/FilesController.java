package com.bezkoder.spring.files.uploadmultiple.controller;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.bezkoder.spring.files.uploadmultiple.message.ResponseMessage;
import com.bezkoder.spring.files.uploadmultiple.model.FileInfo;
import com.bezkoder.spring.files.uploadmultiple.service.FilesStorageService;

@Controller
public class FilesController {

  @Autowired
  FilesStorageService storageService;
  
  @GetMapping("/multipart_form")
  public String mutipart_form() {
	  return "multipart_form";
  }
  //실패!
  @GetMapping("/multipart_form_dragndrop")
  public String multipart_form_dragndrop() {
	  return "multipart_form_dragndrop";
  }
  //성공!!!
  @GetMapping("/multipart_form_dragndrop2")
  public String multipart_form_dragndrop2() {
	  return "multipart_form_dragndrop2";
  }
  
  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files) {
	  //System.out.println("files[0]"+files[0]);
     System.out.println("files.length"+files.length);
     //storageService.deleteAll();
     //storageService.init();
	 String message = "";
	 
    try {
      List<String> fileNames = new ArrayList<>();
     
      for (MultipartFile file : files) {
    	  System.out.println("file.isEmpty() >> "+file.isEmpty());
    	  
    	  if(!file.isEmpty()) {
    		  storageService.save(file);
    		  fileNames.add(file.getOriginalFilename());
    		  System.out.println("file.getOriginalFilename(): "+file.getOriginalFilename());
    	  }
	  }
      message = "Uploaded the files successfully: " + fileNames;
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
    	e.printStackTrace();
      message = "Fail to upload files!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<FileInfo>> getListFiles() {
    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

      return new FileInfo(filename, url);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
  }
	/*@GetMapping("/view")
	public String view(Model model) {
	
	  List<FileEntity> files = fileRepository.findAll();
	  model.addAttribute("all",files);
	  return "view";
	}*/
  

  @GetMapping("/files/{filename:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.load(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
}
