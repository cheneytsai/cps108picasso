package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import model.Expression;
import commands.InputHandler;
import commands.Reader;
import commands.Evaluater;
import commands.Writer;


@SuppressWarnings("serial")
public class Frame extends JFrame
{
    InputHandler handler;
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");
    
    public Frame (String title, Dimension size)
    {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        handler = new InputHandler();
        
        //FileMenu menu = new FileMenu(handler);
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        setJMenuBar(result);
        
        // create GUI components
        Canvas canvas = new Canvas(this);
        canvas.setSize(size);

        // add commands to test here
        ButtonPanel commands = new ButtonPanel(canvas);
        JComboBox expressionChooser = new JComboBox();
        for (Expression expr : Expression.values())
        {
            expressionChooser.addItem(expr);
        }
        commands.add(new Reader());
        commands.add(new Evaluater(expressionChooser));
        commands.add(expressionChooser);
        commands.add(new Writer());

        //TextPanel textpanel = new TextPanel(canvas);
        TextPanel textpanel = new TextPanel(canvas, handler);
        
        // add our container to Frame and show it
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(commands, BorderLayout.NORTH);
        getContentPane().add(textpanel, BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Create the file menu for the game.
     */
    protected JMenu makeFileMenu ()
    {
        JMenu result = new JMenu(myResources.getString("FileMenu"));

        result.add(new AbstractAction(myResources.getString("OpenCommand"))
        {
            public void actionPerformed (ActionEvent ev)
            {
                //IMPLEMENT
            }
        });
        result.add(new AbstractAction(myResources.getString("HistoryCommand"))
        {
            public void actionPerformed (ActionEvent ev)
            {
                handler.openHistoryWindow();
            }
        });
        result.add(new AbstractAction(myResources.getString("QuitCommand"))
        {
            public void actionPerformed (ActionEvent ev)
            {
                System.exit(0);
            }
        });
        return result;
    }
}
