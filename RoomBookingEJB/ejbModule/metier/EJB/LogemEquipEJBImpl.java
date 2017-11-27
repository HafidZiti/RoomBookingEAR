package metier.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.dao.Logement_equipementLocal;
import metier.entities.Logement_equipement;

@Stateless(name="LQ")
public class LogemEquipEJBImpl implements Logement_equipementLocal {

	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	
	
	@Override
	public Logement_equipement addLogemEquip(Logement_equipement LQ) {
		em.persist(LQ);
		return LQ;
	}

	@Override
	public void deleteLogemEquip(int id) {
		Logement_equipement Lq = em.find(Logement_equipement.class, id);
	    if (Lq != null) {
		      em.remove(Lq);
		    }
	}

}
