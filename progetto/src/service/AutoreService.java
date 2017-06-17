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
	
	@PersistenceContext(name="test-unit")
	private EntityManager em;
	public Autore save(String nome,String cognome,String nazionalita,Date dataNascita,Date dataMorte){
		Autore nuovo=new Autore();
		nuovo.setNome(nome);
		nuovo.setCognome(cognome);
		nuovo.setNazionalita(nazionalita);
		nuovo.setDataDiMorte(dataMorte);
		nuovo.setDataDiNascita(dataNascita);
		em.persist(nuovo);
		return nuovo;
	}
	public Autore find(Long id){
		return em.find(Autore.class,id);
	}
	public List<Autore> findAll(){
		TypedQuery<Autore> query=em.createNamedQuery("tuttiAutori",Autore.class);
		return query.getResultList();
	}
}
