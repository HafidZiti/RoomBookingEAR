package metier.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.dao.ClientLocal;
import metier.entities.Client;


@Stateless(name="Cl")
public class ClientEJBImpl implements ClientLocal {
	
	@PersistenceContext(unitName="RoomBookingEJB")
	private EntityManager em;

	public Client addClient(Client L) {
		em.persist(L);
		return L;
	}

	@Override
	public Client getClient(String mail, String mdp) {
		Query req = em.createQuery("select c from Client c where c.email='"+mail+"' and c.mdp='"+mdp+"'");
		Client h = (Client) req.getSingleResult();
		if (h==null) throw new RuntimeException("Aucun compte n'est associé à ces identifiants !");
		return h;
	}

	@Override
	public Client getClient(int id) {
		Client h = em.find(Client.class, id);
		if (h==null) throw new RuntimeException("Client introuvable!!");
		return h;
	}

	@Override
	public List<Client> getAllClient() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public Client updateClient(int id, String adresse, String email, String telephone, String nom, String prenom , Boolean isHote) {
		Client p = em.find(Client.class, id);
		p.setAdresse(adresse);
		p.setEmail(email);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setTelephone(telephone);
		p.setIsHote(isHote);
		em.merge(p);
		return p;
	}
	@Override
	public Client updateClient(Client l) {
		Client p = em.find(Client.class, l.getId_client());
		p.setAdresse(l.getAdresse());
		p.setEmail(l.getEmail());
		p.setNom(l.getNom());
		p.setPrenom(l.getPrenom());
		p.setTelephone(l.getTelephone());
		p.setIsHote(l.getIsHote());
		em.merge(p);
		return p;
	}

	@Override
	public void deleteClient(int id) {
		 Client h = em.find(Client.class,id);
		    if (h != null) {
		      em.remove(h);
		    }

	}

	@Override
	public Client devenirHote(int id) {
		Client p = em.find(Client.class, id);
		p.setIsHote(true);
		return p;
	}

}
