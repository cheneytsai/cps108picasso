package Expressions;

/**
 * Represents constants. Holds a name and a value.
 * 
 * @author Michael
 * 
 */
public class Constant extends Token {

    public static final int ORDER_OF_OPERATION = 0;
    public static final String OPERATION = null;
    public static final int NUM_OF_OPERANDS = 0;
    private String myName;
    private int myValue;

    /**
     * Calls superclass constructor then sets myValue and myName to default
     * values
     */
    public Constant() {
        super(NUM_OF_OPERANDS, OPERATION, ORDER_OF_OPERATION);
        myValue = 0;
        myName = null;
    }

    /**
     * Calls default constructor then sets myValue to value passed as parameter
     * 
     * @param value
     */
    public Constant(int value) {
        this();
        myValue = value;
    }

    /**
     * Calls default constructor and sets myName to given name
     * 
     * @param name
     */
    public Constant(String name) {
        this();
        myName = name;
    }

    /**
     * Calls default constructor and sets myName and myValue to given values
     * 
     * @param name
     * @param value
     */
    public Constant(String name, int value) {
        this();
        myName = name;
        myValue = value;
    }

    /**
     * Return value of thisvariable
     * 
     * @return
     */
    @Override
    public int evaluate() {
        return myValue;
    }

    /**
     * Sets the value to the new value
     * 
     * @param newValue
     */
    public void setValue(int newValue) {
        myValue = newValue;
    }

    /**
     * Sets the name to the new name
     * 
     * @param name
     */
    public void setName(String name) {
        myName = name;
    }

    /**
     * Returns the name of this variable
     * 
     * @return
     */
    public String getName() {
        return myName;
    }

}
