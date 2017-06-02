package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Amministratore;
import service.AmministratoreService;

@ManagedBean(name="adminController")
@SessionScoped
public class AmministratoreController {
	private String username;
	private String password;
	private Amministratore amministratore;
	
	@EJB(beanName="amService")
	private AmministratoreService as;
	
	public String login(){
		Amministratore a=as.getAmministratoreByUser(username);
		if(a!=null&&as.checkPassword(a,this.password))
			return "adminProfile";
		else
			return "loginError";
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
}
