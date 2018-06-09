package com.deniz.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@Table(name="users")
public class Users implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	private String AD;
	private String SOYAD;
	private String EPOSTA;
	private String SIFRE;
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}   
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public String getAD() {
		return this.AD;
	}

	public void setAD(String AD) {
		this.AD = AD;
	}   
	public String getSOYAD() {
		return this.SOYAD;
	}

	public void setSOYAD(String SOYAD) {
		this.SOYAD = SOYAD;
	}   
	public String getEPOSTA() {
		return this.EPOSTA;
	}

	public void setEPOSTA(String EPOSTA) {
		this.EPOSTA = EPOSTA;
	}   
	public String getSIFRE() {
		return this.SIFRE;
	}

	public void setSIFRE(String SIFRE) {
		this.SIFRE = SIFRE;
	}
   
}
