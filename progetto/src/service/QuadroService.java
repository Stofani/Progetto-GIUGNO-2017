package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Autore;
import model.Quadro;
import model.Tecnica;

@Stateless(name="qService")
public class QuadroService {

	@PersistenceContext(unitName = "test-unit")
	private EntityManager em;
	
	public Quadro salva(String titolo,int annoRealizzazione, int altezza, int larghezza, Autore autore, Tecnica tecnica){
		 Quadro q = new Quadro();
		 q.setTitolo(titolo);
		 q.setAnnoRealizzazione(annoRealizzazione);
		 q.setAltezza(altezza);
		 q.setLarghezza(larghezza);
		 q.setAutore(autore);
		 q.setTecnica(tecnica);
		 em.persist(q);
		 return q;
	}
	
	public void delete(Quadro q){
		em.remove(em.contains(q)? q: em.merge(q));
	}
	
	public Quadro getQuadro(Long id) {
		Quadro quadro = em.find(Quadro.class, id);
		return quadro;
	}
	
	public List<Quadro> getQuadri() {
		TypedQuery<Quadro> query = em.createNamedQuery("findAll", Quadro.class);
		List<Quadro> quadri = query.getResultList();
		return quadri;
	}
}
