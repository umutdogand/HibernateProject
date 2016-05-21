package com.hib.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Urun {
	
	private int id;
	private String urunAdi;
	private int adet;
	private Date uretimTarihi;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Urun_Id_Seq")
	@SequenceGenerator(name="Urun_Id_Seq",sequenceName="Urun_Id_Seq",allocationSize=1,initialValue=10)
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="UrunAdi",length=50)
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	
	@Column(name="Adet")
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="UretimTarihi")
	public Date getUretimTarihi() {
		return uretimTarihi;
	}
	public void setUretimTarihi(Date uretimTarihi) {
		this.uretimTarihi = uretimTarihi;
	}
	
	

}
