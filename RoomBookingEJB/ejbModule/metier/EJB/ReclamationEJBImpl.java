package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.ReclamationLocal;
import metier.entities.Reclamation;


@Stateless(name="Rec")
public class ReclamationEJBImpl implements ReclamationLocal {

	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	@Override
	public Reclamation addReclamation(Reclamation R) {
		em.persist(R);
		return R;
	}

	@Override
	public Reclamation getReclamation(int id) {
		Reclamation h = em.find(Reclamation.class, id);
		if (h==null) throw new RuntimeException("Reclamation introuvable!!");
		return h;
	}

	@Override
	public List<Reclamation> getAllReclamation() {
		Query req = em.createQuery("select h from Reclamation h");
		return req.getResultList();
	}

	@Override
	public void deleteReclamation(int id) {
		Reclamation h = em.find(Reclamation.class,id);
		    if (h != null) {
		      em.remove(h);
		    }

	}

}
