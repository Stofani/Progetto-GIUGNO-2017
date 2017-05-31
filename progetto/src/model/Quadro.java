package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quadro {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String titolo;
	private int annoRealizzazione;
	@ManyToOne
	private Tecnica tecnica;
	private String dimensioni;
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
	public int getDataRealizzazione() {
		return annoRealizzazione;
	}
	public void setDataRealizzazione(int dataRealizzazione) {
		this.annoRealizzazione = dataRealizzazione;
	}
	public Tecnica getTecnica() {
		return tecnica;
	}
	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}
	public String getDimensioni() {
		return dimensioni;
	}
	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}
