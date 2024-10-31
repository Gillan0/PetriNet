package interfaces;

import classes.*;
import exception.*;
import java.util.ArrayList;
import arcs.*;

/**
 * IPetriNet defines the interface for a Petri net, outlining methods for adding,removing, and retrieving places, transitions, and arcs within the net.
 */
public interface IPetriNet {

    /**
     * Adds a new Place to the Petri net with a specified initial token count.
     *
     * @param tokens The initial token count for the new Place.
     * @return The created Place object.
     * @throws NegativeException If the token count is negative.
     */
    public Place addPlace(int tokens) throws NegativeException;

    /**
     * Adds a new ArcTP (Transition to Place arc) to the Petri net.
     *
     * @param w The weight of the arc.
     * @param p The Place connected by the arc.
     * @param t The Transition connected by the arc.
     * @return The created ArcTP object.
     * @throws NegativeException If the weight is negative.
     * @throws MissingPlaceException If the specified Place does not exist.
     * @throws MissingTransitionException If the specified Transition does not exist.
     * @throws DuplicateArcException If an identical arc already exists.
     */
    public ArcTP addArcTP(int w, Place p, Transition t) 
            throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

    /**
     * Adds a new ArcPT (Place to Transition arc) to the Petri net.
     *
     * @param w The weight of the arc.
     * @param p The Place connected by the arc.
     * @param t The Transition connected by the arc.
     * @return The created ArcPT object.
     * @throws NegativeException If the weight is negative.
     * @throws MissingPlaceException If the specified Place does not exist.
     * @throws MissingTransitionException If the specified Transition does not exist.
     * @throws DuplicateArcException If an identical arc already exists.
     */
    public ArcPT addArcPT(int w, Place p, Transition t) 
            throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

    /**
     * Adds a new ArcZero (special Place to Transition arc requiring zero tokens) to the Petri net.
     *
     * @param w The weight of the arc.
     * @param p The Place connected by the arc.
     * @param t The Transition connected by the arc.
     * @return The created ArcZero object.
     * @throws NegativeException If the weight is negative.
     * @throws MissingPlaceException If the specified Place does not exist.
     * @throws MissingTransitionException If the specified Transition does not exist.
     * @throws DuplicateArcException If an identical arc already exists.
     */
    public ArcZero addArcZero(int w, Place p, Transition t) 
            throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

    /**
     * Adds a new ArcDrain (special Place to Transition arc that drains tokens) to the Petri net.
     *
     * @param w The weight of the arc.
     * @param p The Place connected by the arc.
     * @param t The Transition connected by the arc.
     * @return The created ArcDrain object.
     * @throws NegativeException If the weight is negative.
     * @throws MissingPlaceException If the specified Place does not exist.
     * @throws MissingTransitionException If the specified Transition does not exist.
     * @throws DuplicateArcException If an identical arc already exists.
     */
    public ArcDrain addArcDrain(int w, Place p, Transition t) 
            throws NegativeException, MissingPlaceException, MissingTransitionException, DuplicateArcException;

    /**
     * Adds a new Transition to the Petri net.
     *
     * @return The created Transition object.
     */
    public Transition addTransition();

    /**
     * Removes a specified Place from the Petri net.
     *
     * @param p The Place to remove.
     * @throws MissingPlaceException If the Place does not exist in the net.
     */
    public void removePlace(Place p) throws MissingPlaceException;

    /**
     * Removes a specified ArcTP (Transition to Place arc) from the Petri net.
     *
     * @param a The ArcTP to remove.
     * @throws MissingArcException If the arc does not exist in the net.
     */
    public void removeArcTP(ArcTP a) throws MissingArcException;

    /**
     * Removes a specified ArcPT (Place to Transition arc) from the Petri net.
     *
     * @param a The ArcPT to remove.
     * @throws MissingArcException If the arc does not exist in the net.
     */
    public void removeArcPT(ArcPT a) throws MissingArcException;

    /**
     * Removes a specified ArcZero from the Petri net.
     *
     * @param a The ArcZero to remove.
     * @throws MissingArcException If the arc does not exist in the net.
     */
    public void removeArcZero(ArcZero a) throws MissingArcException;

    /**
     * Removes a specified ArcDrain from the Petri net.
     *
     * @param a The ArcDrain to remove.
     * @throws MissingArcException If the arc does not exist in the net.
     */
    public void removeArcDrain(ArcDrain a) throws MissingArcException;

    /**
     * Removes a specified Transition from the Petri net.
     *
     * @param t The Transition to remove.
     * @throws MissingTransitionException If the Transition does not exist in the net.
     */
    public void removeTransition(Transition t) throws MissingTransitionException;

    /**
     * Retrieves all Places in the Petri net.
     *
     * @return An ArrayList of Place objects.
     */
    public ArrayList<Place> getPlaces();

    /**
     * Retrieves all ArcTP (Transition to Place arcs) in the Petri net.
     *
     * @return An ArrayList of ArcTP objects.
     */
    public ArrayList<ArcTP> getArcsTP();

    /**
     * Retrieves all ArcPT (Place to Transition arcs) in the Petri net.
     *
     * @return An ArrayList of ArcPT objects.
     */
    public ArrayList<ArcPT> getArcsPT();

    /**
     * Retrieves all ArcZero arcs in the Petri net.
     *
     * @return An ArrayList of ArcZero objects.
     */
    public ArrayList<ArcZero> getArcsZero();

    /**
     * Retrieves all ArcDrain arcs in the Petri net.
     *
     * @return An ArrayList of ArcDrain objects.
     */
    public ArrayList<ArcDrain> getArcsDrain();

    /**
     * Retrieves all Transitions in the Petri net.
     *
     * @return An ArrayList of Transition objects.
     */
    public ArrayList<Transition> getTransitions();
}
