package com.sid.daoImpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sid.dao.UserDetailsDAO;
import com.sid.model.UserDetails;
@Repository
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		}
	
	

	@Override
	public void addUser(UserDetails userdetails) {
		getSession().save(userdetails);
		System.out.println("Userdetails saved");

	}



	@Override
	public UserDetails detail() {
		// TODO Auto-generated method stub
		ArrayList<UserDetails>details= (ArrayList<UserDetails>)getSession().createQuery("FROM USERDETAILS WHERE firstName= ? ").setParameter(0, "Mickey").list();
		return details.get(0);
	}

}
