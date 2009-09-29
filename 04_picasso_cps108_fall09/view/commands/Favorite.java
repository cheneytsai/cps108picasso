package view.commands;

import util.Command;
import view.InputHandler;
import model.Pixmap;


/**
 * An abstract command with a name (e.g., to display on a button)
 * 
 * @author Robert C Duvall
 */
public class Favorite extends ExpressionCommand implements Command<Pixmap>
{

    public void execute (Pixmap target) {

        InputHandler.addToFavorites();
    }

}
