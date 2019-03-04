package com.sid.dao;

import com.sid.model.UserDetails;

public interface UserDetailsDAO {

	public void addUser(UserDetails userdetails);
	public UserDetails detail();
}
