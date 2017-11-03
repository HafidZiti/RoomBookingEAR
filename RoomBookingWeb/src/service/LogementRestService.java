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

import metier.dao.LogementLocal;
import metier.entities.Logement;

@Stateless
@Path("/")
public class LogementRestService {
	
	@EJB
	private LogementLocal metier;

	@POST
	@Path("/logement")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement addLogement(Logement L) {
		return metier.addLogement(L);
	}

	@GET
	@Path("/logement/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement getLogement(@PathParam(value="id")int id) {
		return metier.getLogement(id);
	}

	@GET
	@Path("/logements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Logement> getAllLogement() {
		return metier.getAllLogement();
	}

	@PUT
	@Path("/logement/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement updateLogement(@FormParam(value="id")int id, @FormParam(value="adresse")String adresse, 
									@FormParam(value="description")String description) {
		return metier.updateLogement(id, adresse, description);
	}

	@DELETE
	@Path("/logement/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteLogement(@PathParam(value="id")int id) {
		metier.deleteLogement(id);
	}
	
	

}
