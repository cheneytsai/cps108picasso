package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import model.Pixmap;
import util.Command;
import util.NamedCommand;


/**
 * The collection of commands represented as buttons that apply to the active image.
 * 
 * @author Robert C Duvall
 */
@SuppressWarnings("serial")
public class FileMenu extends JMenu
{
    private Canvas myView;

    /**
     * Create panel that will update the given view.
     */
    public FileMenu (String name, Canvas view)
    {
        super(name);
        myView = view;
    }


    /**
    * Add the given Command as a button with the given name.
    */
   public void add (String name, final Command<Pixmap> action)
   {
       this.add(new AbstractAction(name)
       {
           public void actionPerformed (ActionEvent ev)
           {
               action.execute(myView.getPixmap());
               myView.refresh();
           }
       });
   }


   /**
    * Add the given Command as a button.
    */
   public void add (NamedCommand<Pixmap> action)
   {
       add(action.getName(), action);
   }
}
