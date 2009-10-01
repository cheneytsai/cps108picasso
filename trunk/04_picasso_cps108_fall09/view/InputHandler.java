package view;

import java.util.ArrayList;
import java.util.ResourceBundle;
import picasso.PicassoException;
import picasso.PicassoParser;


/**
 * Handles all input to be evaluated by storing it in a variable. Also stores
 * history of expressions and favorite expressions.
 */
public abstract class InputHandler
{
    private static ArrayList<String> expressionHistory =
        new ArrayList<String>();
    private static ArrayList<String> expressionFavorites =
        new ArrayList<String>();
    private static String currExpression;
    public static PicassoParser myParser = new PicassoParser();
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");
    private static char historyToken =
        myResources.getString("HistoryToken").charAt(0);
    private static int myHistoryIndex = 0;
    private static boolean parseError = false;


    /**
     * Sets the expression to be evaluated.
     * 
     * @param expression to be evaluated
     */
    public static final void setExpression (String exp) throws PicassoException
    {
        currExpression = exp;
        parseError = false;
    }


    /**
     * @return expression to be evaluated.
     */
    public static final String getExpression ()
    {
        return currExpression;
    }


    //Favorites methods
    /**
     * Adds the most recent successfully evaluated expression to favorites.
     */
    public static final void addToFavorites ()
    {
        int size = expressionHistory.size();
        if (size != 0) expressionFavorites.add(expressionHistory.get(size - 1));
    }


    /**
     * Sets the expression to be evaluated as the expression located at the
     * given index in expressionFavorites.
     * 
     * @param index of expression in expressionFavorites to be evaluated.
     * @return expression at index.
     */
    public static final String getFavoriteExpression (int index)
    {
        String exp = expressionFavorites.get(index);
        currExpression = exp;
        return exp;
    }


    /**
     * Checks if the given index exists in expressionFavorites.
     * 
     * @param index of expression in expressionFavorites to be evaluated.
     * @return true if index exists in expressionFavorites.
     */
    public static boolean isFavoriteIndexValid (int index)
    {
        if (expressionFavorites.size() == 0 || index < 0 ||
            index > expressionFavorites.size() - 1) return false;
        return true;
    }


    //History Methods
    /**
     * Adds the most recent evaluated expression to history if it evaluated
     * successfully.
     */
    public static final void addToHistory ()
    {
        if (!parseError) expressionHistory.add(currExpression);
    }


    /**
     * Checks if the given index exists in expressionHistory.
     * 
     * @param index of expression in expressionHistory to be evaluated.
     * @return true if index exists in expressionHistory.
     */
    public static boolean isHistoryIndexValid (int index)
    {
        if (expressionHistory.size() == 0 || index < 0 ||
            index > expressionHistory.size() - 1) return false;
        return true;
    }


    /**
     * Sets the expression to be evaluated to the previous expression in
     * expressionHistory if the index is within range.
     * 
     * @return true if expression was set
     */
    public static boolean previousHistory ()
    {
        if (!isHistoryIndexValid(myHistoryIndex - 1)) return false;
        setExpression(expressionHistory.get(--myHistoryIndex));
        return true;
    }


    /**
     * Sets the expression to be evaluated to the next expression in
     * expressionHistory if the index is within range.
     * 
     * @return true if expression was set
     */
    public static boolean nextHistory ()
    {
        if (!isHistoryIndexValid(myHistoryIndex + 1)) return false;
        setExpression(expressionHistory.get(++myHistoryIndex));
        return true;
    }


    /**
     * Resets current history index. Called each time a new expression (not in
     * history) is evaluated.
     */
    public static void resetHistoryIndex ()
    {
        myHistoryIndex = expressionHistory.size();
    }


    /**
     * @return String with history token, index, and expression at index.
     */
    public static String getHistoryInfo ()
    {
        return historyToken + "" + (myHistoryIndex + 1) + ": " + currExpression;
    }


    /**
     * Called if a parse error occurred, which will prevent the current string
     * from being added to history.
     */
    public static void setError ()
    {
        parseError = true;
    }
}
