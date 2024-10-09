package arcs;

import Exceptions.NegativeException;
import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcZero extends Arc {

	public ArcZero(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		Place place = this.getPlace();
		return place.getToken() == 0;
	}
	
	public boolean isActive() {
		return false;
	}

}
