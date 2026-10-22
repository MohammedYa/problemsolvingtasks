package ValidatorAndExeption;

/**
 * Signals that a vehicle plate number is already registered.
 */
public class DuplicatePlateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates an exception for a plate number that has already been registered.
     *
     * @param plateNumber the duplicate plate number
     */
    public DuplicatePlateException(String plateNumber) {
        super("Plate number already registered: " + plateNumber);
    }
}
