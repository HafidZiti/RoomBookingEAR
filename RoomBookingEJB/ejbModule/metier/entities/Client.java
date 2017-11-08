package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import metier.entities.Personne;


@Entity
@DiscriminatorValue("CL")
public class Client extends Personne implements Serializable {
		
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Reservation> reservations;
	
	
	public Client() {
		super();
	}


	@JsonIgnore
	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
   
}
