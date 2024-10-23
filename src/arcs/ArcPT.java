package arcs;

import classes.Arc;
import classes.Place;
import classes.Transition;
import exceptions.NegativeException;

public class ArcPT extends Arc {
	
	public ArcPT(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isFireable() {
		Place place = this.getPlace();
		return place.getToken() >= this.getWeight();
	}
	
	public void removeTokens() {
		Place place = this.getPlace();
		place.setTokens(place.getToken() - this.getWeight());
	}

}
