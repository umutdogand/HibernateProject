package com.hib.dao;

  

import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.hib.util.HibernateUtil;

public class UrunDao {

	public void Ekle(Object o){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		session.save(o);
		t.commit();
		
	}
	public void Sil(Object o){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		session.delete(o);
		t.commit();
	}
	public void Guncelle(Object o){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		session.update(o);
		t.commit();
	}
	
}
