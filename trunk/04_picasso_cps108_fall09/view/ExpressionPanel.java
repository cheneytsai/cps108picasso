package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import view.commands.EvaluatableCommand;
import view.commands.Favorite;
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
        inputField.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                InputHandler.setExpression(inputField.getText());
                new ThreadedCommand<Pixmap>(new Evaluate(), myView).execute(myView.getPixmap());
            }
        });
        
        KeyListener myKeyListener = new KeyListener()
        {
            public void keyPressed (KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    if(InputHandler.nextHistory()) {
                        new ThreadedCommand<Pixmap>(new EvaluatableCommand(), myView).execute(myView.getPixmap());
                        inputField.setText(InputHandler.getHistoryInfo());
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if(InputHandler.previousHistory()) {
                        new ThreadedCommand<Pixmap>(new EvaluatableCommand(), myView).execute(myView.getPixmap());
                        inputField.setText(InputHandler.getHistoryInfo());
                    }
                }
            }
            public void keyReleased (KeyEvent e)
            {
            }
            public void keyTyped (KeyEvent e)
            {
            }
        };
        inputField.addKeyListener(myKeyListener);

        this.setBorder(BorderFactory.createTitledBorder(myResources.getString("ExpressionTitle")));
        this.add(inputField, BorderLayout.CENTER);

        add(myResources.getString("EvaluateCommand"), new ThreadedCommand<Pixmap>(new Evaluate(), myView));
        add(myResources.getString("PreviewCommand"), new ThreadedCommand<Pixmap>(new Preview(), myView));
        add(myResources.getString("FavoriteCommand"), new ThreadedCommand<Pixmap>(new Favorite(), myView));
    }
}
