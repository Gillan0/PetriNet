package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;
import exception.NegativeException;

public class ArcZero extends ArcPT {

	public ArcZero(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		if (this.isActive()) {
			return super.isFireable();
		}
		return false;
	}
	
	public boolean isActive() {
		Place place = this.getPlace();
		return place.getToken() == 0;
	}

}
