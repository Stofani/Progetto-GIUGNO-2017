package controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Amministratore;
import service.AmministratoreService;

@ManagedBean(name="adminController")
@SessionScoped
public class AmministratoreController {
	private String username;
	private String password;
	private Amministratore amministratore;
	private boolean loggedIn;

	@EJB(beanName="amService")
	private AmministratoreService as;

	public String login(){
		Amministratore a=as.getAmministratoreByUser(this.username);
		if(a!=null&&as.checkPassword(a,this.password)){
			loggedIn=true;
			return "adminProfile?faces-redirect=true";
		}
		FacesMessage msg=new FacesMessage("Login error","ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null,msg);
		return "loginError";

	}
	public String logout(){
		this.loggedIn=false;
		return "loginAmministratore";
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public AmministratoreService getAs() {
		return as;
	}

	public void setAs(AmministratoreService as) {
		this.as = as;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
