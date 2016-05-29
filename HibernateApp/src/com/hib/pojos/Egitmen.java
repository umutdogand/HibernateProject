package com.hib.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator; 

@Entity
public class Egitmen {
	private int id;
	private String adi; 

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="egitmen_id_seq")
	@SequenceGenerator(name="egitmen_id_seq",sequenceName="egitmen_id_seq",allocationSize=1,initialValue=10)
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
	 

}
