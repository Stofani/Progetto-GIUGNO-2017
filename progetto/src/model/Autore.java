package model;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String nome;
	private String cognome;
	private String nazionalitÓ;
	@Temporal(TemporalType.DATE)
	private LocalDate dataDiNascita;
	@Temporal(TemporalType.DATE)
	private LocalDate dataDiMorte;
	private List<Quadro> quadri;
	public Autore(){
		quadri=new LinkedList<Quadro>();
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
	public String getNazionalitÓ() {
		return nazionalitÓ;
	}
	public void setNazionalitÓ(String nazionalitÓ) {
		this.nazionalitÓ = nazionalitÓ;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public LocalDate getDataDiMorte() {
		return dataDiMorte;
	}
	public void setDataDiMorte(LocalDate dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}
	public List<Quadro> getQuadri() {
		return quadri;
	}
	public void addQuadro(Quadro quadro){
		this.quadri.add(quadro);
	}
}
