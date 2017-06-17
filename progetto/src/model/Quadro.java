package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
@NamedQuery(name="tuttiIQuadri",query="SELECT q FROM Quadro q"),
@NamedQuery(name="anniQuadri",query="SELECT DISTINCT q.annoRealizzazione FROM Quadro q ORDER BY q.annoRealizzazione")
})
@Entity
public class Quadro {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String titolo;
	private Integer annoRealizzazione;
	private String tecnica;
	private Integer altezza;
	private Integer larghezza;
	@ManyToOne(fetch=FetchType.EAGER)
	private Autore autore;
	private byte[] immagine;
	
	public Quadro() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
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

	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Integer getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}
}
