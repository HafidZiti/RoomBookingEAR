package service;

import java.util.Date;
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

import metier.dao.DispoLocal;

import metier.entities.Disponibilite;

@Stateless
@Path("/")
public class DispoRestService {
	
	@EJB
	private DispoLocal metier;

	@POST
	@Path("/dispo") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Disponibilite addDisponibilite(Disponibilite d) {
		return metier.addDisponibilite(d);
	}

	@GET
	@Path("/dispo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Disponibilite getDisponibilite(@PathParam(value="id") int id) {
		return metier.getDisponibilite(id);
	}

	@GET
	@Path("/dispos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disponibilite> getAllDisponibilite() {
		return metier.getAllDisponibilite();
	}

	@PUT
	@Path("/dispo/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Disponibilite updateDisponibilite(@FormParam(value="id") int id, 
											@FormParam(value="date_debut") Date date_debut, 
											@FormParam(value="date_fin") Date date_fin) {
		return metier.updateDisponibilite(id, date_debut, date_fin);
	}

	@DELETE
	@Path("/dispo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteDisponibilite(@PathParam(value="id") int id) {
		metier.DeleteDisponibilite(id);
	}


}
