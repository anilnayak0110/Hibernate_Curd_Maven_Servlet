package com.anilnayak.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anilnayak.pojo.User;
import com.anilnayak.util.HibernateUtil;

public class LoginService {
	
	public boolean authenticatedUser(String userId, String password) {
		User user = getUserByUserId(userId);
		if(user!=null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
			return true;
		}
		else {
		return false;
		}
		
	}
	
	public User getUserByUserId(String userId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from User where userId ='"+userId+"'");
			user = (User) query.uniqueResult();
			tx.commit();
		}
		catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUserDetails(){
		Session session = HibernateUtil.openSession();
		Transaction tx =null;
		List<User> userList = new ArrayList<>();
		try {
		tx = session.beginTransaction();
		userList = session.createQuery("from User").list();
		 tx.commit();
		}
		catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		return userList;
		 
	}
	

}
