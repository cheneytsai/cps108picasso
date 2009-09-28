package view.commands;

import util.Command;
import view.InputHandler;
import model.Pixmap;


/**
 * An abstract command with a name (e.g., to display on a button)
 * 
 * @author Robert C Duvall
 */
public class Evaluate extends ExpressionCommand implements Command<Pixmap>
{

    public void execute (Pixmap target) {

        super.execute(target);
        InputHandler.addToHistory();
    }

}
