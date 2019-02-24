package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}