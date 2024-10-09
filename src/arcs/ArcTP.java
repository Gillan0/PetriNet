package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;

public class ArcTP extends Arc {

	public ArcTP(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public void distributeTokens() {
		return;
	}

}
