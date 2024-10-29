package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import arcs.*;
import classes.*;
import exception.*;
import exception.NegativeException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PetriNetTest {
	
	private PetriNet emptyPetriNet;
	private PetriNet petriNet;
	private ArrayList<Transition> emptyTransitions;
	private ArrayList<Place> emptyPlaces;
	private ArrayList<Transition> transitions;
	private ArrayList<Place> places;
	
	
	@BeforeEach
	void setup() throws Exception {
		this.emptyPetriNet = new PetriNet();
		this.petriNet = new PetriNet();
		this.emptyTransitions = new ArrayList<Transition>();
		this.emptyPlaces = new ArrayList<Place>();	
		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();	

		
		this.places.add(this.petriNet.addPlace(1));
		this.places.add(this.petriNet.addPlace(2));
		this.places.add(this.petriNet.addPlace(3));
		
		this.transitions.add(this.petriNet.addTransition());
		this.transitions.add(this.petriNet.addTransition());
		
	}
	
	@Test
	void testPetriNet() {		
	
		assertEquals(this.emptyPetriNet.getPlaces().size(), 0);
		assertEquals(this.emptyPetriNet.getTransitions().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsTP().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsPT().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsZero().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsDrain().size(), 0);
		
	}

	@Test
	void testAddPlace() throws Exception {
		
		Place p1 = this.emptyPetriNet.addPlace(0);
		this.emptyPlaces.add(p1);
		assertEquals(this.emptyPetriNet.getPlaces().get(0), p1);
		
		Place p2 = this.emptyPetriNet.addPlace(5);
		this.emptyPlaces.add(p2);		
		assertEquals(this.emptyPetriNet.getPlaces().get(1), p2);
		

		Place p3 = this.emptyPetriNet.addPlace(3);
		this.emptyPlaces.add(p3);		
		assertEquals(this.emptyPetriNet.getPlaces().get(2), p3);
		
		assertThrows(NegativeException.class, () -> {
			this.emptyPetriNet.addPlace(-1);
		});
		
		assertEquals(p1.getToken(), 0);
		assertEquals(p2.getToken(), 5);
				
	}

	@Test
	void testAddTransition() {

		Transition t1 = this.emptyPetriNet.addTransition();
		this.emptyTransitions.add(t1);
		assertEquals(this.emptyPetriNet.getTransitions().get(0), t1);
		
		Transition t2 = this.emptyPetriNet.addTransition();
		this.emptyTransitions.add(t2);
		assertEquals(this.emptyPetriNet.getTransitions().get(1), t2);

		assertEquals(t1.getArcsPT().size(), 0);
		assertEquals(t1.getArcsTP().size(), 0);
		
	}

	@Test
	void testAddArcTP() throws Exception {
		
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcTP(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcTP(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcTP(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});

		
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		ArcTP a3 = this.petriNet.addArcTP(2, this.places.get(0), this.transitions.get(1));
	
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcTP(50, this.places.get(0), this.transitions.get(0));
		});
		
		
		assertEquals(this.transitions.get(0).getArcsTP().size(), 2);
		assertEquals(this.transitions.get(1).getArcsTP().size(), 1);
		
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));

		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);
		
		assertEquals(this.places.get(0).getToken(), 1);
		a1.distributeTokens();
		assertEquals(this.places.get(0).getToken(), 1);
		
		assertEquals(this.places.get(0).getToken(), 1);
		a3.distributeTokens();
		assertEquals(this.places.get(0).getToken(), 3);
		
		
	}

	@Test
	void testAddArcPT() throws Exception {
		
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcPT(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcPT(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcPT(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
		
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));
		ArcPT a3 = this.petriNet.addArcPT(2, this.places.get(0), this.transitions.get(1));
	
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcPT(50, this.places.get(0), this.transitions.get(0));
		});
	
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 1);
		
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));

		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);
		

		assertEquals(this.places.get(0).getToken(), 1);
		a1.removeTokens();
		assertEquals(this.places.get(0).getToken(), 1);
		
		assertEquals(this.places.get(1).getToken(), 2);
		a2.removeTokens();
		assertEquals(this.places.get(1).getToken(), 1);
		
		assertEquals(a3.isFireable(), false);
		assertEquals(a2.isFireable(), true);
		
	}

	@Test
	void testAddArcZero() throws Exception {

		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcZero(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcZero(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcZero(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
		
		ArcZero a1 = this.petriNet.addArcZero(1, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		ArcZero a3 = this.petriNet.addArcZero(2, this.places.get(0), this.transitions.get(1));
	
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcZero(50, this.places.get(0), this.transitions.get(0));
		});
		
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 1);
		
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));

		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		
		assertEquals(a1.getWeight(), 1);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);

		assertEquals(a1.isActive(), false);
		assertEquals(a2.isActive(), false);
		assertEquals(a3.isActive(), false);
		
		assertEquals(a1.isFireable(), false);
		assertEquals(a2.isFireable(), false);
		assertEquals(a3.isFireable(), false);
		
		a1.removeTokens();
		assertEquals(a1.isActive(), true);
		assertEquals(a1.isFireable(), false);
		
		Place p = this.petriNet.addPlace(0);
		ArcZero a4 = this.petriNet.addArcZero(0, p, this.transitions.get(1));
		assertEquals(a4.isActive(), true);
		assertEquals(a4.isFireable(), true);
		
		
	}

	@Test
	void testAddArcDrain() throws Exception {
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcDrain(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcDrain(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcDrain(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
		

		Place p = this.petriNet.addPlace(0);
		
		ArcDrain a1 = this.petriNet.addArcDrain(0, this.places.get(0), this.transitions.get(0));
		ArcDrain a2 = this.petriNet.addArcDrain(1, p, this.transitions.get(0));
		ArcDrain a3 = this.petriNet.addArcDrain(3, this.places.get(1), this.transitions.get(1));
		ArcDrain a4 = this.petriNet.addArcDrain(1, p, this.transitions.get(1));
	
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcDrain(50, this.places.get(0), this.transitions.get(0));
		});
		
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 2);
		
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),p);

		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 3);

		assertEquals(a1.isActive(), true);
		assertEquals(a2.isActive(), false);
		assertEquals(a3.isActive(), true);
		assertEquals(a4.isActive(), false);
		
		assertEquals(a1.isFireable(), true);
		assertEquals(a2.isFireable(), false);
		assertEquals(a3.isFireable(), false);
		assertEquals(a4.isFireable(), false);
		
		a1.removeTokens();
		assertEquals(a1.getPlace().getToken(), 0);
		assertEquals(a1.isActive(), false);
		assertEquals(a1.isFireable(), false);
		
		
	}

	@Test
	void testRemovePlace() throws Exception {
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removePlace(null);
		});
		
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removePlace(this.places.get(0));
		});
		
		assertThrows(MissingPlaceException.class, () -> {
			Place p = this.emptyPetriNet.addPlace(2);
			this.petriNet.removePlace(p);
		});
		
		assertEquals(this.petriNet.getPlaces().size(), 3);
		
		this.petriNet.removePlace(this.places.get(1));
		assertEquals(this.petriNet.getPlaces().size(), 2);
		assertEquals(this.petriNet.getPlaces().contains(this.places.get(1)), false);
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.removePlace(this.places.get(1));
		});
		
		this.petriNet.removePlace(this.places.get(2));
		assertEquals(this.petriNet.getPlaces().size(), 1);
		assertEquals(this.petriNet.getPlaces().contains(this.places.get(2)), false);
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.removePlace(this.places.get(2));
		});
	}

	@Test
	void testRemoveArcTP() throws Exception {
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcTP(2, this.places.get(0), this.transitions.get(1));
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcTP(null);
		});
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcTP(a1);			
		});
		
		this.petriNet.removeArcTP(a1);		
		assertEquals(this.petriNet.getArcsTP().size(),2);
		assertEquals(this.petriNet.getArcsTP().contains(a1), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcTP(a1);
		});
		
		this.petriNet.removeArcTP(a2);		
		assertEquals(this.petriNet.getArcsTP().size(),1);
		assertEquals(this.petriNet.getArcsTP().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcTP(a2);
		});
		
		assertEquals(this.transitions.get(0).getArcsTP().contains(a1), false);
		
	}

	@Test
	void testRemoveArcPT() throws Exception {
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcPT(2, this.places.get(0), this.transitions.get(1));
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcPT(null);
		});
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcPT(a1);			
		});
		
		this.petriNet.removeArcPT(a1);		
		assertEquals(this.petriNet.getArcsPT().size(),2);
		assertEquals(this.petriNet.getArcsPT().contains(a1), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcPT(a1);
		});
		
		this.petriNet.removeArcPT(a2);		
		assertEquals(this.petriNet.getArcsPT().size(),1);
		assertEquals(this.petriNet.getArcsPT().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcPT(a2);
		});
		
	}

	@Test
	void testRemoveArcZero() throws Exception {
		ArcZero a1 = this.petriNet.addArcZero(0, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcZero(2, this.places.get(0), this.transitions.get(1));
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcZero(null);
		});
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcZero(a1);			
		});
		
		this.petriNet.removeArcZero(a1);		
		assertEquals(this.petriNet.getArcsZero().size(),2);
		assertEquals(this.petriNet.getArcsZero().contains(a1), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcZero(a1);
		});
		
		this.petriNet.removeArcZero(a2);		
		assertEquals(this.petriNet.getArcsZero().size(),1);
		assertEquals(this.petriNet.getArcsZero().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcZero(a2);
		});
		
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
	}

	@Test
	void testRemoveArcDrain() throws Exception {
		ArcDrain a1 = this.petriNet.addArcDrain(0, this.places.get(0), this.transitions.get(0));
		ArcDrain a2 = this.petriNet.addArcDrain(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcDrain(2, this.places.get(0), this.transitions.get(1));
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcDrain(null);
		});
		
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcDrain(a1);			
		});
		
		this.petriNet.removeArcDrain(a1);		
		assertEquals(this.petriNet.getArcsDrain().size(),2);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcDrain(a1);
		});
		
		this.petriNet.removeArcDrain(a2);		
		assertEquals(this.petriNet.getArcsDrain().size(),1);
		assertEquals(this.petriNet.getArcsDrain().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcDrain(a2);
		});
		
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
	}

	@Test
	void testRemoveTransition() throws Exception {
		
		assertThrows(MissingTransitionException.class, () -> {
			this.emptyPetriNet.removeTransition(null);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.emptyPetriNet.removeTransition(this.transitions.get(0));
		});
		
		assertEquals(this.petriNet.getTransitions().size(), 2);
		
		this.petriNet.removeTransition(this.transitions.get(1));
		assertEquals(this.petriNet.getTransitions().size(), 1);
		assertEquals(this.petriNet.getTransitions().contains(this.transitions.get(1)), false);
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.removeTransition(this.transitions.get(1));
		});
		
		this.petriNet.removeTransition(this.transitions.get(0));
		assertEquals(this.petriNet.getTransitions().size(), 0);
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.removeTransition(this.transitions.get(0));
		});
		
		
	}

	@Test
	void testGetPlaces() throws Exception {

		assertEquals(this.emptyPetriNet.getPlaces().size(),0);
		assertEquals(this.petriNet.getPlaces().size(),3);

		Place p = this.emptyPetriNet.addPlace(0);
		assertEquals(this.emptyPetriNet.getPlaces().size(), 1);
		assertEquals(this.emptyPetriNet.getPlaces().contains(p), true);
		
		this.emptyPetriNet.removePlace(p);
		assertEquals(this.emptyPetriNet.getPlaces().size(), 0);
		assertEquals(this.emptyPetriNet.getPlaces().contains(p), false);
		
	}

	@Test
	void testGetArcsTP() throws Exception {

		assertEquals(this.petriNet.getArcsTP().size(), 0);
		
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		
		assertEquals(this.petriNet.getArcsTP().size(), 2);
		assertEquals(this.petriNet.getArcsTP().contains(a1), true);
		assertEquals(this.petriNet.getArcsTP().contains(a2), true);
		
		this.petriNet.removeArcTP(a1);
		assertEquals(this.petriNet.getArcsTP().size(), 1);
		assertEquals(this.petriNet.getArcsTP().contains(a1), false);
		
	}

	@Test
	void testGetArcsPT() throws Exception {

		assertEquals(this.petriNet.getArcsPT().size(), 0);
		
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));
		
		assertEquals(this.petriNet.getArcsPT().size(), 2);
		assertEquals(this.petriNet.getArcsPT().contains(a1), true);
		assertEquals(this.petriNet.getArcsPT().contains(a2), true);
		
		this.petriNet.removeArcPT(a1);
		assertEquals(this.petriNet.getArcsPT().size(), 1);
		assertEquals(this.petriNet.getArcsPT().contains(a1), false);
		
	}

	@Test
	void testGetArcsZero() throws Exception {
		
		assertEquals(this.petriNet.getArcsZero().size(), 0);
		
		ArcZero a1 = this.petriNet.addArcZero(0, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		
		assertEquals(this.petriNet.getArcsZero().size(), 2);
		assertEquals(this.petriNet.getArcsZero().contains(a1), true);
		assertEquals(this.petriNet.getArcsZero().contains(a2), true);
		
		this.petriNet.removeArcZero(a1);
		assertEquals(this.petriNet.getArcsZero().size(), 1);
		assertEquals(this.petriNet.getArcsZero().contains(a1), false);
		
	}

	@Test
	void testGetArcsDrain() throws Exception {

		assertEquals(this.petriNet.getArcsDrain().size(), 0);
		
		ArcDrain a1 = this.petriNet.addArcDrain(0, this.places.get(0), this.transitions.get(0));
		ArcDrain a2 = this.petriNet.addArcDrain(1, this.places.get(1), this.transitions.get(0));
		
		assertEquals(this.petriNet.getArcsDrain().size(), 2);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), true);
		assertEquals(this.petriNet.getArcsDrain().contains(a2), true);
		
		this.petriNet.removeArcDrain(a1);
		assertEquals(this.petriNet.getArcsDrain().size(), 1);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), false);
		
	}

	@Test
	void testGetTransitions() throws Exception {

		assertEquals(this.emptyPetriNet.getTransitions().size(),0);
		assertEquals(this.petriNet.getTransitions().size(),2);

		Transition t = this.emptyPetriNet.addTransition();
		assertEquals(this.emptyPetriNet.getTransitions().size(), 1);
		assertEquals(this.emptyPetriNet.getTransitions().contains(t), true);
		
		this.emptyPetriNet.removeTransition(t);
		assertEquals(this.emptyPetriNet.getTransitions().size(), 0);
		assertEquals(this.emptyPetriNet.getTransitions().contains(t), false);
		
	}

}
