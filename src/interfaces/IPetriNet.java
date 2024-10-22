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
