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
	public void addPlace(Place p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcTP(ArcTP a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcPT(ArcPT a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcZero(ArcZero a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArcDrain(ArcDrain a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTransition(Transition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlace(Place p) {
		// TODO Auto-generated method stub
		
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
		return new ArrayList<Place>();
		
	}

	@Override
	public ArrayList<ArcTP> getArcsTP() {
		return new ArrayList<ArcTP>();
		
	}

	@Override
	public ArrayList<ArcPT> getArcsPT() {
		return new ArrayList<ArcPT>();
		
	}

	@Override
	public ArrayList<ArcZero> getArcsZero() {
		return new ArrayList<ArcZero>();
		
	}

	@Override
	public ArrayList<ArcDrain> getArcsDrain() {
		return new ArrayList<ArcDrain>();
		
	}

	@Override
	public ArrayList<Transition> getTransitions() {
		return new ArrayList<Transition>();
		
	}

}
