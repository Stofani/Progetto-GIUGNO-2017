package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.Autore;
import service.AutoreService;

@ManagedBean(name="autoreController")
public class AutoreController {
	private Long id;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private Date dataDiMorte;
	private Autore autore;
	@EJB(name="aService")
	private AutoreService as;
	
	public String salvaAutore(){
		this.as.save(nome, cognome, dataDiNascita, dataDiMorte);
		return "confermaInserimentoArtista";
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
}
