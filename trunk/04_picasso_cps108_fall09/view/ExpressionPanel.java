package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.Pixmap;
import util.NamedCommand;
import util.ThreadedCommand;
import util.Command;
import view.commands.Evaluate;
import view.commands.Preview;


/**
 * The collection of commands to apply to the active image.
 * 
 * @author Jimmy Shedlick
 */
@SuppressWarnings("serial")
public class ExpressionPanel extends JPanel
{
    private Canvas myView;
    private JTextField inputField;
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");


    public ExpressionPanel (Canvas view)
    {
        myView = view;
        makePanel();
    }
    
    /**
     * Add the given Command as a button with the given name.
     */
    public void add (String name, final Command<Pixmap> action)
    {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent e)
                {
                    InputHandler.setExpression(inputField.getText());
                    action.execute(myView.getPixmap());
                }
            });
        add(button);
    }
    
    /**
     * Add the given Command as a button.
     */
    public void add (NamedCommand<Pixmap> action)
    {
        add(action.getName(), action);
    }

    public void makePanel ()
    {
        inputField = new JTextField(30);

        this.setBorder(BorderFactory.createTitledBorder(myResources.getString("ExpressionTitle")));
        this.add(inputField, BorderLayout.CENTER);

        add(myResources.getString("EvaluateCommand"), new ThreadedCommand<Pixmap>(new Evaluate(), myView));
        add(myResources.getString("PreviewCommand"), new ThreadedCommand<Pixmap>(new Preview(), myView));
        
    }
}
