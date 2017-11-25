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

import metier.dao.ClientLocal;
import metier.entities.Client;

@Stateless
@Path("/")

public class ClientRestService {
	
	@EJB
	private ClientLocal metier;

	@POST
	@Path("/client") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Client addClient(Client L) {
		return metier.addClient(L);
	}

	@GET
	@Path("/client/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClient(@PathParam(value="id") int id) {
		return metier.getClient(id);
	}

	@GET
	@Path("/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAllClient() {
		return metier.getAllClient();
	}

	@PUT
	@Path("/client/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Client updateClient(@FormParam(value="id") int id, 
								@FormParam(value="adresse") String adresse, 
								@FormParam(value="email") String email, 
								@FormParam(value="telephone") String telephone,
								@FormParam(value="nom") String nom, 
								@FormParam(value="prenom") String prenom) {
		return metier.updateClient(id, adresse, email, telephone, nom, prenom);
	}

	@DELETE
	@Path("/client/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteClient(@PathParam(value="id") int id) {
		metier.deleteClient(id);
	}
	
	@PUT
	@Path("/client/setHote/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client devenirHote(@PathParam(value="id") int id) {
		return metier.devenirHote(id);
	}

}
