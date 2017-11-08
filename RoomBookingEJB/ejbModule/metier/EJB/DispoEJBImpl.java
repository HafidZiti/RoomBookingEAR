package metier.EJB;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.DispoLocal;
import metier.entities.Disponibilite;
import metier.entities.Hote;


@Stateless(name="Di")
public class DispoEJBImpl implements DispoLocal {

	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	
	@Override
	public Disponibilite addDisponibilite(Disponibilite d) {
		em.persist(d);
		return d;
	}

	@Override
	public Disponibilite getDisponibilite(int id) {
		Disponibilite d = em.find(Disponibilite.class, id);
		if (d==null) throw new RuntimeException("Disponibilité introuvable!!");
		return d;
	}

	@Override
	public List<Disponibilite> getAllDisponibilite() {
		Query req = em.createQuery("select d from Disponibilite d");
		return req.getResultList();
	}

	@Override
	public Disponibilite updateDisponibilite(int id, Date date_debut, Date date_fin) {
		Disponibilite d = em.find(Disponibilite.class, id);
		d.setDate_debut(date_debut);
		d.setDate_fin(date_fin);
		//em.merge(p);
		return d;
	}

	@Override
	public void DeleteDisponibilite(int id) {
		Disponibilite d = em.find(Disponibilite.class,id);
		    if (d != null) {
		      em.remove(d);
		    }

	}
	
}
