package tokens;
import java.util.*;


/**
 * Handles creation of tokens and variable values
 * 
 * @author Michael
 */
public abstract class TokenHandler {

    static Map<String, Integer> myVariables = new HashMap<String, Integer>();
    static List<Integer> myExpressionHistory = new ArrayList<Integer>();

    /**
     * Given a string decides what type of Token to create and return
     * 
     * @param str
     * @return
     */
    public static final Token getExpression(String str) {
        if (str.equals(Addition.OPERATION))
            return new Addition();
        if (str.equals(OpenGroup.OPERATION))
            return new OpenGroup();
        if (str.equals(CloseGroup.OPERATION))
            return new CloseGroup();
        
        try {
            return new Constant(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            return new Variable(str);
        }
    }
    
    /**
     * Adds a new variable and value to myVariables
     * 
     * @param name
     * @param value
     */
    public static final void addVariable(String name, int value) {
        myVariables.put(name, value);
    }

}