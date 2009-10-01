package tokens;

/**
 * GroupingToken.java
 * Abstract superclass for grouping tokens (OpenGroup, CloseGroup)
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */
public abstract class GroupingToken extends Token
{

    public GroupingToken(String operation)
    {
        super(operation, Integer.parseInt(myOOPResources.getString("Grouping")));
    }

}
