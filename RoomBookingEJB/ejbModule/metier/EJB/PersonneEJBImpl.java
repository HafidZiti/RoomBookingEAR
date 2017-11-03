package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.PersonneLocal;

import metier.entities.Personne;

@Stateless(name="PE")
public class PersonneEJBImpl implements PersonneLocal {
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;

	@Override
	public Personne addPersonne(Personne p) {
		em.persist(p);
		return p;
	}

	@Override
	public Personne getPersonne(int id) {
		Personne p = em.find(Personne.class, id);
		if (p==null) throw new RuntimeException("Personne introuvable!!");
		return p;
	}

	@Override
	public List<Personne> getAllPersonne() {
		Query req = em.createQuery("select p from Personne p");
		return req.getResultList();
	}

	@Override
	public Personne updateLogement(int id, String adresse, String email, String telephone, String nom, String prenom,
									String rip) 
	{
		Personne p = new Personne();
		p.setAdresse(adresse);
		p.setEmail(email);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setTelephone(telephone);
		em.merge(p);
		return p;
	}

	@Override
	public void deletePersonne(int id) {
		em.remove(id);	
	}
}
