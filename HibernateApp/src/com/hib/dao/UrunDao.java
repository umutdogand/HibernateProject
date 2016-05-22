package com.hib.dao;

  

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.pojos.Urun;
import com.hib.util.HibernateUtil;

public class UrunDao {

	public List<Urun> GetirUrunleri(){
		
		Session session=HibernateUtil.getSessionFactory().openSession();
//		Transaction t=session.beginTransaction();
		Criteria crit=session.createCriteria(Urun.class);
		List<Urun> list=crit.list();
		return list;
		
	}
}
