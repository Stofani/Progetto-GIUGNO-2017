package controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Autore;
import service.AutoreService;

@ManagedBean(name="autoreController")
public class AutoreController {
	private Long id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataDiNascita;
	private Date dataDiMorte;
	private Autore autore;
	@EJB(name="aService")
	private AutoreService as;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	public String salvaAutore(){
		this.as.save(nome, cognome,nazionalita,dataDiNascita, dataDiMorte);
		return "confermaInserimentoAutore";
	}

	public void cancellaAutore(Long id){
		this.as.remove(id);
	}
	public String iniziaModifica(Long id){
		Autore scelto=as.find(id);
		this.sessionMap.put("editAutore",scelto);
		return "modificaAutore";
	}
	public String modificaAutore(Autore a){
		this.as.merge(a);
		this.sessionMap.remove("editAutore");
		return "gestioneAutori";
	}
	public List<Autore> getAll(){
		return as.findAll();
	}
	public String visualizzaAutore(Long id){
		this.autore=as.find(id);
		return "datiAutore";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public Date getDataDiMorte() {
		return dataDiMorte;
	}
	public void setDataDiMorte(Date dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Long getId() {
		return id;
	}
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<String> listaNazioni(){
		return as.listaNazioni();
	}
	public String visualizzaQuadri(Long id){
		Autore a=this.as.find(id);
		this.autore=a;
		return "quadriAutore";
	}
}
