package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import arcs.*;
import exceptions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetriNetTest {
	
	private PetriNet emptyPetriNet;
	private PetriNet petriNet;
	private ArrayList<Transition> transitions;
	private ArrayList<Place> places;
	
	
	@BeforeEach
	void setup() {
		this.emptyPetriNet = new PetriNet();
		
		this.petriNet = new PetriNet();
		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();	
		
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
		
		Place p1 = this.petriNet.addPlace(0);
		this.places.add(p1);
		assertEquals(this.petriNet.getPlaces().get(0), p1);
		
		Place p2 = this.petriNet.addPlace(5);
		this.places.add(p2);		
		assertEquals(this.petriNet.getPlaces().get(1), p2);
		

		Place p3 = this.petriNet.addPlace(3);
		this.places.add(p3);		
		assertEquals(this.petriNet.getPlaces().get(1), p3);
		
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addPlace(-1);
		});
		
		assertEquals(p1.getToken(), 0);
		assertEquals(p2.getToken(), 5);
				
	}

	@Test
	void testAddTransition() {

		Transition t1 = this.petriNet.addTransition();
		this.transitions.add(t1);
		assertEquals(this.petriNet.getTransitions().get(0), t1);
		
		Transition t2 = this.petriNet.addTransition();
		this.transitions.add(t2);
		assertEquals(this.petriNet.getTransitions().get(1), t2);

		assertEquals(t1.getArcsPT().size(), 0);
		assertEquals(t1.getArcsTP().size(), 0);
		
	}

	@Test
	void testAddArcTP() {
		
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcTP(-5,
					this.places.get(0),
					this.transitions.get(0)
				);
		});

		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcTP(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcTP(-5,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
	}

	@Test
	void testAddArcPT() {
		fail("Not yet implemented");
	}

	@Test
	void testAddArcZero() {
		fail("Not yet implemented");
	}

	@Test
	void testAddArcDrain() {
		fail("Not yet implemented");
	}

	@Test
	void testRemovePlace() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveArcTP() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveArcPT() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveArcZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveArcDrain() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveTransition() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlaces() {
		fail("Not yet implemented");
	}

	@Test
	void testGetArcsTP() {
		fail("Not yet implemented");
	}

	@Test
	void testGetArcsPT() {
		fail("Not yet implemented");
	}

	@Test
	void testGetArcsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testGetArcsDrain() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTransitions() {
		fail("Not yet implemented");
	}

}
