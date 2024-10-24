package classes;

import java.util.ArrayList;

import arcs.*;
import exceptions.*;
import interfaces.IPetriNet;

public class PetriNet implements IPetriNet {
	
	private ArrayList<Transition> transitions;
	private ArrayList<Place> places;
	
	public PetriNet() {
		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();
		
	}

	@Override
	public Place addPlace(int tokens) throws NegativeException {
		
		if (tokens < 0) {
			throw new NegativeException("Place can't have a negative amount of tokens");
		}
		
		Place p = new Place(tokens);
		this.places.add(p);
		
		return p;
			
	}
	
	public void checkAddArcExceptions(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException {
		if (w < 0) {
			throw new NegativeException("Arc weight can't be negative");
		}
		
		if (p == null) {
			throw new MissingPlaceException("Place can't be null");
		}
		
		if (t == null) {
			throw new MissingTransitionException("Transition can't be null");
		}
	}


	@Override
	public ArcTP addArcTP(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException {
		
		checkAddArcExceptions(w, p ,t);
		
		return new ArcTP(w, p, t);
		
	}

	@Override
	public ArcPT addArcPT(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException {
		
		checkAddArcExceptions(w, p ,t);
		
		return new ArcPT(w, p, t);
		
	}

	@Override
	public ArcZero addArcZero(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException {
		
		checkAddArcExceptions(w, p ,t);
		
		return new ArcZero(w, p, t);
		
	}

	@Override
	public ArcDrain addArcDrain(int w, Place p, Transition t) throws NegativeException, MissingPlaceException, MissingTransitionException {
		
		checkAddArcExceptions(w, p ,t);
		
		return new ArcDrain(w, p, t);
		
	}
	
	@Override
	public Transition addTransition() {
		Transition t = new Transition();
		
		this.transitions.add(t);
		
		return t;
		
	}

	@Override
	public void removePlace(Place p) throws MissingPlaceException {
		if (p == null) {
			throw new MissingPlaceException("Place can not be null");
		}
		
		if (!this.getPlaces().contains(p)) {
			throw new MissingPlaceException("Place not in PetriNet");
		}
		
		this.places.remove(p);
		
	}

	@Override
	public void removeArcTP(ArcTP a) throws MissingArcException {
		if (a == null) {
			throw new MissingArcException("Arc can not be null");
		}
		
		if (!this.getArcsTP().contains(a)) {
			throw new MissingArcException("Arc not in PetriNet");
		}
		
		Transition t = a.getTransition();
		t.removeArcTP(a);
		
	}

	@Override
	public void removeArcPT(ArcPT a) throws MissingArcException {
		if (a == null) {
			throw new MissingArcException("Arc can not be null");
		}
		
		if (!this.getArcsPT().contains(a)) {
			throw new MissingArcException("Arc not in PetriNet");
		}
		
		Transition t = a.getTransition();
		t.removeArcPT(a);
		
	}

	@Override
	public void removeArcZero(ArcZero a) throws MissingArcException {
		if (a == null) {
			throw new MissingArcException("Arc can not be null");
		}
		
		if (!this.getArcsPT().contains((ArcPT) a)) {
			throw new MissingArcException("Arc not in PetriNet");
		}
		
		Transition t = a.getTransition();
		t.removeArcPT((ArcPT) a);
		
	}

	@Override
	public void removeArcDrain(ArcDrain a) throws MissingArcException {
		if (a == null) {
			throw new MissingArcException("Arc can not be null");
		}
		
		if (!this.getArcsPT().contains((ArcDrain) a)) {
			throw new MissingArcException("Arc not in PetriNet");
		}
		
		Transition t = a.getTransition();
		t.removeArcPT((ArcDrain) a);
		
	}

	@Override
	public void removeTransition(Transition t) throws MissingTransitionException {
		if (t == null) {
			throw new MissingTransitionException("Transition can not be null");
		}
		
		if (!this.getTransitions().contains(t)) {
			throw new MissingTransitionException("Transition not in PetriNet");
		}
		
		this.transitions.remove(t);		
	}

	@Override
	public ArrayList<Place> getPlaces() {
		return this.places;
		
	}

	@Override
	public ArrayList<ArcTP> getArcsTP() {
		
		ArrayList<ArcTP> arcsTP = new ArrayList<ArcTP>();
		
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		
		for (int i =0; i < transitions.size() ; i++) {
		
			ArrayList<ArcTP> subList = transitions.get(i).getArcsTP();
			
			for (int j=0 ; j < subList.size(); j++) {
			
				if (subList.get(j) instanceof ArcTP) {
				
					arcsTP.add(subList.get(j));
				
				}
			
			}
			
		}
		
		return arcsTP;
		
	}

	@Override
	public ArrayList<ArcPT> getArcsPT() {
		ArrayList<ArcPT> arcsPT = new ArrayList<ArcPT>();
		
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		
		for (int i =0; i < transitions.size() ; i++) {
		
			ArrayList<ArcPT> subList = transitions.get(i).getArcsPT();
			
			for (int j=0 ; j < subList.size(); j++) {
			
				if (subList.get(j) instanceof ArcPT) {
				
					arcsPT.add(subList.get(j));
				
				}
			
			}
			
		}
		
		return arcsPT;
		
	}

	@Override
	public ArrayList<ArcZero> getArcsZero() {
		ArrayList<ArcZero> arcsZero = new ArrayList<ArcZero>();
		
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		
		for (int i =0; i < transitions.size() ; i++) {
		
			ArrayList<ArcPT> subList = transitions.get(i).getArcsPT();
			
			for (int j=0 ; j < subList.size(); j++) {
				
				if (subList.get(j) instanceof ArcZero) {
				
					arcsZero.add((ArcZero) subList.get(j));		
				}
							
			}
			
		}
		
		return arcsZero;
		
	}

	@Override
	public ArrayList<ArcDrain> getArcsDrain() {
		ArrayList<ArcDrain> arcsDrain = new ArrayList<ArcDrain>();
		
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		
		for (int i =0; i < transitions.size() ; i++) {
		
			ArrayList<ArcPT> subList = transitions.get(i).getArcsPT();
			
			for (int j=0 ; j < subList.size(); j++) {
				
				if (subList.get(j) instanceof ArcDrain) {
				
					arcsDrain.add((ArcDrain) subList.get(j));		
				}
							
			}
			
		}
		
		return arcsDrain;
		
	}

	@Override
	public ArrayList<Transition> getTransitions() {
		return this.transitions;
		
	}
	
	
}
