package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import model.Pixmap;
import util.Command;
import util.NamedCommand;

/**
 * FileMenu.java
 * 
 * The collection of commands represented as AbstractActions that apply to the
 * active image.
 * 
 * @author Robert C Duvall
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 */
@SuppressWarnings("serial")
public class FileMenu extends JMenu
{
    private Canvas myView;

    /**
     * Create menu that will update the given view.
     */
    public FileMenu(String name, Canvas view)
    {
        super(name);
        myView = view;
    }

    /**
     * Add the given Command as a AbstractAction with the given name.
     */
    public void add(String name, final Command<Pixmap> action)
    {
        this.add(new AbstractAction(name)
        {
            public void actionPerformed(ActionEvent ev)
            {
                action.execute(myView.getPixmap());
                myView.refresh();
            }
        });
    }

    /**
     * Add the given Command as an AbstractAction.
     */
    public void add(NamedCommand<Pixmap> action)
    {
        add(action.getName(), action);
    }
}
