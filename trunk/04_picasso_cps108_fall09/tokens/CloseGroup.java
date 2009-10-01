package tokens;

/**
 * CloseGroup.java
 * Represents a close group token
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu Implements the Close Paran
 *         Operator
 */
public class CloseGroup extends GroupingToken
{
    public static final String OPERATION = ")";

    public CloseGroup()
    {
        super(OPERATION);
    }

}
