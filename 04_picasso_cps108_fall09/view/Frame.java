package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import util.ThreadedCommand;
import model.Pixmap;
import view.commands.ExpressionReader;
import view.commands.ViewFavorites;
import view.commands.Reader;
import view.commands.Writer;


/**
 * Frame extends JFrame to create the main window, and adds buttons which
 * perform evaluations.
 */
@SuppressWarnings("serial")
public class Frame extends JFrame
{
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");


    public Frame (String title, Dimension size)
    {
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas canvas = new Canvas(this);
        canvas.setSize(size);

        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu(canvas));
        setJMenuBar(result);

        ExpressionPanel textpanel = new ExpressionPanel(canvas);

        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(textpanel, BorderLayout.SOUTH);
        pack();
    }


    /**
     * Create the file menu for the frame.
     * 
     * @param The canvas to be operated on.
     */
    protected JMenu makeFileMenu (Canvas view)
    {
        FileMenu result = new FileMenu(myResources.getString("FileMenu"), view);

        result.add(myResources.getString("OpenImageCommand"), new Reader());
        result.add(myResources.getString("OpenExpressionCommand"),
                   new ThreadedCommand<Pixmap>(new ExpressionReader(), view));
        result.add(myResources.getString("SaveCommand"), new Writer());
        result.add(myResources.getString("FavoritesCommand"),
                   new ThreadedCommand<Pixmap>(new ViewFavorites(), view));
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
