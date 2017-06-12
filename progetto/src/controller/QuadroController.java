package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import model.Autore;
import model.Quadro;
import service.QuadroService;

@ManagedBean(name="quadroController")
public class QuadroController {
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private Integer altezza;
	private Integer larghezza;
	private String tecnica;
	private Autore autore;
	private Part immagine;
	private Quadro operaCorrente;
	private List<Quadro> opere;
	//occorre perch� nella form specifico l'autore e ne acquisisco l'id
	private Long idAutore;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	@EJB(beanName="qService")
	private QuadroService quadroService;
	public String salvaQuadro(){
		byte[] datiImmagine;
		try{
			InputStream is = immagine.getInputStream();
			byte[] buffer = new byte[(int)immagine.getSize()];
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			for (int length=0;(length=is.read(buffer))>0;) 
				output.write(buffer,0,length);
			datiImmagine=output.toByteArray();
		} catch (IOException | NullPointerException e) {
			return "inserimentoQuadro";
		}
		operaCorrente=this.quadroService.salva(titolo, annoRealizzazione, altezza, larghezza,tecnica,idAutore,datiImmagine);
		return "confermaInserimentoQuadro";
	}
	public List<Quadro> getOpere(){
		this.opere=quadroService.getAll();
		return this.opere;
	}
	public String visualizzaOpera(Long id){
		this.operaCorrente=quadroService.find(id);
		return "datiOpera";
	}
	public String cancellaOpera(Long id){
		this.quadroService.remove(id);
		return "listaOpere";
	}
	public String modificaOpera(Long id){
		this.operaCorrente=quadroService.find(id);
		this.sessionMap.put("editQuadro",operaCorrente);
		return "modificaOpera";
	}
	public String updateOpera(Quadro q){
		
		this.quadroService.merge(q);
		this.sessionMap.remove("editQuadro");
		return "listaOpere";
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(Integer annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}
	public Integer getAltezza() {
		return altezza;
	}
	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}
	public Integer getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Quadro getOperaCorrente() {
		return operaCorrente;
	}
	public void setOperaCorrente(Quadro quadroCorrente) {
		this.operaCorrente = quadroCorrente;
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
	public Long getIdAutore() {
		return idAutore;
	}
	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}
	public void setOpere(List<Quadro> opere) {
		this.opere = opere;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public Part getImmagine() {
		return immagine;
	}
	public void setImmagine(Part immagine) {
		this.immagine = immagine;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
}
