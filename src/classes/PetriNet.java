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
	public void addPlace(Place p) throws Exception {
		if (p != null) {
			this.places.add(p);
		}
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
	public void addTransition(Transition t) throws Exception {
		// TODO Auto-generated method stub
		
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
		Place p1 = new Place(0);
		Place p2 = new Place(1);
		Place p3 = new Place(2);
		
		PetriNet pN = new PetriNet();
		System.out.println(pN.getPlaces());
		try {
			pN.addPlace(p1);
			pN.addPlace(p2);
			pN.addPlace(p3);
		} catch (Exception e) {
			System.out.println("Test not passed");
		}
		
	}
	
}
