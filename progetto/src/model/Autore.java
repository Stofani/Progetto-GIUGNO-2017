package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import model.Quadro;

@NamedQuery(name="findAll",query="SELECT a FROM Autore a")

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome","cognome"}))
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String nazionalita;
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	@Temporal(TemporalType.DATE)
	private Date dataDiMorte;
	@OneToMany(mappedBy="autore")
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
	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
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
	public List<Quadro> getQuadri() {
		return quadri;
	}
	public void addQuadro(Quadro quadro){
		this.quadri.add(quadro);
	}
	@Override
	public String toString(){
		return this.nome+" "+this.cognome;
	}
	public Long getId() {
		return id;
	}
}
