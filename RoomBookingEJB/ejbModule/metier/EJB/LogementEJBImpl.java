package metier.EJB;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Beans.LogementBean;
import metier.dao.LogementLocal;
import metier.entities.Client;
import metier.entities.Disponibilite;
import metier.entities.Equipement;
import metier.entities.Logement;

@Stateless(name = "LG")
public class LogementEJBImpl implements LogementLocal {

	@PersistenceContext(unitName = "RoomBookingEJB")
	private EntityManager em;

	@Override
	public Logement addLogement(Logement logement) {
		Logement newLogement = new Logement();
		newLogement = logement;
		em.persist(logement);
		return logement;
	}

	@Override
	public Logement addLogementBean(LogementBean logementBean) {

		Logement logement = new Logement();
		logement = logementBean.getLogement();
		em.persist(logement);
		Logement l01 = em.find(Logement.class, logement.getId_logement());
		l01.getEquipements().add(em.find(Equipement.class, 1));
		return logementBean.getLogement();
	}

	@Override
	public void add_equip_logement(int id, Set<Equipement> equips) {
		Logement l = em.find(Logement.class, id);
		equips.forEach((e) -> {
			l.getEquipements().add(em.find(Equipement.class, e.getId_equip()));
		});
	}

	@Override
	public Logement getLogement(int id) {
		Logement l = em.find(Logement.class, id);
		if (l == null)
			throw new RuntimeException("Logement introuvable");
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
		// em.merge(l);

		return l;
	}

	@Override
	public void deleteLogement(int id) {
		Logement logement = em.find(Logement.class, id);
		if (logement != null) {
			em.remove(logement);
		}

	}

	
	@Override
	public List<Logement> getLogementHote(int idClient) {
		Query query = em.createQuery("select l from Logement l where l.client.id_client='"+idClient+"'");
		return query.getResultList();
		}

	@Override
	public PageLogement getPageLogement(int page, int size, String ville, Date dateFrom, Date dateTo, int nbrVoyageur) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateFrom);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String DateFromformatted = format1.format(cal.getTime());
		cal.setTime(dateTo);
		String DateToformatted = format1.format(cal.getTime());
		Query query = em.createQuery("select l from Logement l where l.ville='"+ville+"' and l.nbt_voyageurs >= "+nbrVoyageur+" and l not in (select d.logement from Disponibilite d where "
								+ "d.date_debut between '" + DateFromformatted+" 00:00:00' and '" + DateToformatted+" 00:00:00' OR "
										+ " d.date_fin between '" + DateFromformatted +" 00:00:00' and '" + DateToformatted +" 00:00:00')");
		
		int pageNumber = page;
		int pageSize = size;
		query.setFirstResult((pageNumber) * pageSize);
		query.setMaxResults(pageSize);
		List<Logement> fooList = query.getResultList();

		Query queryTotal = em.createQuery("select count(l) from Logement l where l.ville='"+ville+"' and l.nbt_voyageurs >= "+nbrVoyageur+" and l not in (select d.logement from Disponibilite d where "
				+ "d.date_debut between '" + DateFromformatted+" 00:00:00' and '" + DateToformatted+" 00:00:00' OR "
						+ " d.date_fin between '" + DateFromformatted +" 00:00:00' and '" + DateToformatted +" 00:00:00')");
		
		long countResult = (long) queryTotal.getSingleResult();
		int nbrs = (int) (countResult / size);
		if ((countResult % size) > 0) {
			nbrs ++ ;
		}
		PageLogement pagelog = new PageLogement();
		pagelog.setLogemens(fooList);
		pagelog.setTotalLogement(countResult);
		pagelog.setTotal(nbrs);
		pagelog.setPages(page);

		return pagelog;
	}

	@Override
	public PageLogement getPageLogement(int page, int size) {
		Query query = em.createQuery("select l from Logement l");
		int pageNumber = page;
		int pageSize = size;
		query.setFirstResult((pageNumber) * pageSize);
		query.setMaxResults(pageSize);
		List<Logement> fooList = query.getResultList();

		Query queryTotal = em.createQuery("Select count(l.id_logement) from Logement l");
		long countResult = (long) queryTotal.getSingleResult();
		int nbrs = (int) (countResult / size);

		PageLogement pagelog = new PageLogement();
		pagelog.setLogemens(fooList);
		pagelog.setTotalLogement(countResult);
		pagelog.setTotal(nbrs);
		pagelog.setPages(page);

		return pagelog;
	}

}
