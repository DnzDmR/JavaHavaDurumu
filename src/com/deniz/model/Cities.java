package com.deniz.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cities
 *
 */
@Entity
@Table(name="cities")
public class Cities implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	private Integer KULLANICI_ID;
	private String SEHIR;
	private static final long serialVersionUID = 1L;

	public Cities() {
		super();
	}   
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public Integer getKULLANICI_ID() {
		return this.KULLANICI_ID;
	}

	public void setKULLANICI_ID(Integer KULLANICI_ID) {
		this.KULLANICI_ID = KULLANICI_ID;
	}   
	public String getSEHIR() {
		return this.SEHIR;
	}

	public void setSEHIR(String SEHIR) {
		this.SEHIR = SEHIR;
	}
   
}
