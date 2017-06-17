package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Autore;

@Stateless(name="aService")
public class AutoreService {
@PersistenceContext(unitName="test-unit")
	private EntityManager em;
	public Autore save(String nome,String cognome,String nazionalita,Date dataNascita,Date dataMorte){
		Autore nuovo=new Autore();
		nuovo.setNome(nome);
		nuovo.setCognome(cognome);
		nuovo.setNazionalita(nazionalita);
		nuovo.setDataDiNascita(dataNascita);
		nuovo.setDataDiMorte(dataMorte);
		em.persist(nuovo);
		return nuovo;
	}
	public List<Autore> findAll(){
		TypedQuery<Autore> query=em.createNamedQuery("findAll",Autore.class);
		return query.getResultList();
	}
	public Autore find(Long id){
		return em.find(Autore.class,id);
	}
	public void remove(Long id){
		Autore daRimuovere=em.find(Autore.class,id);
		em.remove(daRimuovere);
	}
	public Autore merge(Autore a){
		return em.merge(a);
	}
	public Autore find(Long id){
		return em.find(Autore.class,id);
	}
	public List<String> listaNazioni(){
		TypedQuery<String> query=em.createNamedQuery("nazioniAutori",String.class);
		return query.getResultList();
	}
}
