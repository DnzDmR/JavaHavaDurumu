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
	
	public static FacesMessage mesaj;
	
	
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
				mesaj = new FacesMessage(FacesMessage.SEVERITY_INFO,"Kullanıcı Bulundu",null);
				return mesaj;
			}
			else
			{
				mesaj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Kullanıcı Bulunamadı",null);
				return mesaj;
			}
			
		}catch (Exception e) {
			System.out.println("hata::girisKontrol : "+e.getMessage());
			e.printStackTrace();
			mesaj = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Hata Oluştur",null);
			return mesaj;
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
			mesaj = new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayıt Başarılı",null);
			return mesaj;
			
		} catch (Exception e) {
			mesaj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hata Oluştu",null);
			return mesaj;
		}finally {
			em.close();
			mf.close();
		}
		
		
		
	}

}
