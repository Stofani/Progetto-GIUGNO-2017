package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Autore;
import model.Quadro;

@Stateless(name="qService")
public class QuadroService {

	@PersistenceContext(unitName = "test-unit")
	private EntityManager em;
	
	public Quadro salva(String titolo,int annoRealizzazione){
		 Quadro q=new Quadro();
		 q.setTitolo(titolo);
		 q.setAnnoRealizzazione(annoRealizzazione);
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
