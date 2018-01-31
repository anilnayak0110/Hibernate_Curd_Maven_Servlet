package com.anilnayak.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.anilnayak.pojo.User;
import com.anilnayak.util.HibernateUtil;

public class RegisterService {
     public boolean registerUser(User user) {
    	 if(isUserExist(user))
    		 return false;
    	 Session session = HibernateUtil.openSession();
    	 Transaction tx  = null;
    	 try {
    	tx = session.beginTransaction();
    	 session.save(user);
    	 tx.commit();
    	 }
    	 catch(Exception e) {
    		 if (tx != null) {
    			 tx.rollback();
    		 }
    	 }
    	 finally {
			session.close();
		}
    	 return true;
     }
	
	public boolean isUserExist(User user) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		try {
		Query query = session.createQuery(" from user where userId ='"+user.getUserId()+"'");
		User u = (User) query.uniqueResult();
		if(u!=null)
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}
}
