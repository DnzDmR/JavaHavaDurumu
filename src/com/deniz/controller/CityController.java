package com.deniz.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.deniz.crud.CityCRUD;
import com.deniz.crud.UserCRUD;
import com.deniz.model.Cities;
import com.deniz.model.Users;
import com.deniz.session.UserSession;

@ManagedBean
@SessionScoped
public class CityController {

	private Integer id;
	private Integer kullaniciId;
	private String sehir;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

 
	
	
	
	public void sehirEkle()
	{
		Cities sehir = new Cities();
		Users user = UserCRUD.kullaniciCek(UserSession.getEposta());
		sehir.setKULLANICI_ID(user.getID());
		sehir.setSEHIR(this.sehir.toLowerCase());
		
		FacesMessage mesaj =CityCRUD.sehirEkle(sehir);
		FacesContext.getCurrentInstance().addMessage(null, mesaj);
		
	}
	
	public List<Cities> sehirList()
	{
		Users user = UserCRUD.kullaniciCek(UserSession.getEposta());
		return CityCRUD.sehirList(user.getID());
	}
	
	
}
