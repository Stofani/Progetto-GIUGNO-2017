package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.Autore;
import model.Quadro;
import service.QuadroService;

@ManagedBean(name="quadroController")
public class QuadroController {
	private Long id;
	private String titolo;
	private int annoRealizzazione;
	private int altezza;
	private int larghezza;
	private Autore autore;
	private Quadro quadroCorrente;
	@EJB(beanName="qService")
	private QuadroService quadroService;
	public String salvaQuadro(){
		quadroCorrente=quadroService.salva(this.titolo,this.annoRealizzazione);
		return "confermaInserimentoQuadro";
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(int annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}
	public int getAltezza() {
		return altezza;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	public int getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Quadro getQuadroCorrente() {
		return quadroCorrente;
	}
	public void setQuadroCorrente(Quadro quadroCorrente) {
		this.quadroCorrente = quadroCorrente;
	}
	public QuadroService getQuadroService() {
		return quadroService;
	}
	public void setQuadroService(QuadroService quadroService) {
		this.quadroService = quadroService;
	}
	public Long getId() {
		return id;
	}
}
