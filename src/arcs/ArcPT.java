package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcPT extends Arc {
	

	public ArcPT(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		return false;
	}
	
	public void removeTokens() {
		return;
	}

}
