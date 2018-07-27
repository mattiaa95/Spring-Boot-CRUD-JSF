package net.atos.practica.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericMsgBean implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1180978332361619635L;

public void showInfoMessa (String title, String details) { 
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, details)); 
}

public void showWarnMessage(String title, String details) { 
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, details)); 
}

public void showErrorMessage(String title, String details) {
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, details)); 
}

public void showFatalMessage(String title, String details) { 
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, details)); 
}
	
}
