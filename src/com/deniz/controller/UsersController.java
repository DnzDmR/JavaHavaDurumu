package com.deniz.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.deniz.crud.UserCRUD;
import com.deniz.model.Users;
import com.deniz.session.UserSession;
 

@ManagedBean
@SessionScoped
public class UsersController {
	
	private Integer id;
	private String kullaniciAdi;
	private String kullaniciSoyadi;
	private String kullaniciSifre;
	private String kullaniciMail;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getKullaniciSoyadi() {
		return kullaniciSoyadi;
	}
	public void setKullaniciSoyadi(String kullaniciSoyadi) {
		this.kullaniciSoyadi = kullaniciSoyadi;
	}
	public String getKullaniciSifre() {
		return kullaniciSifre;
	}
	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	public String getKullaniciMail() {
		return kullaniciMail;
	}
	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}
	
	
	public String kullaniciGirisKontrol()
	{
		FacesMessage mesaj=UserCRUD.girisKontrol(kullaniciMail, kullaniciSifre);
		FacesContext.getCurrentInstance().addMessage("null",mesaj);
		
		if(mesaj.getSeverity()==FacesMessage.SEVERITY_INFO)
		{
			HttpSession session = UserSession.getSession();
			session.setAttribute("eposta", kullaniciMail);
			return "anasayfa.jsf?faces-redirect=true";
		}
		else
		{
			return "index.jsf";
		}
		 
	}
	
	public void kullaniciKayit()
	{
		Users user = new Users();
		user.setAD(this.kullaniciAdi);
		user.setEPOSTA(this.kullaniciMail);
		user.setSIFRE(this.kullaniciSifre);
		user.setSOYAD(this.kullaniciSoyadi);
		
		FacesMessage mesaj = UserCRUD.kullaniciKayit(user);
		FacesContext.getCurrentInstance().addMessage(null, mesaj);
	}
	
	
	public void sessionKontrol()
	{
		if(UserSession.getEposta()==null)
		{
			try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
			}catch(Exception e) {e.printStackTrace();}
		} 
	}
	
	public String sessionDestroy()
	{
		UserSession.sessionDestroy();
		return "index.jsf?faces-redirect=true";
	}
	 
	

}
