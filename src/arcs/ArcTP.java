package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;
import exception.NegativeException;

public class ArcTP extends Arc {

	public ArcTP(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public void distributeTokens() {
		Place place = this.getPlace();
		place.setTokens(place.getToken() + this.getWeight());
	}

}
