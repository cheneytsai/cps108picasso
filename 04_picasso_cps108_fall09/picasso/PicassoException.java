package picasso;

/**
 * Represents an exceptional situation specific to this project.
 * 
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class PicassoException extends RuntimeException {
    public PicassoException(String message) {
        super(message);
    }
}
