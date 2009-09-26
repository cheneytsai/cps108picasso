package tokens;

public abstract class GroupingToken extends Token {
    public static final int ORDER_OF_OPERATION = -2;
    
    public GroupingToken(String operation) {
        super(operation, ORDER_OF_OPERATION);
    }
    

   
}
