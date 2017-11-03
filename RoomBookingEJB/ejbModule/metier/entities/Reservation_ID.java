package metier.entities;

import java.io.Serializable;

public class Reservation_ID implements Serializable{
	
	private int client;
	private int logement;
	
	
	public int hashCode()
	{
		return (int)(client+logement);
	}
	
	  public boolean equals(Object object) {
		  if (object instanceof Reservation_ID) {
		    Reservation_ID otherId = (Reservation_ID) object;
		    return (otherId.client == this.client) && (otherId.logement == this.logement);
		  }
		 return false;
	 }

}
