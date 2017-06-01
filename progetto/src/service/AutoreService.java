package service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Autore;

@Stateless(name="aService")
public class AutoreService {

	private EntityManager em;
	
	public Autore save(String nome, String cognome, String nazionalità, LocalDate dataNascita, LocalDate dataMorte){
		Autore a = new Autore();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setNazionalità(nazionalità);
		a.setDataDiNascita(dataNascita);
		a.setDataDiMorte(dataMorte);
		em.persist(a);
		return a;
	}
	
	public void delete(Autore a){
		em.remove(em.contains(a)? a: em.merge(a));
	}
	
	public Autore getAutore(Long id) {
		Autore autore = em.find(Autore.class, id);
		return autore;
	}
	
	public List<Autore> getAutori() {
		TypedQuery<Autore> query = em.createNamedQuery("findAll", Autore.class);
		List<Autore> autori = query.getResultList();
		return autori;
	}
}
