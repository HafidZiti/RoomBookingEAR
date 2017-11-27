package service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.dao.Logement_equipementLocal;
import metier.entities.Logement_equipement;

@Stateless
@Path("/")
public class LogemEquipRestService {
	
	@EJB
	private Logement_equipementLocal metier;

	
	@POST
	@Path("/logement_equipement")
	@Produces(MediaType.APPLICATION_JSON)
	public Logement_equipement addLogemEquip(Logement_equipement LQ) {
		return metier.addLogemEquip(LQ);
	}

	
	@DELETE
	@Path("/logement_equipement") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteLogemEquip(@PathParam(value="id") int id) {
		metier.deleteLogemEquip(id);
	}
	

}
