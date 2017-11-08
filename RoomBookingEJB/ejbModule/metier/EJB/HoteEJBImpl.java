package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.HoteLocal;
import metier.entities.Hote;


@Stateless(name="Ho")
public class HoteEJBImpl implements HoteLocal {
	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;

	@Override
	public Hote addHote(Hote L) {
	
		em.persist(L);
		return L;
	}

	@Override
	public Hote getHote(int id) {
		Hote h = em.find(Hote.class, id);
		if (h==null) throw new RuntimeException("Personne introuvable!!");
		return h;
	}

	@Override
	public List<Hote> getAllHote() {
		Query req = em.createQuery("select h from Hote h");
		return req.getResultList();
	}

	@Override
	public Hote updateHote(int id, String adresse, String email, String telephone, String nom, String prenom,
			String rip) {
		Hote p = em.find(Hote.class, id);
		p.setAdresse(adresse);
		p.setEmail(email);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setTelephone(telephone);
		p.setRIP(rip);
		//em.merge(p);
		return p;
	}
	

	@Override
	public void deleteHote(int id) {
		 Hote h = em.find(Hote.class,id);
		    if (h != null) {
		      em.remove(h);
		    }
	}


}
