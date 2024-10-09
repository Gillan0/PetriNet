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
		this.arcsTP = new ArrayList<ArcTP>();
		this.arcsPT = new ArrayList<ArcPT>();
		this.arcsZero = new ArrayList<ArcZero>();
		this.arcsDrain = new ArrayList<ArcDrain>();
	}

	@Override
	public void addPlace(Place p) throws Exception {
		if (p != null) {
			this.places.add(p);
		}
	}

	@Override
	public void addArcTP(ArcTP a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcPT(ArcPT a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcZero(ArcZero a) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcDrain(ArcDrain a) throws Exception {
		// TODO Auto-generated method stub
		
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
	public void removeArcTP(ArcTP a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcPT(ArcPT a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcZero(ArcZero a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArcDrain(ArcDrain a) {
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
