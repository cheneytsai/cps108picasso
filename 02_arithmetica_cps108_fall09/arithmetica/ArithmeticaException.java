package arithmetica;

/**
 * Represents an exceptional situation specific to this project.
 * 
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class ArithmeticaException extends RuntimeException {
    public ArithmeticaException(String message) {
        super(message);
    }
}
