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
	public Quadro salva(String titolo,Integer annoRealizzazione,Integer altezza,Integer larghezza,
			String tecnica,Long idAutore,byte[] immagine){
		 Quadro q=new Quadro();
		 q.setTitolo(titolo);
		 q.setAnnoRealizzazione(annoRealizzazione);
		 q.setAltezza(altezza);
		 q.setLarghezza(larghezza);
		 q.setTecnica(tecnica);
		 q.setAutore(em.find(Autore.class,idAutore));
		 q.setImmagine(immagine);
		 em.persist(q);
		 return q;
	}
	public Quadro find(Long id){
		return em.find(Quadro.class,id);
	}
	public List<Quadro> getAll(){
		TypedQuery<Quadro> query=em.createNamedQuery("tuttiIQuadri",Quadro.class);
		return query.getResultList();
	}
	public void remove(Long id){
		Quadro q=this.find(id);
		em.remove(q);
		return;
	}
	public Quadro merge(Quadro q,Long idAutore){
		Autore nuovo=this.em.find(Autore.class,idAutore);
		q.setAutore(nuovo);
		return em.merge(q);
	}
	public List<Integer> listaAnni(){
		TypedQuery<Integer> query=em.createNamedQuery("anniQuadri",Integer.class);
		return query.getResultList();
	}
	public List<Quadro> getAll(){
		TypedQuery<Quadro> query=em.createNamedQuery("tuttiIQuadri",Quadro.class);
		return query.getResultList();
	}
	public List<Quadro> findPerAnno(Integer anno){
		TypedQuery<Quadro> query=em.createQuery("SELECT q FROM Quadro q where q.annoRealizzazione="+anno+"",Quadro.class);
		return query.getResultList();
	}
	public List<Quadro> findPerNazionalita(String nazionalita) {
		TypedQuery<Quadro> query=em.createQuery("SELECT q FROM Quadro q WHERE q.autore.nazionalita='"+nazionalita+"'",Quadro.class);
		return query.getResultList();
	}
}
