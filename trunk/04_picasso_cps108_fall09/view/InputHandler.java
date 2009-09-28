package view;

import java.util.ArrayList;
import java.util.ResourceBundle;
import picasso.PicassoParser;

public abstract class InputHandler {
    private static ArrayList<String> expressionHistory = new ArrayList<String>();
    private static String currExpression;
    public static PicassoParser myParser = new PicassoParser();
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");
    private static char commentToken = myResources.getString("CommentToken").charAt(0);
    
    public static final void setExpression(String exp) {
        if(exp.length() >= 2 && exp.charAt(0) == commentToken)
        {            
            currExpression = expressionHistory.get(Integer.parseInt(exp.substring(1,2)) - 1) + exp.substring(2);
        }
        else
            currExpression = exp;
    }
    
    public static final String getExpression() {
        return currExpression;
    }
    
    public static final void addToHistory() {
        expressionHistory.add(currExpression);
    }
    
    public static final String setExpression(int index) {
        String exp = expressionHistory.get(index);
        currExpression = exp;
        return exp;
    }
       
    public static boolean isIndexValid(int index)
    {
        if(expressionHistory.size() == 0 || index < 0 || index > expressionHistory.size() - 1)
            return false;
        return true;
    }
}
