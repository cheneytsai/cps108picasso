package view.commands;

import util.Command;
import view.InputHandler;
import model.Pixmap;

/**
 * Favorite.java
 * 
 * An abstract command which can be evaluated.
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
public class Favorite extends EvaluatableCommand implements Command<Pixmap>
{

    public void execute(Pixmap target)
    {

        InputHandler.addToFavorites();
    }

}
