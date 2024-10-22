package classes;

import Exceptions.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetriNetTest {
	
	private PetriNet emptyPetriNet;
	private PetriNet petriNet;
	
	@BeforeEach
	void setup() {
		this.emptyPetriNet = new PetriNet();
		
		this.petriNet = new PetriNet();
		
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
		
		assertEquals(this.petriNet.getPlaces().get(0), p1);
		
		Place p2 = this.petriNet.addPlace(5);
		
		assertEquals(this.petriNet.getPlaces().get(1), p2);
		
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addPlace(-1);
		});
		
		assertEquals(p1.getToken(), 0);
		assertEquals(p2.getToken(), 5);
				
	}

	@Test
	void testAddArcTP() {
		fail("Not yet implemented");
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
	void testAddTransition() {
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
