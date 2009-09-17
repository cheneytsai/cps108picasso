package Expressions;

import java.util.*;
import arithmetica.*;

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
        if (str.equals(OpenGroup.OPERATION))
            return new OpenGroup();
        if (str.equals(CloseGroup.OPERATION))
            return new CloseGroup();
        if (str.equals(Assignment.OPERATION))
            return new Assignment();
        if (str.equals(Negation.OPERATION))
            return new Negation();
        if (str.equals(Mod.OPERATION))
            return new Mod();
        if (str.equals(AbsoluteValue.OPERATION))
            return new AbsoluteValue();
        if (str.equals(RandomValue.OPERATION))
            return new RandomValue();
        if (str.equals(Comma.OPERATION))
            return new Comma();
        if (str.equals(Maximum.OPERATION))
            return new Maximum();
        if (str.equals(Sum.OPERATION))
            return new Sum();
        if (isHistoryToken(str))
            return parseHistory(str);

        try {
            return new Constant(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            Integer var = myVariables.get(str);
            if (var == null)
                return new Constant(str);
            return new Constant(str, var.intValue());
        }
    }

    /**
     * Returns true if is an history operator
     * 
     * @param str
     * @return
     */
    private static final boolean isHistoryToken(String str) {
        return str.startsWith("!");
    }

    /**
     * Returns a constant token corresponding to the history string given
     * 
     * @param str
     * @return
     */
    private static final Token parseHistory(String str) {
        String newStr = str.substring(1);
        int value;
        try {
            int history = Integer.parseInt(newStr);
            if (history < 0) {
                value = myExpressionHistory.get(myExpressionHistory.size()
                        + history);
            } else {
                value = myExpressionHistory.get(history - 1);
            }
        } catch (NumberFormatException e) {
            throw new ArithmeticaException("Malformed input");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArithmeticaException(str + " Entry does not exist");
        }
        return new Constant(value);
    }

    /**
     * Adds a new value to the history of previous expressions
     * 
     * @param value
     */
    public static final void updateExpressionHistory(int value) {
        myExpressionHistory.add(value);
    }

    /**
     * Clears history
     */
    public static final void clearHistory() {
        myExpressionHistory.clear();
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
