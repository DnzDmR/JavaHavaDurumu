package com.deniz.crud;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.deniz.model.Users;

public class UserCRUD {
	
	private final static String persistenceUnitName="JavaHavaDurumu"; 
	
	
	
	public static FacesMessage girisKontrol(String eposta,String sifre)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts =em.getTransaction(); 
			
		try
		{
			Query sorgu =em.createQuery("Select u from Users u where EPOSTA=:eposta and SIFRE=:sifre");
			sorgu.setParameter("eposta", eposta);
			sorgu.setParameter("sifre", sifre);
			
			ts.begin();
			List<Users> users =sorgu.getResultList();
			ts.commit();
			if(users.size()>0)
			{
				return new FacesMessage(FacesMessage.SEVERITY_INFO,"Kullanıcı Bulundu",null);
				 
			}
			else
			{
				
				return new FacesMessage(FacesMessage.SEVERITY_ERROR,"Kullanıcı Bulunamadı",null);
			}
			
		}catch (Exception e) {
			System.out.println("hata::girisKontrol : "+e.getMessage());
			e.printStackTrace();
			
			return new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata Oluştur",null);
		}finally {
			 em.close();
			 mf.close();
		}
		
		
	}
	
	
	
	
	public static FacesMessage kullaniciKayit(Users user)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts = em.getTransaction();
		
		try {
			
			ts.begin();
			em.persist(user);
			ts.commit();
			
			return new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarılı",null);
			
		} catch (Exception e) {
			
			return new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata Oluştu",null);
		}finally {
			em.close();
			mf.close();
		}
		
	}
	
	
	public static Users kullaniciCek(String eposta)
	{
		EntityManagerFactory mf = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = mf.createEntityManager();
		EntityTransaction ts = em.getTransaction();
		
		try {
			Query sorgu = em.createQuery("Select u from Users u where EPOSTA=:eposta");
			sorgu.setParameter("eposta", eposta);
			
			ts.begin();
			List<Users> user = sorgu.getResultList();
			ts.commit();
			
			if(user.size()>0)
			{
				return user.get(0);	
			}
			else
			{
				return null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
			mf.close();
		}
	}
	

}
