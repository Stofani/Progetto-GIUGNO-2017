package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
