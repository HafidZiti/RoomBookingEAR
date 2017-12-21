package metier.EJB;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.DispoLocal;
import metier.entities.Disponibilite;


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
		if (d==null) throw new RuntimeException("Disponibilit� introuvable!!");
		return d;
	}

	@Override
	public List<Disponibilite> getDisponibiliteLogement(int id) {
		Query req = em.createQuery("select d from Disponibilite d where d.logement ="+id);
		return req.getResultList();
	}

	@Override
	public List<Disponibilite> getAllDisponibilite() {
		Query req = em.createQuery("select d from Disponibilite d");
		return req.getResultList();
	}

	@Override
	public Disponibilite updateDisponibilite(int id, Date dateFrom, Date dateTo) {
		Disponibilite d = em.find(Disponibilite.class, id);
		d.setDate_debut(dateFrom);
		d.setDate_fin(dateTo);
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
