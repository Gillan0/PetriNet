package classes;

import java.util.ArrayList;

import arcs.*;
import interfaces.IPetriNet;

public class PetriNet implements IPetriNet {
	
	private ArrayList<Transition> transitions;
	private ArrayList<Place> places;
	private ArrayList<ArcTP> arcsTP;
	private ArrayList<ArcPT> arcsPT;
	private ArrayList<ArcZero> arcsZero;
	private ArrayList<ArcDrain> arcsDrain;
	
	
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
		return new ArcTP(0, null, null);
		
	}

	@Override
	public ArcPT addArcPT(int w, Place p, Transition t) throws Exception {
		return new ArcPT(0, null, null);
		
	}

	@Override
	public ArcZero addArcZero(int w, Place p, Transition t) throws Exception {
		return new ArcZero(0, null, null);
		
	}

	@Override
	public ArcDrain addArcDrain(int w, Place p, Transition t) throws Exception {
		return new ArcDrain(0, null, null);
		
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
		return this.arcsTP;
		
	}

	@Override
	public ArrayList<ArcPT> getArcsPT() {
		return this.arcsPT;
		
	}

	@Override
	public ArrayList<ArcZero> getArcsZero() {
		return this.arcsZero;
		
	}

	@Override
	public ArrayList<ArcDrain> getArcsDrain() {
		return this.arcsDrain;
		
	}

	@Override
	public ArrayList<Transition> getTransitions() {
		return this.transitions;
		
	}
	
	public static void main(String[] args) {
		
		PetriNet pN = new PetriNet();
		System.out.println(pN.getPlaces());
		try {
			pN.addPlace(0);
			pN.addPlace(1);
			pN.addPlace(2);
		} catch (Exception e) {
			System.out.println("Test not passed");
		}
		
	}
	
}
