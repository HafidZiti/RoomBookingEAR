package metier.EJB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.ReservationLocal;
import metier.dto.MailSender;
import metier.entities.Client;
import metier.entities.Disponibilite;
import metier.entities.Logement;
import metier.entities.Reservation;

@Stateless(name = "Re")
public class ReservationEJBImpl implements ReservationLocal {

	@PersistenceContext(unitName = "RoomBookingEJB")
	private EntityManager em;

	@Override
	public Reservation addReservation(Reservation reservation) {

		try {
			em.persist(reservation);
			Disponibilite d = new Disponibilite(reservation.getDate_Debut(), reservation.getDate_Fin(), reservation.getLogement());
			em.persist(d);
			Client client = em.find(Client.class, reservation.getClient().getId_client());
			Logement logement = em.find(Logement.class, reservation.getLogement().getId_logement());
			Client hote = em.find(Client.class, logement.getClient().getId_client());
			SendMailtoClient(client, hote, logement, reservation);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return reservation;
	}

	public void SendMailtoClient(Client client, Client hote, Logement logement, Reservation r) {

		Session session = MailSender.initSession();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		String clientMessage = "Cher " + client.getNom() + "," + " vous avez reserv� le logement " + logement.getTitre()+ " du "+dateFormat.format(r.getDate_Debut())+" au "+dateFormat.format(r.getDate_Fin())+ " pour un prix de "+r.getPrix_duree()+"�.";
		MailSender.send(client.getEmail(), clientMessage, session);

		String hoteMessage = "Cher " + hote.getNom() + "," + " votre logement " + logement.getTitre()+ " a �t� r�serv� par " + client.getNom()+". \n\n La r�servation  sera du "+dateFormat.format(r.getDate_Debut())+" au "+dateFormat.format(r.getDate_Fin())+ " pour un prix de "+r.getPrix_duree()+"�.";
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
	public Reservation updateReservation(int id, Date datefin) {
		Reservation p = em.find(Reservation.class, id);
		p.setDate_Fin(datefin);
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
