package metier.entities;

import java.io.Serializable;

public class Logement_Equipement_ID implements Serializable {
	
	private int logement;
	private int equipement;
	
	public int hashCode()
	{
		return (int)(logement+equipement);
	}
	
	  public boolean equals(Object object) {
		  if (object instanceof Logement_Equipement_ID) {
			  Logement_Equipement_ID otherId = (Logement_Equipement_ID) object;
		    return (otherId.logement == this.logement) && (otherId.equipement == this.equipement);
		  }
		 return false;
	 }
	
}
