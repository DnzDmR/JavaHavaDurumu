package com.deniz.crud;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.deniz.model.Cities;

public class CityCRUD {
	
	public static final String persistenceUnitName ="JavaHavaDurumu";
	
	public static FacesMessage sehirEkle(Cities city)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts =em.getTransaction();
				
		try {
			
			Query sorgu = em.createQuery("Select c from Cities c where KULLANICI_ID=:kullaniciId and SEHIR=:sehir");
			sorgu.setParameter("kullaniciId", city.getKULLANICI_ID());
			sorgu.setParameter("sehir", city.getSEHIR());
			
			List<Cities> sonuc = sorgu.getResultList();
			
			if (sonuc.size()>0)
			{
				return new FacesMessage(FacesMessage.SEVERITY_INFO,"Şehir daha önceden kaydedilmiş",null);
			}
			else
			{
				ts.begin();
				em.persist(city);
				ts.commit();
			}
			
			return new FacesMessage(FacesMessage.SEVERITY_INFO,"Şehir Eklendi",null);
			
		}catch (Exception e) {
			return new FacesMessage(FacesMessage.SEVERITY_FATAL,"Ekleme Başarısız",null);
		}finally {
			em.close();
			mf.close();
		}
		
	}
	
	
	public static List<Cities> sehirList(Integer kullaniciId)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts = em.getTransaction();
		
		try {
			
			Query sorgu = em.createQuery("Select c from Cities c where KULLANICI_ID=:kullaniciId");
			sorgu.setParameter("kullaniciId", kullaniciId);
			
			ts.begin();
			List<Cities> sehir =sorgu.getResultList();
			ts.commit();
			return sehir;
			
		} catch (Exception e) {
			return null;
		}finally {
			em.close();
			mf.close();
		}
		
		
	}
	
	
	public static FacesMessage sehirSil(Integer secilenId)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts =em.getTransaction();
				
		try {
			ts.begin();
			Cities sehir = em.find(Cities.class, secilenId);
			ts.commit();
			
			ts.begin();
			em.remove(sehir);
			ts.commit();
		 
			return new FacesMessage(FacesMessage.SEVERITY_INFO,"Şehir Silindi",null);
			
		}catch (Exception e) {
			return new FacesMessage(FacesMessage.SEVERITY_FATAL,"Silme Başarısız",null);
		}finally {
			em.close();
			mf.close();
		}
	}

}
