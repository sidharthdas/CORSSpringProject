package com.sid.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@RequestMapping(value = "/upload", method = RequestMethod.POST/* , consumes = MediaType.MULTIPART_FORM_DATA */)
	public String uploadPage(@RequestParam("file") MultipartFile[] files) {
		StringBuilder filenames = new StringBuilder();

		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			filenames.append(file.getOriginalFilename());
		}
		System.out.println(filenames.toString());
		return filenames.toString();

	}

}
