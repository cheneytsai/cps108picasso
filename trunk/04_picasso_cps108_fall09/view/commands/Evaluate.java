package view.commands;

import util.Command;
import view.InputHandler;
import model.Pixmap;

/**
 * Evaluate.java
 * 
 * An abstract command which can be evaluated.
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
public class Evaluate extends EvaluatableCommand implements Command<Pixmap>
{

    public void execute(Pixmap target)
    {

        super.execute(target);
        InputHandler.addToHistory();
        InputHandler.resetHistoryIndex();
    }

}
