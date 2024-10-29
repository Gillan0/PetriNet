package interfaces;
import classes.*;
import exception.*;

import java.util.ArrayList;

import arcs.*;

public interface IPetriNet {

	public Place addPlace(int tokens) throws NegativeException;

	public ArcTP addArcTP(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

	public ArcPT addArcPT(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;
	
	public ArcZero addArcZero(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

	public ArcDrain addArcDrain(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;
	
	public Transition addTransition();
	
	public void removePlace(Place p) throws MissingPlaceException;

	public void removeArcTP(ArcTP a) throws MissingArcException;

	public void removeArcPT(ArcPT a) throws MissingArcException;
	
	public void removeArcZero(ArcZero a) throws MissingArcException;

	public void removeArcDrain(ArcDrain a) throws MissingArcException;
	
	public void removeTransition(Transition t) throws MissingTransitionException;
	
	public ArrayList<Place> getPlaces();

	public ArrayList<ArcTP> getArcsTP();

	public ArrayList<ArcPT> getArcsPT();
	
	public ArrayList<ArcZero> getArcsZero();

	public ArrayList<ArcDrain> getArcsDrain();
	
	public ArrayList<Transition> getTransitions();
	
}
