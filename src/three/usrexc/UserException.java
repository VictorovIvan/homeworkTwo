package three.usrexc;

/**
 * Class User Exception
 */
public class UserException extends Exception {
    /**
     * Constructs a new user exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public UserException() {
    }

    /**
     * Constructs a new  user exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public UserException(String message) {
        super(message);
    }
}
