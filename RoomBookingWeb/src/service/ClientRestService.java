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
	
	@POST
	@Path("/client/update") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Client updateClient(Client L) {
		return metier.updateClient(L);
	}
	
	@GET
	@Path("/client/login/{email}/{mdp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client doLogin(@PathParam(value="email") String email, @PathParam(value="mdp") String mdp ) {
		return metier.getClient(email,mdp);
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
	@Path("/client/put/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Client updateClientOldV(Client client) {
		return metier.updateClient(client.getId_client(), "", "", "", "", "" ,true);
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
