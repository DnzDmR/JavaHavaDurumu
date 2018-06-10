package com.deniz.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.deniz.crud.WeatherCRUD;

@ManagedBean
@ViewScoped
public class WeatherController {
	
	
	private String sehirAdi;
	private String sehirUlkesi;
	private String sehirEnlem;
	private String sehirBoylam;
	private String sehirKonum;
	private String sehirSonGuncelleme;
	private String sehirLocalSaat;
	private String sehirSicaklik;
	private String sehirHavaDurumu;
	private String sehirHavaIcon;
	private String sehirRuzgarHizi;
	private String sehirNemOrani;
	
	
	private static String secilenSehir="a";
	
	
	
	
	public String getSecilenSehir() {
		return secilenSehir;
	}
	public void setSecilenSehir(String secilenSehir) {
		this.secilenSehir = secilenSehir;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	public String getSehirUlkesi() {
		return sehirUlkesi;
	}
	public void setSehirUlkesi(String sehirUlkesi) {
		this.sehirUlkesi = sehirUlkesi;
	}
	public String getSehirEnlem() {
		return sehirEnlem;
	}
	public void setSehirEnlem(String sehirEnlem) {
		this.sehirEnlem = sehirEnlem;
	}
	public String getSehirBoylam() {
		return sehirBoylam;
	}
	public void setSehirBoylam(String sehirBoylam) {
		this.sehirBoylam = sehirBoylam;
	}
	public String getSehirKonum() {
		return sehirKonum;
	}
	public void setSehirKonum(String sehirKonum) {
		this.sehirKonum = sehirKonum;
	}
	public String getSehirSonGuncelleme() {
		return sehirSonGuncelleme;
	}
	public void setSehirSonGuncelleme(String sehirSonGuncelleme) {
		this.sehirSonGuncelleme = sehirSonGuncelleme;
	}
	public String getSehirSicaklik() {
		return sehirSicaklik;
	}
	public void setSehirSicaklik(String sehirSicaklik) {
		this.sehirSicaklik = sehirSicaklik;
	}
	public String getSehirHavaDurumu() {
		return sehirHavaDurumu;
	}
	public void setSehirHavaDurumu(String sehirHavaDurumu) {
		this.sehirHavaDurumu = sehirHavaDurumu;
	}
	public String getSehirHavaIcon() {
		return sehirHavaIcon;
	}
	public void setSehirHavaIcon(String sehirHavaIcon) {
		this.sehirHavaIcon = sehirHavaIcon;
	}
	public String getSehirRuzgarHizi() {
		return sehirRuzgarHizi;
	}
	public void setSehirRuzgarHizi(String sehirRuzgarHizi) {
		this.sehirRuzgarHizi = sehirRuzgarHizi;
	}
	public String getSehirNemOrani() {
		return sehirNemOrani;
	}
	public void setSehirNemOrani(String sehirNemOrani) {
		this.sehirNemOrani = sehirNemOrani;
	}
	public String getSehirLocalSaat() {
		return sehirLocalSaat;
	}
	public void setSehirLocalSaat(String sehirLocalSaat) {
		this.sehirLocalSaat = sehirLocalSaat;
	}
	public ArrayList<WeatherController> havaDurumuCek()
	{
		return WeatherCRUD.sehirHavaDurumuCek(secilenSehir);
	}
	
	
	public void sehirSecimi(String sehir)
	{
		secilenSehir=sehir;
	}
	
	

}
