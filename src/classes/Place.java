package classes;

/**
 * Place models a location in the Petri net where tokens are held.
 * Tokens in a Place determine if a Transition can fire, based on arc conditions.
 */
public class Place {

    // The number of tokens currently held in this Place.
    private int tokens;

    /**
     * Constructor to create a Place with a specified initial number of tokens.
     *
     * @param tokens The initial token count for this Place.
     */
    public Place(int tokens) {
        this.tokens = tokens;
    }

    /**
     * Sets the token count for this Place.
     *
     * @param tokens The new token count to set.
     */
    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    /**
     * Retrieves the current token count for this Place.
     *
     * @return The current number of tokens in this Place.
     */
    public int getToken() {
        return this.tokens;
    }
}
