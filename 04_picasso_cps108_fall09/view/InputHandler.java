package view;

import java.util.ArrayList;
import java.util.ResourceBundle;
import picasso.PicassoParser;

public abstract class InputHandler {
    private static ArrayList<String> expressionHistory = new ArrayList<String>();
    private static ArrayList<String> expressionFavorites = new ArrayList<String>();
    private static String currExpression;
    public static PicassoParser myParser = new PicassoParser();
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");
    private static char commentToken = myResources.getString("CommentToken").charAt(0);
    private static int myHistoryIndex = 0;
    
    //Sets current expression to be evaluated
    public static final void setExpression(String exp) {
        if(exp.length() >= 2 && exp.charAt(0) == commentToken)
        {            
            currExpression = expressionHistory.get(Integer.parseInt(exp.substring(1,2)) - 1) + exp.substring(2);
        }
        else
            currExpression = exp;
    }
    
    //Returns expression to be evaluated
    public static final String getExpression() {
        return currExpression;
    }
    
    //Favorites methods
    public static final void addToFavorites() {
        expressionFavorites.add(currExpression);
    }
    
    public static final String setFavoriteExpression(int index) {
        String exp = expressionFavorites.get(index);
        currExpression = exp;
        return exp;
    }
    
    public static boolean isFavoriteIndexValid(int index)
    {
        if(expressionFavorites.size() == 0 || index < 0 || index > expressionFavorites.size() - 1)
            return false;
        return true;
    }
    
    //History Methods
    public static final void addToHistory() {
        expressionHistory.add(currExpression);
    }
    
    public static boolean isHistoryIndexValid(int index)
    {
        if(expressionHistory.size() == 0 || index < 0 || index > expressionHistory.size() - 1)
            return false;
        return true;
    }
    
    public static boolean previousHistory() {
        if(!isHistoryIndexValid(myHistoryIndex - 1))
            return false;
        setExpression(expressionHistory.get(--myHistoryIndex));
        return true;
    }
    
    public static boolean nextHistory() {
        if(!isHistoryIndexValid(myHistoryIndex + 1))
            return false;
        setExpression(expressionHistory.get(++myHistoryIndex));
        return true;
    }
    
    public static void resetHistoryIndex() {
        myHistoryIndex = expressionHistory.size();
    }
    
    public static String getHistoryInfo() {
        return commentToken + "" + (myHistoryIndex + 1) + ": " + currExpression;
    }
}
