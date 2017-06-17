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
	public Quadro salva(String titolo,int annoRealizzazione,Integer altezza,Integer larghezza,Long idAutore){
		Quadro q=new Quadro();
		q.setTitolo(titolo);
		q.setAnnoRealizzazione(annoRealizzazione);
		q.setAltezza(altezza);
		q.setLarghezza(larghezza);
		q.setAutore(em.find(Autore.class,idAutore));
		em.persist(q);
		return q;
	}
	public List<Integer> listaAnni(){
		TypedQuery<Integer> query=em.createNamedQuery("anniQuadri",Integer.class);
		return query.getResultList();
	}
	public List<Quadro> getAll(){
		TypedQuery<Quadro> query=em.createNamedQuery("tuttiIQuadri",Quadro.class);
		return query.getResultList();
	}
	public Quadro find(Long id){
		return em.find(Quadro.class,id);
	}
	public void remove(Long id){
		Quadro daRimuovere=em.find(Quadro.class,id);
		em.remove(daRimuovere);
	}
	public Quadro merge(Quadro q){
		return em.merge(q);
	}
	public List<Quadro> findPerAnno(Integer anno){
		TypedQuery<Quadro> query=em.createQuery("SELECT q FROM Quadro q where q.anno="+anno+"",Quadro.class);
		return query.getResultList();
	}
	public List<Quadro> findPerNazionalita(String nazionalita) {
		// TODO Auto-generated method stub
		return query.getResultList();
	}
}
