package com.hib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hib.pojos.Urun;
import com.hib.util.HibernateUtil;

public class UrunDao {

	public List<Urun> GetirUrunleri() {

		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);
		List<Urun> list = crit.list();
		return list;

	}

	public List<Urun> LogicalExpOperation() {
		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);

		Criterion c = Restrictions.lt("adet", 10);
		Criterion c1 = Restrictions.like("urunAdi", "a%");

		LogicalExpression le = Restrictions.or(c, c1);
		crit.add(le);

		List<Urun> list = crit.list();
		return list;
	}

	public List<Urun> DisjunctionOperation() {

		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);

		Criterion c = Restrictions.lt("adet", 10);
		Criterion c1 = Restrictions.like("urunAdi", "a%");
		Criterion c2 = Restrictions.isNotNull("uretimTarihi");

		Disjunction d = Restrictions.disjunction(c, c1, c2);
		crit.add(d);
		List<Urun> u = crit.list();

		return u;
	}

	public List<Urun> RestrictionsOperation() {

		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);

		crit.add(Restrictions.between("adet", 10, 100));

		crit.add(Restrictions.ne("urunadi", "Telefon"));

		crit.add(Restrictions.eq("urunadi", "Telefon"));

		crit.add(Restrictions.gt("adet", 10));

		crit.add(Restrictions.lt("adet", 10));

		crit.add(Restrictions.isNull("adet"));

		crit.add(Restrictions.isNotNull("adet"));

		crit.add(Restrictions.like("adet", "a%"));

		crit.add(Restrictions.ilike("adet", "a%"));

		List<Urun> list = crit.list();
		return list;

	}

	public List<Urun> SqlRestrictionsOperation() {
		
		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);
		crit.add(Restrictions.sqlRestriction("adet <10 or urunAdi like 'a%' or uretimTarihi is not null"));
		List<Urun> u = crit.list();
		return u;
	}

	public List<Urun> FirstMaxtResultOperation() {
		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);
		crit.setFirstResult(0);
		crit.setMaxResults(3);
		List<Urun> u = crit.list();
		return u;
	}
	
	public List<Urun> OrderOperation() {
		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);
		crit.addOrder(Order.desc("urunAdi"));
		List<Urun> u = crit.list();
		return u;
	}

	public List ProjectionOperation(){
		Session session = HibernateUtil.getSessionFactory();
		Criteria crit = session.createCriteria(Urun.class);
 
		ProjectionList pList= Projections.projectionList();
		pList.add(Projections.sum("adet"));
		pList.add(Projections.max("adet"));
		pList.add(Projections.min("adet"));
		pList.add(Projections.count("adet"));
		pList.add(Projections.countDistinct("adet"));
		pList.add(Projections.rowCount());
		
		crit.setProjection(pList);
		
		List list=crit.list();
		return list;
	 
	} 
}
