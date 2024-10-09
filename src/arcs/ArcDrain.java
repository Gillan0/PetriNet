package arcs;

import Exceptions.NegativeException;
import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcDrain extends Arc {

	public ArcDrain(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		Place place = this.getPlace();
		return place.getToken() > 0;
	}
	
	public boolean isActive() {
		return false;
	}
	
	public void removeTokens() {
		return;
	}

}