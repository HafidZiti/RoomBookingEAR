package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.CommeLocal;
import metier.entities.Commentaire;


@Stateless(name="Co")
public class CommeEJBImpl implements CommeLocal {

	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	
	@Override
	public Commentaire addCommentaire(Commentaire c) {
		em.persist(c);
		return c;
	}

	@Override
	public Commentaire getCommentaire(int id) {
		Commentaire c =em.find(Commentaire.class, id);
		if (c==null) throw new RuntimeException("Commentaire Introuvable!!");
		return c;
	}

	@Override
	public List<Commentaire> getAllCommentaire() {
		Query req = em.createQuery("select c form Commentaire c");
		return req.getResultList();
	}

	@Override
	public void deletCommentaire(int id) {
		Commentaire c =em.find(Commentaire.class, id);
		if (c!=null) em.remove(c);
	

	}

}
