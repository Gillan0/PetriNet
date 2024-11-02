package exception;

/**
 * NonFireableTransitionException is a custom exception class used to indicate that a Transition cannot be fired.
 */
public class NonFireableTransitionException extends Exception {

    /**
     * Constructor for NonFireableTransitionException.
     *
     * @param message The error message to display when the exception is thrown.
     */
    public NonFireableTransitionException(String message) {
        super(message); // Passes the message to the superclass (Exception) constructor.
    }
}
