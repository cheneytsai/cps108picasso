package tokens;

/**
 * OpenGroup.java
 * 
 * Defines the Open Paren Operator
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public class OpenGroup extends GroupingToken
{
    public static final String OPERATION = "(";

    public OpenGroup()
    {
        super(OPERATION);
    }

}
