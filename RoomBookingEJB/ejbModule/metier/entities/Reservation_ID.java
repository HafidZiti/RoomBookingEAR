package metier.entities;

import java.io.Serializable;

public class Reservation_ID implements Serializable{
	
	private int client;
	private int logement;
	
	@Override
	public int hashCode()
	{
		return (client+logement);
	}
	
	@Override
	  public boolean equals(Object object) {
		  if (object instanceof Reservation_ID) {
		    Reservation_ID otherId = (Reservation_ID) object;
		    return (otherId.client == this.client) && (otherId.logement == this.logement);
		  }
		 return false;
	 }

}
