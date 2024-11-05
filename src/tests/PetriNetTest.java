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
	
	/**
	 * Creates a set of variables to be used in tests later on
	 */
	@BeforeEach
	void setup() throws Exception {
		// Creates an empty PetriNet
		this.emptyPetriNet = new PetriNet();
		this.emptyTransitions = new ArrayList<Transition>();
		this.emptyPlaces = new ArrayList<Place>();
		
		// Creates a PetriNet with 3 places and 2 transitions
		this.petriNet = new PetriNet();
		this.transitions = new ArrayList<Transition>();
		this.places = new ArrayList<Place>();	

		this.places.add(this.petriNet.addPlace(1));
		this.places.add(this.petriNet.addPlace(2));
		this.places.add(this.petriNet.addPlace(3));
		
		this.transitions.add(this.petriNet.addTransition());
		this.transitions.add(this.petriNet.addTransition());
		
	}
	
	/**
	 * Checks that constructor creates an empty PetriNet
	 * @result PetriNet created without any errors,
	 * 		   with no places, no transitions and no arcs 
	 */
	@Test
	void testPetriNet() {		
	
		assertEquals(this.emptyPetriNet.getPlaces().size(), 0);
		assertEquals(this.emptyPetriNet.getTransitions().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsTP().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsPT().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsZero().size(), 0);
		assertEquals(this.emptyPetriNet.getArcsDrain().size(), 0);
		
	}

	/**
	 * Checks that addPlace() methods creates a Place and puts it in the PetriNet
	 * 
	 * @result Place created without any error and with proper amount of tokens,
	 * 		   added to the PetriNet and() method returns the Place created.   
	 *		   Raises NegativeException when user tries to create a Place with negative
	 *	       amount of tokens.
	 */
	@Test
	void testAddPlace() throws Exception {
		
		// Checks that places are added to the PetriNet
		Place p1 = this.emptyPetriNet.addPlace(0);
		this.emptyPlaces.add(p1);
		assertEquals(this.emptyPetriNet.getPlaces().get(0), p1);
		
		Place p2 = this.emptyPetriNet.addPlace(5);
		this.emptyPlaces.add(p2);		
		assertEquals(this.emptyPetriNet.getPlaces().get(1), p2);
		
		Place p3 = this.emptyPetriNet.addPlace(3);
		this.emptyPlaces.add(p3);		
		assertEquals(this.emptyPetriNet.getPlaces().get(2), p3);
		
		// Checks that no negative number can be put as parameter
		assertThrows(NegativeException.class, () -> {
			this.emptyPetriNet.addPlace(-1);
		});
		
		// Checks that the amount of token of the places are the same that were in() method parameter
		assertEquals(p1.getTokens(), 0);
		assertEquals(p2.getTokens(), 5);
				
	}

	/**
	 * Checks that addTransition() methods creates a Transition and puts it in the PetriNet
	 * 
	 * @result Transition created without any error and added to the PetriNet.
	 *         addTransition() method returns the Transition created.   
	 */
	@Test
	void testAddTransition() {

		// Checks that Transitions are added to the PetriNet
		Transition t1 = this.emptyPetriNet.addTransition();
		this.emptyTransitions.add(t1);
		assertEquals(this.emptyPetriNet.getTransitions().get(0), t1);
		
		Transition t2 = this.emptyPetriNet.addTransition();
		this.emptyTransitions.add(t2);
		assertEquals(this.emptyPetriNet.getTransitions().get(1), t2);

		// Checks that the Transition created has no Arc linked to it
		assertEquals(t1.getArcsPT().size(), 0);
		assertEquals(t1.getArcsTP().size(), 0);
		
	}

	/**
	 * Checks that addTokens() method adds the correct amount of tokent to a Place recorded in the PetriNet
	 * 
	 * @throws Exception
	 * @result Adds tokens to a Place without error
	 * 		   Amount of Token must be positive
	 * 		   Place must belong to the PetriNet
	 */
	@Test
	void testAddTokens() throws Exception {
	
		// Test CAT0
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addTokens(this.places.get(0), -10);
		});
		
		// Test CAT1
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.addTokens(null, 0);
		});
		
		// Test CAT2
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.addTokens(this.places.get(0), 0);
		});
		
		// Test CAT3
		this.petriNet.addTokens(this.places.get(0), 10);
		assertEquals(this.places.get(0).getTokens(), 11);
		
	}
	
	/**
	 * Checks that removeTokens() method removes the correct amount of tokent to a Place recorded in the PetriNet
	 * 
	 * @throws Exception
	 * @result Removes tokens to a Place without error
	 * 		   Amount of token must be positive
	 * 		   Place must belong to the PetriNet
	 * 		   Final value of tokens must be positive
	 */
	@Test
	void testRemoveTokens() throws Exception {
		// Test CRT0
		assertThrows(NegativeException.class, () -> {
			this.petriNet.removeTokens(this.places.get(0), -10);
		});
		
		// Test CRT1
		assertThrows(NegativeException.class, () -> {
			this.petriNet.removeTokens(this.places.get(0), 10);
		});
		
		// Test CRT2
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removeTokens(this.places.get(0), 0);
		});
		
		// Test CRT3
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removeTokens(null, 0);
		});
		
		// Test CRT4
		this.petriNet.removeTokens(this.places.get(2), 1);
		assertEquals(this.places.get(2).getTokens(), 2);
		
	}
	
	/**
	 * Checks that addArcTP() method creates an arcTP and adds it to the PetriNet
	 * 
	 * @throws Exception
	 * @results An ArcTP is added to the PetriNet without error
	 * 		    The ArcTP is linked to an already existing Place and Transition in the PetriNet
	 * 		    Two ArcTP cannot link a Place and a Transition
	 * 			No negative weight
	 */			
	@Test
	void testAddArcTP() throws Exception {
		
		// Test CAATP0
		// No ArcTP can be created with a negative weight
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcTP(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		// Test CAATP1
		// Creating an ArcTP requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcTP(10,
					this.emptyPetriNet.addPlace(0),
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAATP2
		// Creating an ArcTP requires a non null Place 
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcTP(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAATP3
		// Creating an ArcTP requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcTP(0,
					this.petriNet.getPlaces().get(0),
					this.emptyPetriNet.addTransition()
				);
		});
		
		// Test CAATP4
		// Creating an ArcTP requires a non null Transition
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcTP(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
 
		
		// Test CAATP5 - 3 test instances
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		ArcTP a3 = this.petriNet.addArcTP(2, this.places.get(0), this.transitions.get(1));
	
		// Checks that added ArcTP are recorded in the PetriNet
		assertEquals(this.petriNet.getArcsTP().contains(a1), true);
		assertEquals(this.petriNet.getArcsTP().contains(a2), true);
		assertEquals(this.petriNet.getArcsTP().contains(a3), true);
		
		// Checks that ArcTP are linked to the correct Place
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));
		
		// Checks that ArcTP are linked to the correct Transition
		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		assertEquals(this.transitions.get(0).getArcsTP().size(), 2);
		assertEquals(this.transitions.get(1).getArcsTP().size(), 1);
		
		// Checks that ArcTP has the correct weight
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);
		// End Test CAATP5
		
		// Checks that the added ArcTP can distribute tokens to its arriving Place
		assertEquals(this.places.get(0).getTokens(), 1);
		a1.distributeTokens();
		assertEquals(this.places.get(0).getTokens(), 1);
		
		assertEquals(this.places.get(0).getTokens(), 1);
		a3.distributeTokens();
		assertEquals(this.places.get(0).getTokens(), 3);

		// Test CADTP0
		// Two ArcTP can't be linked to the same Place and Transition
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcTP(50, this.places.get(0), this.transitions.get(0));
		});
		
		
	}

	/**
	 * Checks that addArcPT() method creates an arcPT and adds it to the PetriNet
	 * 
	 * @throws Exception
	 * @results An ArcPT is added to the PetriNet without error
	 * 		    The ArcPT is linked to an already existing Place and Transition in the PetriNet
	 * 		    Two ArcPT cannot link a Place and a Transition
	 * 			No negative weight
	 */	
	@Test
	void testAddArcPT() throws Exception {
		
		// Test CAAPT0
		// No ArcPT can be created with a negative weight
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcPT(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		// Test CAAPT1
		// Creating an ArcPT requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcPT(10,
					this.emptyPetriNet.addPlace(0),
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAAPT2
		// Creating an ArcPT requires a non null Place
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcPT(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAAPT3
		// Creating an ArcPT requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcPT(0,
					this.petriNet.getPlaces().get(0),
					this.emptyPetriNet.addTransition()
				);
		});

		// Test CAAPT4
		// Creating an ArcPT requires a non null Transition
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcPT(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
		
		// Test CAAPT5 - 3 test instances
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));
		ArcPT a3 = this.petriNet.addArcPT(2, this.places.get(0), this.transitions.get(1));
	
		
		// Checks that ArcPT is added to PetiNet
		assertEquals(this.petriNet.getArcsPT().contains(a1), true);
		assertEquals(this.petriNet.getArcsPT().contains(a2), true);
		assertEquals(this.petriNet.getArcsPT().contains(a3), true);
		
		// Checks that ArcTP is linked to correct Place
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));

		// Checks that ArcPT is linked to correct Transition
		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 1);
		
		// Checks that ArcTP has correct weight
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);
		
		// Checks if ArcTP is fireable
		assertEquals(a1.isFireable(), true);
		assertEquals(a2.isFireable(), true);
		assertEquals(a3.isFireable(), false);
		
		// End Test CAAPT5
		
		// Checks that the added ArcTP can remove token to its starting Place
		assertEquals(this.places.get(0).getTokens(), 1);
		a1.removeTokens();
		assertEquals(this.places.get(0).getTokens(), 1);
		
		assertEquals(this.places.get(1).getTokens(), 2);
		a2.removeTokens();
		assertEquals(this.places.get(1).getTokens(), 1);
		
		// Update after removal of tokens
		assertEquals(a3.isFireable(), false);
		assertEquals(a2.isFireable(), true);
		
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		// Test CADPT0
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcPT(50, this.places.get(0), this.transitions.get(0));
		});

		// Test CADPT1
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcDrain(50, this.places.get(0), this.transitions.get(0));
		});
				
		// Test CADPT2
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcZero(50, this.places.get(0), this.transitions.get(0));
		});
		
	}

	/**
	 * Checks that addArcZero() method creates an arcZero and adds it to the PetriNet
	 * 
	 * @throws Exception
	 * @results An ArcZero is added to the PetriNet without error
	 * 		    The ArcZero is linked to an already existing Place and Transition in the PetriNet
	 * 		    Two ArcTP (subclass as well) cannot link a Place and a Transition
	 * 			No negative weight
	 */	
	@Test
	void testAddArcZero() throws Exception {

		// No ArcZero can be created with a negative weight
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcZero(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		// Creating an ArcZero requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcZero(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Creating an ArcZero requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.addArcZero(0,
					this.petriNet.getPlaces().get(0),
					null
				);
		});
		
		ArcZero a1 = this.petriNet.addArcZero(1, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		ArcZero a3 = this.petriNet.addArcZero(2, this.places.get(0), this.transitions.get(1));
	
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcZero(50, this.places.get(0), this.transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcPT(50, this.places.get(0), this.transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcDrain(50, this.places.get(0), this.transitions.get(0));
		});
		
		// Checks that ArcZero is added to PetiNet
		assertEquals(this.petriNet.getArcsZero().contains(a1), true);
		assertEquals(this.petriNet.getArcsZero().contains(a2), true);
		assertEquals(this.petriNet.getArcsZero().contains(a3), true);
		
		// Checks that ArcZero is linked to correct Place
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),this.places.get(1));

		// Checks that ArcZero is linked to correct Transition
		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 1);
		
		// Checks that ArcTP has correct weight
		assertEquals(a1.getWeight(), 1);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);

		Place p = this.petriNet.addPlace(0);
		ArcZero a4 = this.petriNet.addArcZero(0, p, this.transitions.get(1));
		
		// Checks if ArcTP is active and fireable
		assertEquals(a1.isActive(), false);
		assertEquals(a2.isActive(), false);
		assertEquals(a3.isActive(), false);
		assertEquals(a4.isActive(), true);
		
		assertEquals(a1.isFireable(), false);
		assertEquals(a2.isFireable(), false);
		assertEquals(a3.isFireable(), false);
		assertEquals(a4.isFireable(), true);
		
		// Update after removal of token
		a1.removeTokens();
		assertEquals(a1.isActive(), true);
		assertEquals(a1.isFireable(), false);
		
		
		
	}

	/**
	 * Checks that addArcDrain() method creates an arcZero and adds it to the PetriNet
	 * 
	 * @throws Exception
	 * @results An ArcDrain is added to the PetriNet without error
	 * 		    The ArcDrain is linked to an already existing Place and Transition in the PetriNet
	 * 		    Two ArcTP (subclass as well) cannot link a Place and a Transition
	 * 			No negative weight
	 */	
	@Test
	void testAddArcDrain() throws Exception {
		
		// No ArcDrain can be created with a negative weight
		assertThrows(NegativeException.class, () -> {
			this.petriNet.addArcDrain(-5,
					this.petriNet.getPlaces().get(0),
					this.petriNet.getTransitions().get(0)
				);
		});

		// Creating an ArcDrain requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.addArcDrain(10,
					null,
					this.petriNet.getTransitions().get(0)
				);
		});
		
		// Creating an ArcDrain requires an existing Place in the PetriNet
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
	
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcDrain(50, this.places.get(0), this.transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcPT(50, this.places.get(0), this.transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			this.petriNet.addArcZero(50, this.places.get(0), this.transitions.get(0));
		});
		
		// Checks that ArcDrain is recorded in PetriNet
		assertEquals(this.petriNet.getArcsDrain().contains(a1), true);
		assertEquals(this.petriNet.getArcsDrain().contains(a2), true);
		assertEquals(this.petriNet.getArcsDrain().contains(a3), true);
		
		// Checks that ArcDrain is linked to correct Place
		assertEquals(a1.getPlace(),this.places.get(0));
		assertEquals(a2.getPlace(),p);

		// Checks that ArcDrain is linked to correct Transition
		assertEquals(a2.getTransition(),this.transitions.get(0));
		assertEquals(a3.getTransition(),this.transitions.get(1));
		assertEquals(this.transitions.get(0).getArcsPT().size(), 2);
		assertEquals(this.transitions.get(1).getArcsPT().size(), 2);
		
		// Checks that ArcDrain has the correct weight		
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 3);

		// Checks if ArcDrain is active and fireable
		assertEquals(a1.isActive(), true);
		assertEquals(a2.isActive(), false);
		assertEquals(a3.isActive(), true);
		assertEquals(a4.isActive(), false);
		
		assertEquals(a1.isFireable(), true);
		assertEquals(a2.isFireable(), false);
		assertEquals(a3.isFireable(), false);
		assertEquals(a4.isFireable(), false);
		
		// Update after token removal
		a1.removeTokens();
		assertEquals(a1.getPlace().getTokens(), 0);
		assertEquals(a1.isActive(), false);
		assertEquals(a1.isFireable(), false);
		
		
	}

	/**
	 * Checks that removePlace() method removes a Place from a PetriNet
	 * 
	 * @throws Exception
	 * @result removePlace() removes a Place from a PetriNet without errors. 
	 * 		   All arcs linked to the Place are removed as well.
	 */
	@Test
	void testRemovePlace() throws Exception {
		
		// Null not allowed in PetriNet and thus cannot be removed
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removePlace(null);
		});
		
		// Cannot remove Place in an empty PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			this.emptyPetriNet.removePlace(this.places.get(0));
		});
		
		// Cannot remove Place not in PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			Place p = this.emptyPetriNet.addPlace(2);
			this.petriNet.removePlace(p);
		});
		
		assertEquals(this.petriNet.getPlaces().size(), 3);
		
		// Removes a Place
		this.petriNet.removePlace(this.places.get(1));
		assertEquals(this.petriNet.getPlaces().size(), 2);
		assertEquals(this.petriNet.getPlaces().contains(this.places.get(1)), false);
		// Can't remove it again
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.removePlace(this.places.get(1));
		});
		
		// Removes another Place
		this.petriNet.removePlace(this.places.get(2));
		assertEquals(this.petriNet.getPlaces().size(), 1);
		assertEquals(this.petriNet.getPlaces().contains(this.places.get(2)), false);
		// Can't remove it again
		assertThrows(MissingPlaceException.class, () -> {
			this.petriNet.removePlace(this.places.get(2));
		});
	}

	/**
	 * Checks that removeArcTP() method removes an ArcTP from a PetriNet
	 * 
	 * @throws Exception
	 * @result removeArcTP() removes an ArcTP from a PetriNet without error
	 * 		   The ArcTP is no longer recorded in its linked Transition
	 */
	@Test
	void testRemoveArcTP() throws Exception {
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcTP(2, this.places.get(0), this.transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcTP(null);
		});
		
		// Cannot remove ArcTP from a PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcTP(a1);			
		});
		
		// Checks that ArcTP is no longer recorded in PetriNet
		this.petriNet.removeArcTP(a1);		
		assertEquals(this.petriNet.getArcsTP().size(),2);
		assertEquals(this.petriNet.getArcsTP().contains(a1), false);
		
		// Checks that ArcTP is no longer recorded in its Transition
		assertEquals(this.transitions.get(0).getArcsTP().contains(a1), false);
		
		// Checks that ArcTP can not be removed again
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcTP(a1);
		});
		
		// Same test for another ArcTP
		this.petriNet.removeArcTP(a2);		
		assertEquals(this.petriNet.getArcsTP().size(),1);
		assertEquals(this.petriNet.getArcsTP().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcTP(a2);
		});
		assertEquals(this.transitions.get(0).getArcsTP().contains(a2), false);
		
	}

	/**
	 * Checks that removeArcPT() method removes an ArcPT from a PetriNet
	 * 
	 * @throws Exception
	 * @result removeArcPT() removes an ArcPT from a PetriNet without error
	 * 		   The ArcPT is no longer recorded in its linked Transition
	 */
	@Test
	void testRemoveArcPT() throws Exception {
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcPT(2, this.places.get(0), this.transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcPT(null);
		});
		
		// Cannot remove ArcPT from PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcPT(a1);			
		});

		this.petriNet.removeArcPT(a1);		

		// Checks that ArcPT is no longer recorded in PetriNet
		assertEquals(this.petriNet.getArcsPT().size(),2);
		assertEquals(this.petriNet.getArcsPT().contains(a1), false);
		
		// Checks that ArcPT is no longer linked to its Transition
		assertEquals(this.transitions.get(0).getArcsPT().contains(a1), false);
		
		// Cannot remove this ArcPT again
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcPT(a1);
		});
		
		// Same tests for another ArcPT
		this.petriNet.removeArcPT(a2);		
		assertEquals(this.petriNet.getArcsPT().size(),1);
		assertEquals(this.petriNet.getArcsPT().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcPT(a2);
		});
		assertEquals(this.transitions.get(0).getArcsPT().contains(a2), false);

	}

	/**
	 * Checks that removeArcZero() method removes an ArcZero from a PetriNet
	 * 
	 * @throws Exception
	 * @result removeArcZero() removes an ArcZero from a PetriNet without error
	 * 		   The ArcZero is no longer recorded in its linked Transition
	 */
	@Test
	void testRemoveArcZero() throws Exception {
		ArcZero a1 = this.petriNet.addArcZero(0, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcZero(2, this.places.get(0), this.transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcZero(null);
		});
		
		// Cannot remove an ArcZero from a PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcZero(a1);			
		});
		
		this.petriNet.removeArcZero(a1);		
		
		// Checks that ArcZero is no longer recorded in PetriNet
		assertEquals(this.petriNet.getArcsZero().size(),2);
		assertEquals(this.petriNet.getArcsZero().contains(a1), false);
		
		// ArcZero is no longer linked to its Transition
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
		
		// ArcZero cannot be removed again
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcZero(a1);
		});
		
		// Same tests for another ArcZero
		this.petriNet.removeArcZero(a2);		
		assertEquals(this.petriNet.getArcsZero().size(),1);
		assertEquals(this.petriNet.getArcsZero().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcZero(a2);
		});
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a2), false);
	
	}

	/**
	 * Checks that removeArcDrain() method removes an ArcDrain from a PetriNet
	 * 
	 * @throws Exception
	 * @result removeArcDrain() removes an ArcDrain from a PetriNet without error
	 * 		   The ArcDrain is no longer recorded in its linked Transition
	 */
	@Test
	void testRemoveArcDrain() throws Exception {
		ArcDrain a1 = this.petriNet.addArcDrain(0, this.places.get(0), this.transitions.get(0));
		ArcDrain a2 = this.petriNet.addArcDrain(1, this.places.get(1), this.transitions.get(0));
		this.petriNet.addArcDrain(2, this.places.get(0), this.transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcDrain(null);
		});
		
		// Cannot remove ArcDrain which is not recorded in PetriNet
		assertThrows(MissingArcException.class, () -> {
			this.emptyPetriNet.removeArcDrain(a1);			
		});
		
		this.petriNet.removeArcDrain(a1);		
		
		// Checks that ArcDrain is no longer recorded in PetriNet 
		assertEquals(this.petriNet.getArcsDrain().size(),2);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), false);
		
		// Checks that ArcDrain is no longer linked to its Transition
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
		
		// Cannot remove this ArcDrain again
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcDrain(a1);
		});
		
		// Same tests for another ArcDrain
		this.petriNet.removeArcDrain(a2);		
		assertEquals(this.petriNet.getArcsDrain().size(),1);
		assertEquals(this.petriNet.getArcsDrain().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			this.petriNet.removeArcDrain(a2);
		});
		assertEquals(this.transitions.get(0).getArcsPT().contains((ArcPT) a2), false);
	}

	/**
	 * Checks that removeTransition() method removes a Transition from a PetriNet
	 * 
	 * @throws Exception
	 * @result removePlace() removes a Transition from a PetriNet without errors. 
	 * 		   All arcs linked to the Transition are removed as well.
	 */
	@Test
	void testRemoveTransition() throws Exception {
		
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcTP a3 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(1));
		ArcPT a4 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingTransitionException.class, () -> {
			this.emptyPetriNet.removeTransition(null);
		});
		
		// Cannot remove Transition which is not part of the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			this.emptyPetriNet.removeTransition(this.transitions.get(0));
		});
		
		
		this.petriNet.removeTransition(this.transitions.get(1));
		
		// Checks that related Arcs are removed
		assertEquals(this.petriNet.getArcsTP().size(), 1);
		assertEquals(this.petriNet.getArcsTP().contains(a3), false);
		assertEquals(this.petriNet.getArcsPT().size(), 1);
		assertEquals(this.petriNet.getArcsPT().contains(a4), false);
		
		// Checks that Transition is removed from PetriNet
		assertEquals(this.petriNet.getTransitions().size(), 1);
		assertEquals(this.petriNet.getTransitions().contains(this.transitions.get(1)), false);
		// Cannot remove it again from same PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.removeTransition(this.transitions.get(1));
		});
		
		// Same tests with another Transition
		this.petriNet.removeTransition(this.transitions.get(0));
		assertEquals(this.petriNet.getArcsTP().size(), 0);
		assertEquals(this.petriNet.getArcsTP().contains(a1), false);
		assertEquals(this.petriNet.getArcsPT().size(), 0);
		assertEquals(this.petriNet.getArcsPT().contains(a2), false);
		assertEquals(this.petriNet.getTransitions().size(), 0);
		assertThrows(MissingTransitionException.class, () -> {
			this.petriNet.removeTransition(this.transitions.get(0));
		});
		
		
	}

	/**
	 * Checks that getPlaces() method returns accurately all places 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getPlaces() returns accurately all places without error
	 */
	@Test
	void testGetPlaces() throws Exception {

		// Checks for base set of PetriNet
		assertEquals(this.emptyPetriNet.getPlaces().size(),0);
		assertEquals(this.petriNet.getPlaces().size(),3);

		// Checks after adding a Place
		Place p = this.emptyPetriNet.addPlace(0);
		assertEquals(this.emptyPetriNet.getPlaces().size(), 1);
		assertEquals(this.emptyPetriNet.getPlaces().contains(p), true);
		
		// Checks after removing a Place
		this.emptyPetriNet.removePlace(p);
		assertEquals(this.emptyPetriNet.getPlaces().size(), 0);
		assertEquals(this.emptyPetriNet.getPlaces().contains(p), false);
		
	}

	/**
	 * Checks that getArcsTP() method returns accurately all ArcTP 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getArcsTP() returns accurately all ArcTP without error
	 */
	@Test
	void testGetArcsTP() throws Exception {

		// Checks for PetriNet without arcs
		assertEquals(this.petriNet.getArcsTP().size(), 0);
		
		ArcTP a1 = this.petriNet.addArcTP(0, this.places.get(0), this.transitions.get(0));
		ArcTP a2 = this.petriNet.addArcTP(1, this.places.get(1), this.transitions.get(0));
		
		// Checks after adding ArcTP
		assertEquals(this.petriNet.getArcsTP().size(), 2);
		assertEquals(this.petriNet.getArcsTP().contains(a1), true);
		assertEquals(this.petriNet.getArcsTP().contains(a2), true);
		
		// Checks after removing ArcTP
		this.petriNet.removeArcTP(a1);
		assertEquals(this.petriNet.getArcsTP().size(), 1);
		assertEquals(this.petriNet.getArcsTP().contains(a1), false);
		
	}

	/**
	 * Checks that getArcsPT() method returns accurately all ArcPT 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getArcsPT() returns accurately all ArcPT without error
	 */
	@Test
	void testGetArcsPT() throws Exception {

		// Checks for PetriNet without arcs 
		assertEquals(this.petriNet.getArcsPT().size(), 0);
		
		ArcPT a1 = this.petriNet.addArcPT(0, this.places.get(0), this.transitions.get(0));
		ArcPT a2 = this.petriNet.addArcPT(1, this.places.get(1), this.transitions.get(0));

		// Checks after adding ArcPT
		assertEquals(this.petriNet.getArcsPT().size(), 2);
		assertEquals(this.petriNet.getArcsPT().contains(a1), true);
		assertEquals(this.petriNet.getArcsPT().contains(a2), true);
		
		// Checks after adding ArcPT
		this.petriNet.removeArcPT(a1);
		assertEquals(this.petriNet.getArcsPT().size(), 1);
		assertEquals(this.petriNet.getArcsPT().contains(a1), false);
		
	}

	/**
	 * Checks that getArcsZero() method returns accurately all ArcZero 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getArcsZero() returns accurately all ArcZero without error
	 */
	@Test
	void testGetArcsZero() throws Exception {
		
		// Checks for PetriNet without arcs 
		assertEquals(this.petriNet.getArcsZero().size(), 0);
		
		// Checks after adding ArcZero
		ArcZero a1 = this.petriNet.addArcZero(0, this.places.get(0), this.transitions.get(0));
		ArcZero a2 = this.petriNet.addArcZero(1, this.places.get(1), this.transitions.get(0));
		
		assertEquals(this.petriNet.getArcsZero().size(), 2);
		assertEquals(this.petriNet.getArcsZero().contains(a1), true);
		assertEquals(this.petriNet.getArcsZero().contains(a2), true);
		
		
		// Checks after removal of ArcZero
		this.petriNet.removeArcZero(a1);
		assertEquals(this.petriNet.getArcsZero().size(), 1);
		assertEquals(this.petriNet.getArcsZero().contains(a1), false);
		
	}

	/**
	 * Checks that getArcsDrain() method returns accurately all ArcDrain 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getArcsDrain() returns accurately all ArcDrain without error
	 */
	@Test
	void testGetArcsDrain() throws Exception {

		// Checks for base set of PetriNet
		assertEquals(this.petriNet.getArcsDrain().size(), 0);
		
		// Checks after adding ArcDrain
		ArcDrain a1 = this.petriNet.addArcDrain(0, this.places.get(0), this.transitions.get(0));
		ArcDrain a2 = this.petriNet.addArcDrain(1, this.places.get(1), this.transitions.get(0));
		assertEquals(this.petriNet.getArcsDrain().size(), 2);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), true);
		assertEquals(this.petriNet.getArcsDrain().contains(a2), true);
		
		// Checks after removing ArcDrain
		this.petriNet.removeArcDrain(a1);
		assertEquals(this.petriNet.getArcsDrain().size(), 1);
		assertEquals(this.petriNet.getArcsDrain().contains(a1), false);
		
	}

	/**
	 * Checks that getTransition() method returns accurately all transitions 
	 * of the PetriNet
	 * 
	 * @throws Exception
	 * @result getTransition() returns accurately all transitions without error
	 */
	@Test
	void testGetTransitions() throws Exception {

		// Checks for base set of PetriNet 
		assertEquals(this.emptyPetriNet.getTransitions().size(),0);
		assertEquals(this.petriNet.getTransitions().size(),2);

		// Checks after adding a transition
		Transition t = this.emptyPetriNet.addTransition();
		assertEquals(this.emptyPetriNet.getTransitions().size(), 1);
		assertEquals(this.emptyPetriNet.getTransitions().contains(t), true);
		
		// Checks after removing a transition
		this.emptyPetriNet.removeTransition(t);
		assertEquals(this.emptyPetriNet.getTransitions().size(), 0);
		assertEquals(this.emptyPetriNet.getTransitions().contains(t), false);
		
	}
	
	/**
	 * Checks that testFireTransition() method fires transition accordingly.
	 * 
	 * @throws Exception
	 * @result Transition is fired when all ArcsPT are fireable.
	 * 		   Incoming Places have less tokens.
	 * 		   Receiving Places have more tokens.
	 * 		   If a Transition is not fireable, raises NotFireableTransitionException
	 */
	@Test
	void testFireTransition() throws Exception {
		
		// Test CFT0
		// Not Fireable Setup
		Transition notFireableTransition = this.petriNet.addTransition();
		ArcPT notFireableArc = this.petriNet.addArcPT(9999, this.places.get(0), notFireableTransition);
		ArcTP generousArcTP = this.petriNet.addArcTP(9999, this.places.get(1), notFireableTransition);
		
		// Transition must be fireable
		assertThrows(NotFireableTransitionException.class, () -> {
			this.petriNet.fireTransition(notFireableTransition);
		});
		
		// Test CFT1
		// Basic setup : Place0 -> Transition0 -> Place1
		ArcTP arcTP1 = this.petriNet.addArcTP(2, this.places.get(1), this.transitions.get(0));
		ArcPT arcPT1 = this.petriNet.addArcPT(1, this.places.get(0), this.transitions.get(0));
				
		assertEquals(arcPT1.isFireable(), true);
		assertEquals(this.transitions.get(0).isFireable(), true);

		this.petriNet.fireTransition(this.transitions.get(0));
		// Check for token update
		assertEquals(this.places.get(0).getTokens(), 0);
		assertEquals(this.places.get(1).getTokens(), 4);
		
		
		// Test CFT2
		// Check for fireable state of ArcPT and Transition
		assertEquals(arcPT1.isFireable(), false);
		assertThrows(NotFireableTransitionException.class, () -> {
			this.petriNet.fireTransition(this.transitions.get(0));
		});
		
		
		// Test CFT3
		// Check that if there is a fireable arc and an unfireable arc, the transition is not fireable
		ArcPT fireableArc = this.petriNet.addArcPT(0, this.places.get(1), notFireableTransition);
		assertThrows(NotFireableTransitionException.class, () -> {
			this.petriNet.fireTransition(notFireableTransition);
		});
		
		
		/* Second setup : 
		 * 
		 * Place0 ->  (ArcPT)    -> |
		 * Place1 ->  (ArcDrain) -> | ->  Transition1 -> Place3
		 * Place2 ->  (ArcZero)  -> |
		 * 
		 */
		
		this.places.get(0).setTokens(10);
		this.places.get(1).setTokens(9999);
		this.places.add(this.petriNet.addPlace(4));
		
		ArcPT arcPT2 = this.petriNet.addArcPT(1, this.places.get(0), this.transitions.get(1));
		ArcDrain arcDrain = this.petriNet.addArcDrain(1, this.places.get(1), this.transitions.get(1));
		ArcZero arcZero = this.petriNet.addArcZero(0, this.places.get(2), this.transitions.get(1));
		ArcTP arcTP2 = this.petriNet.addArcTP(2, this.places.get(3), this.transitions.get(1));

		// Test CFT4
		// Not fireable because of arcZero
		assertThrows(NotFireableTransitionException.class, () -> {
			this.petriNet.fireTransition(this.transitions.get(1));
		});
		assertEquals(arcDrain.isActive(), true);
		assertEquals(arcZero.isActive(), false);
		assertEquals(arcDrain.isFireable(), true);
		assertEquals(arcZero.isFireable(), false);
		assertEquals(arcPT2.isFireable(), true);
		
		// Test CFT5
		// Make arcZero fireable
		this.places.get(2).setTokens(0);
		assertEquals(arcZero.isActive(), true);
		
		this.petriNet.fireTransition(this.transitions.get(1));
		
		//Check change in Token
		assertEquals(this.places.get(0).getTokens(), 9);
		assertEquals(this.places.get(1).getTokens(), 0);
		assertEquals(this.places.get(2).getTokens(), 0);
		assertEquals(this.places.get(3).getTokens(), 6);
	}

}
