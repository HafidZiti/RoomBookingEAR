package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.LogementLocal;


import metier.entities.Logement;

@Stateless(name="LG")
public class LogementEJBImpl implements LogementLocal {

	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	
	
	
	@Override
	public Logement addLogement(Logement L) {
		em.persist(L);
		return L;
	}

	@Override
	public Logement getLogement(int id) {
		Logement l = em.find(Logement.class, id);
		if (l==null) throw new RuntimeException("Logement introuvable");
		return l;
	}

	@Override
	public List<Logement> getAllLogement() {
		Query req = em.createQuery("select l from Logement l");
		return req.getResultList();
	}

	@Override
	public Logement updateLogement(int id, String adresse, String description) {
		Logement l = em.find(Logement.class, id);
		l.setAdresse(adresse);
		l.setDescription(description);
		//em.merge(l);
		
		return l;
	}

	@Override
	public void deleteLogement(int id) {
		Logement h = em.find(Logement.class,id);
	    if (h != null) {
	      em.remove(h);
	    }
		
	}

	@Override
	public PageLogement getPageLogement(int page, int size) {
		Query query = em.createQuery("select l from Logement l");
		int pageNumber = page;
		int pageSize = size;
		query.setFirstResult((pageNumber) * pageSize); 
		query.setMaxResults(pageSize);
		List <Logement> fooList = query.getResultList();
		
		
		Query queryTotal = em.createQuery ("Select count(l.id_logement) from Logement l");
		long countResult = (long)queryTotal.getSingleResult();
		int nbrs = (int) ((countResult / size));
		
		
		PageLogement pagelog= new PageLogement();
		pagelog.setLogemens(fooList);
		pagelog.setTotalLogement(countResult);
		pagelog.setTotal(nbrs);
		pagelog.setPages(page);
		
		
		return pagelog;
	}

}
