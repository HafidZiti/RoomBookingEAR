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

import com.sun.mail.iap.Response;


import metier.dao.ReservationLocal;
import metier.entities.Reservation;

@Stateless
@Path("/")
public class ReservationRestService {
	
	@EJB
	private ReservationLocal metier;
	
	
    
	
	@POST
	@Path("reservation") //JSON(application/json)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation addReservation(Reservation R) {
		return metier.addReservation(R);
	}

	
	@GET
	@Path("reservation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getReservation(@PathParam(value="id") int id) {
		return metier.getReservation(id);
	}

	
	@GET
	@Path("reservations")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getAllReservation() {
		return metier.getAllReservation();
	}

	
	@PUT
	@Path("reservation/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation updateReservation(@FormParam(value="id") int id,
										 @FormParam(value="duree") int duree) {
		return metier.updateReservation(id, duree);
	}

	@DELETE
	@Path("reservation/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteReservation(@PathParam(value="id") int id) {
		metier.deleteReservation(id);
	}
	


}
