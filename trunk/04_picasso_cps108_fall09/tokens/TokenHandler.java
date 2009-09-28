package tokens;
import java.util.*;


/**
 * Handles creation of tokens and variable values
 * 
 * @author Michael
 */
public abstract class TokenHandler {

    static Map<String, String> myTokenMap = new HashMap<String, String>();
     
    public static final void tokenMapGenerator()
    {
        ResourceBundle myResources = ResourceBundle.getBundle("resources.Tokens");
        for (String s : myResources.keySet())
        {
            myTokenMap.put(s, myResources.getString(s));
        }
        System.out.println(myTokenMap);
    }
    /**
     * Given a string decides what type of Token to create and return
     * 
     * @param str
     * @return
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public static final Token getExpression(String str) {
        if (myTokenMap.containsKey(str))
        {
            Class c = null;
            try {
                c = Class.forName("tokens." + myTokenMap.get(str));
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                return (Token) c.newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
        try {
            return new Constant(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            return new Variable(str);
        }
    }

}
