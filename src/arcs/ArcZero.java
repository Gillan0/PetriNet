package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcZero extends Arc {

	public ArcZero(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		return false;
	}
	
	public boolean isActive() {
		return false;
	}

}
