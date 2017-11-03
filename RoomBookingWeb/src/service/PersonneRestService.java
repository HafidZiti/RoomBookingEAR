package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.dao.PersonneLocal;
import metier.entities.Personne;

@Stateless
@Path("/")
public class PersonneRestService {
	
	@EJB
	private PersonneLocal metier;

	@POST
	@Path("/personne")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne addPersonne(Personne L) {
		return metier.addPersonne(L);
	}

	@GET
	@Path("/personne/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonne(@PathParam(value="id")int id) {
		return metier.getPersonne(id);
	}

	@GET
	@Path("/personnes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> getAllPersonne() {
		return metier.getAllPersonne();
	}

	@PUT
	@Path("/personne/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne updateLogement(@FormParam(value="id")int id, 
									@FormParam(value="adresse")String adresse, 
									@FormParam(value="email")String email, 
									@FormParam(value="telephone")String telephone, 
									@FormParam(value="nom")String nom, 
									@FormParam(value="prenom")String prenom,
									@FormParam(value="rip")String rip) {
		return metier.updateLogement(id, adresse, email, telephone, nom, prenom, rip);
	}
	
	@DELETE
	@Path("/personne/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePersonne(@PathParam(value="id")int id) {
		metier.deletePersonne(id);
	}

}
