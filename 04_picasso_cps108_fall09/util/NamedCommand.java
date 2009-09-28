package util;



/**
 * An abstract command with a name (e.g., to display on a button)
 * 
 * @author Robert C Duvall
 */
public abstract class NamedCommand<T> implements Command<T>
{
    private String myName;


    public NamedCommand (String name)
    {
        myName = name;
    }


    /**
     * Returns the name of this command (displayed on the button used to
     * activate it)
     */
    public String getName ()
    {
        return myName;
    }
}
