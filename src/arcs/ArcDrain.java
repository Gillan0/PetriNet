package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcDrain extends Arc {

	public ArcDrain(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		return false;
	}
	
	public boolean isActive() {
		return false;
	}
	
	public void removeTokens() {
		return;
	}

}
