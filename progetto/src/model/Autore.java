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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Quadro;

@NamedQuery(name="findAll",query="SELECT a FROM Autore a")

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String nazionalità;
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
	public String getNazionalità() {
		return nazionalità;
	}
	public void setNazionalità(String nazionalità) {
		this.nazionalità = nazionalità;
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
	public int hashCode(){
		return this.nome.hashCode()+this.cognome.hashCode()+this.dataDiMorte.hashCode()+this.dataDiNascita.hashCode();
	}
	@Override
	public boolean equals(Object o){
		Autore that=(Autore)o;
		return this.nome.equals(that.getNome())&&this.cognome.equals(that.getCognome())
				&&this.dataDiNascita.equals(that.dataDiNascita);
	}
	@Override
	public String toString(){
		return this.nome+" "+this.cognome;
	}
	public Long getId() {
		return id;
	}
}
