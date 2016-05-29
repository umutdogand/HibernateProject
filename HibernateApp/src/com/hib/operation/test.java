package com.hib.operation;

import java.util.Date;
import java.util.List;

import com.hib.dao.IslemDao;
import com.hib.dao.UrunDao;
import com.hib.pojos.Ders;
import com.hib.pojos.Egitmen;
import com.hib.pojos.Urun;

public class test {

	public static void main(String[] args) {
	
		
		Egitmen e=new Egitmen();
		e.setAdi("Umut");
 
		
		Egitmen e1=new Egitmen();
		e1.setAdi("Vektor");
		 
		
		Ders d=new Ders();
		d.setAdi("Net");
		d.setTarih(new Date());
		d.getEgitmen().add(e1);
		d.getEgitmen().add(e);
		
		IslemDao i=new IslemDao();
		i.Ekle(d);
	}

	private void Criteria(){
		
		UrunDao u = new UrunDao();
		List<Urun> list = u.LogicalExpOperation();

		for (Urun urun : list) {
			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}

		List<Urun> list1= u.FirstMaxtResultOperation();
		for (Urun urun : list1) {
			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}
		
		List<Urun> list2= u.DisjunctionOperation();
		for (Urun urun : list2) {
			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}
		
		List<Urun> list3= u.SqlRestrictionsOperation();
		for (Urun urun : list3) {
			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}
		
		List<Urun> list4= u.OrderOperation();
		for (Urun urun : list4) {
			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}
		
		List list5= u.ProjectionOperation();
		for (Object urun : list5) {
			System.out.println(urun.toString());
//			System.out.println(urun.getId() +"---"+urun.getUrunAdi() +"---"+urun.getAdet() +"--"+urun.getUretimTarihi() +"--");
		}
		
		
	}
}
