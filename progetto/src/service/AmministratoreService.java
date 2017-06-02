package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Amministratore;

@Stateless(name="amService")
public class AmministratoreService {

	@PersistenceContext(unitName="test-unit")
	private EntityManager em;
	public Amministratore getAmministratoreByUser(String username){
		TypedQuery<Amministratore> query=em.createNamedQuery("trovaAmministratoriPerUsername",Amministratore.class);
		query.setParameter("username",username);
		try{
			return query.getSingleResult();}
		catch(NoResultException e){
			return null;
		}
	}
	public Amministratore find(Long id){
		return em.find(Amministratore.class,id);
	}
	public boolean checkPassword(Amministratore a,String password){
		return a.checkPassword(password);
	}
}
