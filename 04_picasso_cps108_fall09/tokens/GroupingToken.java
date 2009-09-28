package tokens;

public abstract class GroupingToken extends Token {
    
    public GroupingToken(String operation) {
        super(operation, Integer.parseInt(myOOPResources.getString("Grouping")));
    }
    

   
}
