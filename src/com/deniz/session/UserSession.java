package com.deniz.session;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession {
	
	
	public static HttpSession getSession()
	{
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public static HttpServletRequest getRequest() 
	{
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public static void sessionDestroy() 
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	public static String getKullaniciAdi() {
		HttpSession session = getSession();
		if (session != null){ 
			return (String) session.getAttribute("eposta");
		} else {
			return null;
		}

	}


}
