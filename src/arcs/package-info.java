/**
 * Provides the different types of Arcs that are present in the PetriNet
 * 
 * Content: 
 *    - ArcPT An Arc exiting from a Place and entering into a Transition
 *    - ArcTP An Arc exiting from a Transition and entering into a Place
 *    - ArcDrain An ArcPT which when fired drains all tokens from its Place
 *    - ArcZero An ArcPT which can only be fired when its Place has no tokens 
 * 
 */
package arcs;