package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name="anniQuadri",query="SELECT DISTINCT q.anno FROM Quadro q")
@Entity
public class Quadro {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String titolo;
	private int annoRealizzazione;
	private String tecnica;
	private Integer altezza;
	private Integer larghezza;
	@ManyToOne
	private Autore autore;
	
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
	public Integer getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(int annoRealizzazione) {
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

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public Integer getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}

	public String getTecnica() {
		return tecnica;
	}
}
