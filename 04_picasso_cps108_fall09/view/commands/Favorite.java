package view.commands;

import util.Command;
import view.InputHandler;
import model.Pixmap;


/**
 * An abstract command which can be evaluated.
 * 
 * @author Jimmy Shedlick
 */
public class Favorite extends EvaluatableCommand implements Command<Pixmap>
{

    public void execute (Pixmap target) {

        InputHandler.addToFavorites();
    }

}
