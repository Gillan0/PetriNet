package interfaces;
import classes.*;

import java.util.ArrayList;

import arcs.*;

public interface IPetriNet {

	public Place addPlace(int tokens) throws Exception;

	public ArcTP addArcTP(int w, Place p, Transition t) throws Exception;

	public ArcPT addArcPT(int w, Place p, Transition t) throws Exception;
	
	public ArcZero addArcZero(int w, Place p, Transition t) throws Exception;

	public ArcDrain addArcDrain(int w, Place p, Transition t) throws Exception;
	
	public Transition addTransition() throws Exception;
	
	public void removePlace(Place p);

	public void removeArcTP(Place p, Transition t);

	public void removeArcPT(Place p, Transition t);
	
	public void removeArcZero(Place p, Transition t);

	public void removeArcDrain(Place p, Transition t);
	
	public void removeTransition(Transition t);
	
	public ArrayList<Place> getPlaces();

	public ArrayList<ArcTP> getArcsTP();

	public ArrayList<ArcPT> getArcsPT();
	
	public ArrayList<ArcZero> getArcsZero();

	public ArrayList<ArcDrain> getArcsDrain();
	
	public ArrayList<Transition> getTransitions();
	
	
	
	
}
