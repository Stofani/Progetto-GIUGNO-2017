package controller;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
	private Autore autore;
	private Quadro operaCorrente;
	private List<Quadro> opere;
	//occorre perche' nella form specifico l'autore e ne acquisisco l'id
	private Long idAutore;
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	@EJB(beanName="qService")
	private QuadroService quadroService;
	public String salvaQuadro(){
		operaCorrente=quadroService.salva(titolo,annoRealizzazione,altezza,larghezza,idAutore);
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
	public List<Integer> listaAnni(){
		return quadroService.listaAnni();
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
}
