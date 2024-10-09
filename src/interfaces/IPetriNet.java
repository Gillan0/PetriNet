package interfaces;
import classes.*;

import java.util.ArrayList;

import arcs.*;

public interface IPetriNet {

	public void addPlace(Place p);

	public void addArcTP(ArcTP a);

	public void addArcPT(ArcPT a);
	
	public void addArcZero(ArcZero a);

	public void addArcDrain(ArcDrain a);
	
	public void addTransition(Transition t);
	
	public void removePlace(Place p);

	public void removeArcTP(ArcTP a);

	public void removeArcPT(ArcPT a);
	
	public void removeArcZero(ArcZero a);

	public void removeArcDrain(ArcDrain a);
	
	public void removeTransition(Transition t);
	
	public ArrayList<Place> getPlaces();

	public ArrayList<ArcTP> getArcsTP();

	public ArrayList<ArcPT> getArcsPT();
	
	public ArrayList<ArcZero> getArcsZero();

	public ArrayList<ArcDrain> getArcsDrain();
	
	public ArrayList<Transition> getTransitions();
	
	
	
	
}
