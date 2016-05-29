package com.hib.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ders {

	private int id;
	private String adi;
	private List<Egitmen> egitmen=new ArrayList<>();
	private Date tarih;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ders_id_seq")
	@SequenceGenerator(name="ders_id_seq",sequenceName="ders_id_seq",allocationSize=1,initialValue=10)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="adi",length=20)
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="DERSID")
	public List<Egitmen> getEgitmen() {
		return egitmen;
	}
	public void setEgitmen(List<Egitmen> egitmen) {
		this.egitmen = egitmen;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}


}


