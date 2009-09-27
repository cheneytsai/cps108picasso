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
        if (str.equals(Subtraction.OPERATION))
            return new Subtraction();
        if (str.equals(Multiplication.OPERATION))
            return new Multiplication();
        if (str.equals(Division.OPERATION))
            return new Division();
        if (str.equals(Exponentiate.OPERATION))
            return new Exponentiate();
        if (str.equals(Mod.OPERATION))
            return new Mod();
        if (str.equals(PerlinColor.OPERATION))
            return new PerlinColor();
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
