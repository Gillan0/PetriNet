package interfaces;
import classes.*;

import java.util.ArrayList;

import arcs.*;

public interface IPetriNet {

	public void addPlace(Place p) throws Exception;

	public void addArcTP(ArcTP a) throws Exception;

	public void addArcPT(ArcPT a) throws Exception;
	
	public void addArcZero(ArcZero a) throws Exception;

	public void addArcDrain(ArcDrain a) throws Exception;
	
	public void addTransition(Transition t) throws Exception;
	
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
