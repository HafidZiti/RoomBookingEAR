package metier.EJB;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.ReservationLocal;

import metier.entities.Reservation;

@Stateless(name="Re")
public class ReservationEJBImpl implements ReservationLocal{

	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;
	@Override
	public Reservation addReservation(Reservation R) {
	
		em.persist(R);
		return R;
	}

	@Override
	public Reservation getReservation(int id) {
		Reservation h = em.find(Reservation.class, id);
		if (h==null) throw new RuntimeException("Reservation introuvable!!");
		return h;
	}

	@Override
	public List<Reservation> getAllReservation() {
		Query req = em.createQuery("select h from Reservation h");
		return req.getResultList();
	}

	@Override
	public Reservation updateReservation(int id, int duree) {
		Reservation p = em.find(Reservation.class, id);
		p.setDuree(duree);
		return p;
	}

	@Override
	public void deleteReservation(int id) {
		Reservation h = em.find(Reservation.class,id);
	    if (h != null) {
	      em.remove(h);
	    }
		
	}

}
