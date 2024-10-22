package classes;

import java.util.ArrayList;

import arcs.*;
import interfaces.IPetriNet;

public class PetriNet implements IPetriNet {
	
	private ArrayList<Transition> transitions;
	private ArrayList<Place> places;
	
	public PetriNet() {
		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();
	}

	@Override
	public Place addPlace(int tokens) throws Exception {
		if (tokens >= 0) {
			Place p = new Place(tokens);
			this.places.add(p);
			return p;
		}
		return null;
	}

	@Override
	public ArcTP addArcTP(int w, Place p, Transition t) throws Exception {
		return new ArcTP(w, p, t);
		
	}

	@Override
	public ArcPT addArcPT(int w, Place p, Transition t) throws Exception {
		return new ArcPT(w, p, t);
		
	}

	@Override
	public ArcZero addArcZero(int w, Place p, Transition t) throws Exception {
		return new ArcZero(w, p, t);
		
	}

	@Override
	public ArcDrain addArcDrain(int w, Place p, Transition t) throws Exception {
		return new ArcDrain(w, p, t);
		
	}

	@Override
	public Transition addTransition() throws Exception {
		Transition t = new Transition();
		return t;
		
	}

	@Override
	public void removePlace(Place p) {
		if (p != null) {
			this.places.remove(p);
		}	
	}

	@Override
	public void removeArcTP(Place p, Transition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcPT(Place p, Transition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcZero(Place p, Transition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcDrain(Place p, Transition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTransition(Transition t) {
		// TODO Auto-generated method stub
		
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
