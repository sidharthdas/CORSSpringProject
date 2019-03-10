package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sid.dao.UserDetailsDAO;
import com.sid.model.UserDetails;

@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@RequestMapping(value= "/test", method = RequestMethod.GET)
	public String test() {
		return "working";
	}
	@RequestMapping(value= "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody UserDetails userDetails) {
		System.out.println(userDetails.toString());
		System.out.println(userDetails.getFirstName());
		System.out.println(userDetails.getLastName());
		userDetailsDAO.addUser(userDetails);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserDetails user() {
		return userDetailsDAO.detail();
	}
	
	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST, consumes = MediaType.IMAGE_JPEG_VALUE)
	public String imageUpload(@RequestBody MultipartFile file) {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		return null;
	}
	
	
}
