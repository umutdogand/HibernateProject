package com.hib.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	static{
		try {
			sessionFactory=new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}
	public static Session getSessionFactory(){
		return sessionFactory.openSession();
	} 
	
	
}
