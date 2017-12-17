package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.ReservationLocal;
import metier.dto.MailSender;
import metier.entities.Client;
import metier.entities.Logement;
import metier.entities.Reservation;

@Stateless(name = "Re")
public class ReservationEJBImpl implements ReservationLocal {

	@PersistenceContext(unitName = "RoomBookingEJB")
	private EntityManager em;

	@Override
	public Reservation addReservation(Reservation R) {

		try {

			em.persist(R);

			Client client = em.find(Client.class, R.getClient().getId_client());
			Logement logement = em.find(Logement.class, R.getLogement().getId_logement());
			Client hote = em.find(Client.class, logement.getClient().getId_client());

			SendMailtoClient(client, hote, logement);

		} catch (Exception e) {
		}

		return R;
	}

	public void SendMailtoClient(Client client, Client hote, Logement logement) {

		Session session = MailSender.initSession();

		String clientMessage = "Cher " + client.getNom() + "," + "vous avez reservé le logement " + logement.getTitre();
		MailSender.send(client.getEmail(), clientMessage, session);

		String hoteMessage = "Cher " + hote.getNom() + "," + " votre logement " + logement.getTitre()
				+ " a été réservé par " + client.getNom();
		MailSender.send(hote.getEmail(), hoteMessage, session);
	}

	@Override
	public Reservation getReservation(int id) {
		Reservation h = em.find(Reservation.class, id);
		if (h == null)
			throw new RuntimeException("Reservation introuvable!!");
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
		Reservation h = em.find(Reservation.class, id);
		if (h != null) {
			em.remove(h);
		}

	}

}
