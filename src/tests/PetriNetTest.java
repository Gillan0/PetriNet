package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import arcs.*;
import exception.*;
import main.*;

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
		emptyPetriNet = new PetriNet();
		emptyTransitions = new ArrayList<Transition>();
		emptyPlaces = new ArrayList<Place>();
		
		// Creates a PetriNet with 3 places and 2 transitions
		petriNet = new PetriNet();
		transitions = new ArrayList<Transition>();
		places = new ArrayList<Place>();	

		places.add(petriNet.addPlace(1));
		places.add(petriNet.addPlace(2));
		places.add(petriNet.addPlace(3));
		
		transitions.add(petriNet.addTransition());
		transitions.add(petriNet.addTransition());
		
	}
	
	/**
	 * Checks that constructor creates an empty PetriNet
	 * @result PetriNet created without any errors,
	 * 		   with no places, no transitions and no arcs 
	 */
	@Test
	void testPetriNet() {		
	
		assertEquals(emptyPetriNet.getPlaces().size(), 0);
		assertEquals(emptyPetriNet.getTransitions().size(), 0);
		assertEquals(emptyPetriNet.getArcsTP().size(), 0);
		assertEquals(emptyPetriNet.getArcsPT().size(), 0);
		assertEquals(emptyPetriNet.getArcsZero().size(), 0);
		assertEquals(emptyPetriNet.getArcsDrain().size(), 0);
		
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
		assertEquals(emptyPetriNet.getPlaces().size(),0);
		assertEquals(petriNet.getPlaces().size(),3);

		// Checks after adding a Place
		Place p = emptyPetriNet.addPlace(0);
		assertEquals(emptyPetriNet.getPlaces().size(), 1);
		assertEquals(emptyPetriNet.getPlaces().contains(p), true);
		
		// Checks after removing a Place
		emptyPetriNet.removePlace(p);
		assertEquals(emptyPetriNet.getPlaces().size(), 0);
		assertEquals(emptyPetriNet.getPlaces().contains(p), false);
		
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
		assertEquals(petriNet.getArcsTP().size(), 0);
		
		ArcTP a1 = petriNet.addArcTP(0, places.get(0), transitions.get(0));
		ArcTP a2 = petriNet.addArcTP(1, places.get(1), transitions.get(0));
		
		// Checks after adding ArcTP
		assertEquals(petriNet.getArcsTP().size(), 2);
		assertEquals(petriNet.getArcsTP().contains(a1), true);
		assertEquals(petriNet.getArcsTP().contains(a2), true);
		
		// Checks after removing ArcTP
		petriNet.removeArcTP(a1);
		assertEquals(petriNet.getArcsTP().size(), 1);
		assertEquals(petriNet.getArcsTP().contains(a1), false);
		
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
		assertEquals(petriNet.getArcsPT().size(), 0);
		
		ArcPT a1 = petriNet.addArcPT(0, places.get(0), transitions.get(0));
		ArcPT a2 = petriNet.addArcPT(1, places.get(1), transitions.get(0));

		// Checks after adding ArcPT
		assertEquals(petriNet.getArcsPT().size(), 2);
		assertEquals(petriNet.getArcsPT().contains(a1), true);
		assertEquals(petriNet.getArcsPT().contains(a2), true);
		
		// Checks after adding ArcPT
		petriNet.removeArcPT(a1);
		assertEquals(petriNet.getArcsPT().size(), 1);
		assertEquals(petriNet.getArcsPT().contains(a1), false);
		
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
		assertEquals(petriNet.getArcsZero().size(), 0);
		
		// Checks after adding ArcZero
		ArcZero a1 = petriNet.addArcZero(0, places.get(0), transitions.get(0));
		ArcZero a2 = petriNet.addArcZero(1, places.get(1), transitions.get(0));
		
		assertEquals(petriNet.getArcsZero().size(), 2);
		assertEquals(petriNet.getArcsZero().contains(a1), true);
		assertEquals(petriNet.getArcsZero().contains(a2), true);
		
		
		// Checks after removal of ArcZero
		petriNet.removeArcZero(a1);
		assertEquals(petriNet.getArcsZero().size(), 1);
		assertEquals(petriNet.getArcsZero().contains(a1), false);
		
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
		assertEquals(petriNet.getArcsDrain().size(), 0);
		
		// Checks after adding ArcDrain
		ArcDrain a1 = petriNet.addArcDrain(0, places.get(0), transitions.get(0));
		ArcDrain a2 = petriNet.addArcDrain(1, places.get(1), transitions.get(0));
		assertEquals(petriNet.getArcsDrain().size(), 2);
		assertEquals(petriNet.getArcsDrain().contains(a1), true);
		assertEquals(petriNet.getArcsDrain().contains(a2), true);
		
		// Checks after removing ArcDrain
		petriNet.removeArcDrain(a1);
		assertEquals(petriNet.getArcsDrain().size(), 1);
		assertEquals(petriNet.getArcsDrain().contains(a1), false);
		
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
		assertEquals(emptyPetriNet.getTransitions().size(),0);
		assertEquals(petriNet.getTransitions().size(),2);

		// Checks after adding a transition
		Transition t = emptyPetriNet.addTransition();
		assertEquals(emptyPetriNet.getTransitions().size(), 1);
		assertEquals(emptyPetriNet.getTransitions().contains(t), true);
		
		// Checks after removing a transition
		emptyPetriNet.removeTransition(t);
		assertEquals(emptyPetriNet.getTransitions().size(), 0);
		assertEquals(emptyPetriNet.getTransitions().contains(t), false);
		
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
		Place p1 = emptyPetriNet.addPlace(0);
		emptyPlaces.add(p1);
		assertEquals(emptyPetriNet.getPlaces().get(0), p1);
		
		Place p2 = emptyPetriNet.addPlace(5);
		emptyPlaces.add(p2);		
		assertEquals(emptyPetriNet.getPlaces().get(1), p2);
		
		Place p3 = emptyPetriNet.addPlace(3);
		emptyPlaces.add(p3);		
		assertEquals(emptyPetriNet.getPlaces().get(2), p3);
		
		// Checks that no negative number can be put as parameter
		assertThrows(NegativeException.class, () -> {
			emptyPetriNet.addPlace(-1);
		});
		
		// Checks that the amount of token of the places are the same that were in() method parameter
		assertEquals(p1.getTokens(), 0);
		assertEquals(p2.getTokens(), 5);
				
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
			petriNet.addTokens(places.get(0), -10);
		});
		
		// Test CAT1
		assertThrows(MissingPlaceException.class, () -> {
			emptyPetriNet.addTokens(null, 0);
		});
		
		// Test CAT2
		assertThrows(MissingPlaceException.class, () -> {
			emptyPetriNet.addTokens(places.get(0), 0);
		});
		
		// Test CAT3
		petriNet.addTokens(places.get(0), 10);
		assertEquals(places.get(0).getTokens(), 11);
		
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
			petriNet.addArcTP(-5,
					petriNet.getPlaces().get(0),
					petriNet.getTransitions().get(0)
				);
		});

		// Test CAATP1
		// Creating an ArcTP requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcTP(10,
					emptyPetriNet.addPlace(0),
					petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAATP2
		// Creating an ArcTP requires a non null Place 
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcTP(10,
					null,
					petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAATP3
		// Creating an ArcTP requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcTP(0,
					petriNet.getPlaces().get(0),
					emptyPetriNet.addTransition()
				);
		});
		
		// Test CAATP4
		// Creating an ArcTP requires a non null Transition
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcTP(0,
					petriNet.getPlaces().get(0),
					null
				);
		});
 
		
		// Test CAATP5 - 3 test instances
		ArcTP a1 = petriNet.addArcTP(0, places.get(0), transitions.get(0));
		ArcTP a2 = petriNet.addArcTP(1, places.get(1), transitions.get(0));
		ArcTP a3 = petriNet.addArcTP(2, places.get(0), transitions.get(1));
	
		// Checks that added ArcTP are recorded in the PetriNet
		assertEquals(petriNet.getArcsTP().contains(a1), true);
		assertEquals(petriNet.getArcsTP().contains(a2), true);
		assertEquals(petriNet.getArcsTP().contains(a3), true);
		
		// Checks that ArcTP are linked to the correct Place
		assertEquals(a1.getPlace(),places.get(0));
		assertEquals(a2.getPlace(),places.get(1));
		
		// Checks that ArcTP are linked to the correct Transition
		assertEquals(a2.getTransition(),transitions.get(0));
		assertEquals(a3.getTransition(),transitions.get(1));
		assertEquals(transitions.get(0).getArcsTP().size(), 2);
		assertEquals(transitions.get(1).getArcsTP().size(), 1);
		
		// Checks that ArcTP has the correct weight
		assertEquals(a1.getWeight(), 0);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);
		// End Test CAATP5
		
		// Checks that the added ArcTP can distribute tokens to its arriving Place
		assertEquals(places.get(0).getTokens(), 1);
		a1.distributeTokens();
		assertEquals(places.get(0).getTokens(), 1);
		
		assertEquals(places.get(0).getTokens(), 1);
		a3.distributeTokens();
		assertEquals(places.get(0).getTokens(), 3);

		// Test CADTP0
		// Two ArcTP can't be linked to the same Place and Transition
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcTP(50, places.get(0), transitions.get(0));
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
			petriNet.addArcPT(-5,
					petriNet.getPlaces().get(0),
					petriNet.getTransitions().get(0)
				);
		});

		// Test CAAPT1
		// Creating an ArcPT requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcPT(10,
					emptyPetriNet.addPlace(0),
					petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAAPT2
		// Creating an ArcPT requires a non null Place
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcPT(10,
					null,
					petriNet.getTransitions().get(0)
				);
		});
		
		// Test CAAPT3
		// Creating an ArcPT requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcPT(0,
					petriNet.getPlaces().get(0),
					emptyPetriNet.addTransition()
				);
		});

		// Test CAAPT4
		// Creating an ArcPT requires a non null Transition
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcPT(0,
					petriNet.getPlaces().get(0),
					null
				);
		});
		
		// Test CAAPT5 - 3 test instances
		ArcPT a1 = petriNet.addArcPT(0, places.get(0), transitions.get(0));
		ArcPT a2 = petriNet.addArcPT(1, places.get(1), transitions.get(0));
		ArcPT a3 = petriNet.addArcPT(2, places.get(0), transitions.get(1));
	
		
		// Checks that ArcPT is added to PetiNet
		assertEquals(petriNet.getArcsPT().contains(a1), true);
		assertEquals(petriNet.getArcsPT().contains(a2), true);
		assertEquals(petriNet.getArcsPT().contains(a3), true);
		
		// Checks that ArcTP is linked to correct Place
		assertEquals(a1.getPlace(),places.get(0));
		assertEquals(a2.getPlace(),places.get(1));

		// Checks that ArcPT is linked to correct Transition
		assertEquals(a2.getTransition(),transitions.get(0));
		assertEquals(a3.getTransition(),transitions.get(1));
		assertEquals(transitions.get(0).getArcsPT().size(), 2);
		assertEquals(transitions.get(1).getArcsPT().size(), 1);
		
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
		assertEquals(places.get(0).getTokens(), 1);
		a1.removeTokens();
		assertEquals(places.get(0).getTokens(), 1);
		
		assertEquals(places.get(1).getTokens(), 2);
		a2.removeTokens();
		assertEquals(places.get(1).getTokens(), 1);
		
		// Update after removal of tokens
		assertEquals(a3.isFireable(), false);
		assertEquals(a2.isFireable(), true);
		
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		// Test CADPT0
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcPT(50, places.get(0), transitions.get(0));
		});

		// Test CADPT1
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcDrain(50, places.get(0), transitions.get(0));
		});
				
		// Test CADPT2
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcZero(50, places.get(0), transitions.get(0));
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
			petriNet.addArcZero(-5,
					petriNet.getPlaces().get(0),
					petriNet.getTransitions().get(0)
				);
		});

		// Creating an ArcZero requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcZero(10,
					null,
					petriNet.getTransitions().get(0)
				);
		});
		
		// Creating an ArcZero requires an existing Transition in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcZero(0,
					petriNet.getPlaces().get(0),
					null
				);
		});
		
		ArcZero a1 = petriNet.addArcZero(1, places.get(0), transitions.get(0));
		ArcZero a2 = petriNet.addArcZero(1, places.get(1), transitions.get(0));
		ArcZero a3 = petriNet.addArcZero(2, places.get(0), transitions.get(1));
	
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcZero(50, places.get(0), transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcPT(50, places.get(0), transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcDrain(50, places.get(0), transitions.get(0));
		});
		
		// Checks that ArcZero is added to PetiNet
		assertEquals(petriNet.getArcsZero().contains(a1), true);
		assertEquals(petriNet.getArcsZero().contains(a2), true);
		assertEquals(petriNet.getArcsZero().contains(a3), true);
		
		// Checks that ArcZero is linked to correct Place
		assertEquals(a1.getPlace(),places.get(0));
		assertEquals(a2.getPlace(),places.get(1));

		// Checks that ArcZero is linked to correct Transition
		assertEquals(a2.getTransition(),transitions.get(0));
		assertEquals(a3.getTransition(),transitions.get(1));
		assertEquals(transitions.get(0).getArcsPT().size(), 2);
		assertEquals(transitions.get(1).getArcsPT().size(), 1);
		
		// Checks that ArcTP has correct weight
		assertEquals(a1.getWeight(), 1);
		assertEquals(a2.getWeight(), 1);
		assertEquals(a3.getWeight(), 2);

		Place p = petriNet.addPlace(0);
		ArcZero a4 = petriNet.addArcZero(0, p, transitions.get(1));
		
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
			petriNet.addArcDrain(-5,
					petriNet.getPlaces().get(0),
					petriNet.getTransitions().get(0)
				);
		});

		// Creating an ArcDrain requires an existing Place in the PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.addArcDrain(10,
					null,
					petriNet.getTransitions().get(0)
				);
		});
		
		// Creating an ArcDrain requires an existing Place in the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.addArcDrain(0,
					petriNet.getPlaces().get(0),
					null
				);
		});
		

		Place p = petriNet.addPlace(0);
		
		ArcDrain a1 = petriNet.addArcDrain(0, places.get(0), transitions.get(0));
		ArcDrain a2 = petriNet.addArcDrain(1, p, transitions.get(0));
		ArcDrain a3 = petriNet.addArcDrain(3, places.get(1), transitions.get(1));
		ArcDrain a4 = petriNet.addArcDrain(1, p, transitions.get(1));
	
		// Two ArcPT (subclass as well) can't be linked to the same Place and Transition 
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcDrain(50, places.get(0), transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcPT(50, places.get(0), transitions.get(0));
		});
		assertThrows(DuplicateArcException.class, () -> {
			petriNet.addArcZero(50, places.get(0), transitions.get(0));
		});
		
		// Checks that ArcDrain is recorded in PetriNet
		assertEquals(petriNet.getArcsDrain().contains(a1), true);
		assertEquals(petriNet.getArcsDrain().contains(a2), true);
		assertEquals(petriNet.getArcsDrain().contains(a3), true);
		
		// Checks that ArcDrain is linked to correct Place
		assertEquals(a1.getPlace(),places.get(0));
		assertEquals(a2.getPlace(),p);

		// Checks that ArcDrain is linked to correct Transition
		assertEquals(a2.getTransition(),transitions.get(0));
		assertEquals(a3.getTransition(),transitions.get(1));
		assertEquals(transitions.get(0).getArcsPT().size(), 2);
		assertEquals(transitions.get(1).getArcsPT().size(), 2);
		
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
	 * Checks that addTransition() methods creates a Transition and puts it in the PetriNet
	 * 
	 * @result Transition created without any error and added to the PetriNet.
	 *         addTransition() method returns the Transition created.   
	 */
	@Test
	void testAddTransition() {

		// Checks that Transitions are added to the PetriNet
		Transition t1 = emptyPetriNet.addTransition();
		emptyTransitions.add(t1);
		assertEquals(emptyPetriNet.getTransitions().get(0), t1);
		
		Transition t2 = emptyPetriNet.addTransition();
		emptyTransitions.add(t2);
		assertEquals(emptyPetriNet.getTransitions().get(1), t2);

		// Checks that the Transition created has no Arc linked to it
		assertEquals(t1.getArcsPT().size(), 0);
		assertEquals(t1.getArcsTP().size(), 0);
		
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
			emptyPetriNet.removePlace(null);
		});
		
		// Cannot remove Place in an empty PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			emptyPetriNet.removePlace(places.get(0));
		});
		
		// Cannot remove Place not in PetriNet
		assertThrows(MissingPlaceException.class, () -> {
			Place p = emptyPetriNet.addPlace(2);
			petriNet.removePlace(p);
		});
		
		assertEquals(petriNet.getPlaces().size(), 3);
		
		// Removes a Place
		petriNet.removePlace(places.get(1));
		assertEquals(petriNet.getPlaces().size(), 2);
		assertEquals(petriNet.getPlaces().contains(places.get(1)), false);
		// Can't remove it again
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.removePlace(places.get(1));
		});
		
		// Removes a Place connected to an ArcTP, an ArcTP, an ArcZero and an ArcDrain
		
		Transition t =  petriNet.addTransition();
		
		petriNet.addArcTP(0, places.get(2), transitions.get(0));
		petriNet.addArcPT(0, places.get(2), transitions.get(0));
		petriNet.addArcZero(0, places.get(2), transitions.get(1));
		petriNet.addArcDrain(0, places.get(2), t);
		
		petriNet.removePlace(places.get(2));
		assertEquals(petriNet.getPlaces().size(), 1);
		assertEquals(petriNet.getPlaces().contains(places.get(2)), false);
		// Can't remove it again
		assertThrows(MissingPlaceException.class, () -> {
			petriNet.removePlace(places.get(2));
		});
		
		assertEquals(petriNet.getArcsTP().size(), 0);
		assertEquals(petriNet.getArcsPT().size(), 0);
	}

	/**
	 * Checks that removeTokens() method removes the correct amount of tokens to a Place recorded in the PetriNet
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
			petriNet.removeTokens(places.get(0), -10);
		});
		
		// Test CRT1
		assertThrows(NegativeException.class, () -> {
			petriNet.removeTokens(places.get(0), 10);
		});
		
		// Test CRT2
		assertThrows(MissingPlaceException.class, () -> {
			emptyPetriNet.removeTokens(places.get(0), 0);
		});
		
		// Test CRT3
		assertThrows(MissingPlaceException.class, () -> {
			emptyPetriNet.removeTokens(null, 0);
		});
		
		// Test CRT4
		petriNet.removeTokens(places.get(2), 1);
		assertEquals(places.get(2).getTokens(), 2);
		
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
		ArcTP a1 = petriNet.addArcTP(0, places.get(0), transitions.get(0));
		ArcTP a2 = petriNet.addArcTP(1, places.get(1), transitions.get(0));
		petriNet.addArcTP(2, places.get(0), transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcTP(null);
		});
		
		// Cannot remove ArcTP from a PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcTP(a1);			
		});
		
		// Checks that ArcTP is no longer recorded in PetriNet
		petriNet.removeArcTP(a1);		
		assertEquals(petriNet.getArcsTP().size(),2);
		assertEquals(petriNet.getArcsTP().contains(a1), false);
		
		// Checks that ArcTP is no longer recorded in its Transition
		assertEquals(transitions.get(0).getArcsTP().contains(a1), false);
		
		// Checks that ArcTP can not be removed again
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcTP(a1);
		});
		
		// Same test for another ArcTP
		petriNet.removeArcTP(a2);		
		assertEquals(petriNet.getArcsTP().size(),1);
		assertEquals(petriNet.getArcsTP().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcTP(a2);
		});
		assertEquals(transitions.get(0).getArcsTP().contains(a2), false);
		
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
		ArcPT a1 = petriNet.addArcPT(0, places.get(0), transitions.get(0));
		ArcPT a2 = petriNet.addArcPT(1, places.get(1), transitions.get(0));
		petriNet.addArcPT(2, places.get(0), transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcPT(null);
		});
		
		// Cannot remove ArcPT from PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcPT(a1);			
		});

		petriNet.removeArcPT(a1);		

		// Checks that ArcPT is no longer recorded in PetriNet
		assertEquals(petriNet.getArcsPT().size(),2);
		assertEquals(petriNet.getArcsPT().contains(a1), false);
		
		// Checks that ArcPT is no longer linked to its Transition
		assertEquals(transitions.get(0).getArcsPT().contains(a1), false);
		
		// Cannot remove this ArcPT again
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcPT(a1);
		});
		
		// Same tests for another ArcPT
		petriNet.removeArcPT(a2);		
		assertEquals(petriNet.getArcsPT().size(),1);
		assertEquals(petriNet.getArcsPT().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcPT(a2);
		});
		assertEquals(transitions.get(0).getArcsPT().contains(a2), false);

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
		ArcZero a1 = petriNet.addArcZero(0, places.get(0), transitions.get(0));
		ArcZero a2 = petriNet.addArcZero(1, places.get(1), transitions.get(0));
		petriNet.addArcZero(2, places.get(0), transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcZero(null);
		});
		
		// Cannot remove an ArcZero from a PetriNet where it is not recorded
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcZero(a1);			
		});
		
		petriNet.removeArcZero(a1);		
		
		// Checks that ArcZero is no longer recorded in PetriNet
		assertEquals(petriNet.getArcsZero().size(),2);
		assertEquals(petriNet.getArcsZero().contains(a1), false);
		
		// ArcZero is no longer linked to its Transition
		assertEquals(transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
		
		// ArcZero cannot be removed again
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcZero(a1);
		});
		
		// Same tests for another ArcZero
		petriNet.removeArcZero(a2);		
		assertEquals(petriNet.getArcsZero().size(),1);
		assertEquals(petriNet.getArcsZero().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcZero(a2);
		});
		assertEquals(transitions.get(0).getArcsPT().contains((ArcPT) a2), false);
	
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
		ArcDrain a1 = petriNet.addArcDrain(0, places.get(0), transitions.get(0));
		ArcDrain a2 = petriNet.addArcDrain(1, places.get(1), transitions.get(0));
		petriNet.addArcDrain(2, places.get(0), transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcDrain(null);
		});
		
		// Cannot remove ArcDrain which is not recorded in PetriNet
		assertThrows(MissingArcException.class, () -> {
			emptyPetriNet.removeArcDrain(a1);			
		});
		
		petriNet.removeArcDrain(a1);		
		
		// Checks that ArcDrain is no longer recorded in PetriNet 
		assertEquals(petriNet.getArcsDrain().size(),2);
		assertEquals(petriNet.getArcsDrain().contains(a1), false);
		
		// Checks that ArcDrain is no longer linked to its Transition
		assertEquals(transitions.get(0).getArcsPT().contains((ArcPT) a1), false);
		
		// Cannot remove this ArcDrain again
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcDrain(a1);
		});
		
		// Same tests for another ArcDrain
		petriNet.removeArcDrain(a2);		
		assertEquals(petriNet.getArcsDrain().size(),1);
		assertEquals(petriNet.getArcsDrain().contains(a2), false);
		assertThrows(MissingArcException.class, () -> {
			petriNet.removeArcDrain(a2);
		});
		assertEquals(transitions.get(0).getArcsPT().contains((ArcPT) a2), false);
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
		
		ArcTP a1 = petriNet.addArcTP(0, places.get(0), transitions.get(0));
		ArcPT a2 = petriNet.addArcPT(0, places.get(0), transitions.get(0));
		ArcTP a3 = petriNet.addArcTP(0, places.get(0), transitions.get(1));
		ArcPT a4 = petriNet.addArcPT(0, places.get(0), transitions.get(1));
		
		// Cannot remove null
		assertThrows(MissingTransitionException.class, () -> {
			emptyPetriNet.removeTransition(null);
		});
		
		// Cannot remove Transition which is not part of the PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			emptyPetriNet.removeTransition(transitions.get(0));
		});
		
		
		petriNet.removeTransition(transitions.get(1));
		
		// Checks that related Arcs are removed
		assertEquals(petriNet.getArcsTP().size(), 1);
		assertEquals(petriNet.getArcsTP().contains(a3), false);
		assertEquals(petriNet.getArcsPT().size(), 1);
		assertEquals(petriNet.getArcsPT().contains(a4), false);
		
		// Checks that Transition is removed from PetriNet
		assertEquals(petriNet.getTransitions().size(), 1);
		assertEquals(petriNet.getTransitions().contains(transitions.get(1)), false);
		// Cannot remove it again from same PetriNet
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.removeTransition(transitions.get(1));
		});
		
		// Same tests with another Transition
		petriNet.removeTransition(transitions.get(0));
		assertEquals(petriNet.getArcsTP().size(), 0);
		assertEquals(petriNet.getArcsTP().contains(a1), false);
		assertEquals(petriNet.getArcsPT().size(), 0);
		assertEquals(petriNet.getArcsPT().contains(a2), false);
		assertEquals(petriNet.getTransitions().size(), 0);
		assertThrows(MissingTransitionException.class, () -> {
			petriNet.removeTransition(transitions.get(0));
		});
		
		
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
		Transition notFireableTransition = petriNet.addTransition();
		petriNet.addArcPT(9999, places.get(0), notFireableTransition); // Non Fireable Arc
		petriNet.addArcTP(9999, places.get(1), notFireableTransition);
		
		// Transition must be fireable
		assertThrows(NotFireableTransitionException.class, () -> {
			petriNet.fireTransition(notFireableTransition);
		});
		
		// Test CFT1
		// Basic setup : Place0 -> Transition0 -> Place1
		petriNet.addArcTP(2, places.get(1), transitions.get(0));
		ArcPT arcPT1 = petriNet.addArcPT(1, places.get(0), transitions.get(0));
				
		assertEquals(arcPT1.isFireable(), true);
		assertEquals(transitions.get(0).isFireable(), true);

		petriNet.fireTransition(transitions.get(0));
		// Check for token update
		assertEquals(places.get(0).getTokens(), 0);
		assertEquals(places.get(1).getTokens(), 4);
		
		
		// Test CFT2
		// Check for fireable state of ArcPT and Transition
		assertEquals(arcPT1.isFireable(), false);
		assertThrows(NotFireableTransitionException.class, () -> {
			petriNet.fireTransition(transitions.get(0));
		});
		
		
		// Test CFT3
		// Check that if there is a fireable arc and an unfireable arc, the transition is not fireable
		petriNet.addArcPT(0, places.get(1), notFireableTransition); // fireableArc
		assertThrows(NotFireableTransitionException.class, () -> {
			petriNet.fireTransition(notFireableTransition);
		});
		
		
		/* Second setup : 
		 * 
		 * Place0 ->  (ArcPT)    -> |
		 * Place1 ->  (ArcDrain) -> | ->  Transition1 -> Place3
		 * Place2 ->  (ArcZero)  -> |
		 * 
		 */

		petriNet.addTokens(places.get(0), 10);
		petriNet.addTokens(places.get(1), 9995);
		
		places.add(petriNet.addPlace(4));
		
		ArcPT arcPT2 = petriNet.addArcPT(1, places.get(0), transitions.get(1));
		ArcDrain arcDrain = petriNet.addArcDrain(1, places.get(1), transitions.get(1));
		ArcZero arcZero = petriNet.addArcZero(0, places.get(2), transitions.get(1));
		petriNet.addArcTP(2, places.get(3), transitions.get(1)); // arcTP2

		// Test CFT4
		// Not fireable because of arcZero
		assertThrows(NotFireableTransitionException.class, () -> {
			petriNet.fireTransition(transitions.get(1));
		});
		assertEquals(arcDrain.isActive(), true);
		assertEquals(arcZero.isActive(), false);
		assertEquals(arcDrain.isFireable(), true);
		assertEquals(arcZero.isFireable(), false);
		assertEquals(arcPT2.isFireable(), true);
		
		// Test CFT5
		// Make arcZero fireable
		petriNet.removeTokens(places.get(2), 3);
		assertEquals(arcZero.isActive(), true);
		
		petriNet.fireTransition(transitions.get(1));
		
		//Check change in Token
		assertEquals(places.get(0).getTokens(), 9);
		assertEquals(places.get(1).getTokens(), 0);
		assertEquals(places.get(2).getTokens(), 0);
		assertEquals(places.get(3).getTokens(), 6);
	}

	/**
	 * Checks that the toString() method returns a correct description of the PetriNet
	 * 
	 * @throws Exception
	 */
	@Test
	void testToString() throws Exception {
		
		assertEquals(emptyPetriNet.toString(), 
			"Content of PetriNet : \n"
				+ "  • 0 places\n"
				+ "  • 0 transitions\n"
				+ "  • 0 ArcPT\n"
				+ "  • 0 ArcTP\n"
		);
		
		assertEquals(petriNet.toString(), 
				"Content of PetriNet : \n"
				+ "  • 3 places\n"
				+ "  • 2 transitions\n"
				+ "  • 0 ArcPT\n"
				+ "  • 0 ArcTP\n"
				+ "Places : \n"
				+ "  • 0 : place with 1 tokens\n"
				+ "  • 1 : place with 2 tokens\n"
				+ "  • 2 : place with 3 tokens\n"
				+ "Transitions : \n"
				+ "  • 0 : transition with 0 entering arcs and 0 exiting arcs\n"
				+ "  • 1 : transition with 0 entering arcs and 0 exiting arcs\n"
				+ ""
		);
		
		petriNet.addArcTP(1, places.get(0), transitions.get(0));
		petriNet.addArcPT(2, places.get(1), transitions.get(0));
		petriNet.addArcZero(3, places.get(2), transitions.get(1));
		petriNet.addArcDrain(4, places.get(0), transitions.get(1));
		
		assertEquals(petriNet.toString(),
				"Content of PetriNet : \n"
				+ "  • 3 places\n"
				+ "  • 2 transitions\n"
				+ "  • 3 ArcPT\n"
				+ "  • 1 ArcTP\n"
				+ "Places : \n"
				+ "  • 0 : place with 1 tokens\n"
				+ "  • 1 : place with 2 tokens\n"
				+ "  • 2 : place with 3 tokens\n"
				+ "Transitions : \n"
				+ "  • 0 : transition with 1 entering arcs and 1 exiting arcs\n"
				+ "  • 1 : transition with 2 entering arcs and 0 exiting arcs\n"
				+ "ArcTP : \n"
				+ "  • 0 : ArcTP with a weight of 1 and connected place with 1 tokens\n"
				+ "ArcPT : \n"
				+ "  • 0 : ArcPT with a weight of 2 and connected place with 2 tokens\n"
				+ "  • 1 : ArcZero with a weight of 3 and connected place with 3 tokens\n"
				+ "  • 2 : ArcDrain with a weight of 4 and connected place with 1 tokens\n"
		); 
	}
	
	/**
	 * Checks that the show() method prints a correct description of the PetriNet
	 * in the console
	 * 
	 * @throws Exception
	 */
	@Test
	void testShow() throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    PrintStream originalOut = System.out;
	    System.setOut(new PrintStream(outputStream));
	    
    	emptyPetriNet.show();
        assertEquals(outputStream.toString(), emptyPetriNet.toString());
        
        outputStream.reset();
        petriNet.show();
        assertEquals(outputStream.toString(), petriNet.toString());
		
        
		petriNet.addArcTP(1, places.get(0), transitions.get(0));
		petriNet.addArcPT(2, places.get(1), transitions.get(0));
		petriNet.addArcZero(3, places.get(2), transitions.get(1));
		petriNet.addArcDrain(4, places.get(0), transitions.get(1));
		
		outputStream.reset();
		petriNet.show();
		assertEquals(outputStream.toString(),petriNet.toString());     
	        
	    System.setOut(originalOut);

	}
}
