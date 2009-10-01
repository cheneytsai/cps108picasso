package view.commands;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import util.Command;
import util.ThreadedCommand;
import util.FrameDimensions;
import view.Canvas;
import view.InputHandler;
import model.Pixmap;


/**
 * An abstract command which can be evaluated. This command opens a new
 * Favorites window and evaluates on that Pixmap.
 * 
 * @author Jimmy Shedlick
 */
public class ViewFavorites extends EvaluatableCommand
    implements Command<Pixmap>
{
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");


    public void execute (Pixmap target)
    {
        FavoriteFrame frame =
            new FavoriteFrame(myResources.getString("FavoritesTitle"),
                              FrameDimensions.FRAME_LARGE.size());
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    class FavoriteFrame extends JFrame implements KeyListener
    {
        private Canvas myCanvas;
        private JTextField expressionNumber;
        private JTextField expressionName;
        private int index;


        public FavoriteFrame (String title, Dimension size)
        {
            setTitle(title);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLocation(100, 100);

            myCanvas = new Canvas(this);
            myCanvas.setSize(size);

            setFocusable(true);
            addKeyListener(this);

            getContentPane().add(myCanvas, BorderLayout.CENTER);
            getContentPane().add(makeMessage(), BorderLayout.SOUTH);

            index = 0;
            if (!InputHandler.isFavoriteIndexValid(index)) expressionName.setText(myResources.getString("NoFavorites"));
            else updatePane();
            pack();
        }


        //Add Keylistener so arrow keys scroll through favorites.
        public void keyPressed (KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) previous();
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) next();
        }


        public void keyReleased (KeyEvent e)
        {}


        public void keyTyped (KeyEvent e)
        {}


        /**
         * Create the message JPanel in the Favorites frame.
         */
        private JPanel makeMessage ()
        {
            JPanel result = new JPanel();

            expressionNumber = new JTextField(3);
            expressionNumber.setEditable(false);
            expressionName = new JTextField(20);
            expressionName.setEditable(false);

            JPanel messagePanel = new JPanel();
            messagePanel.setBorder(BorderFactory.createTitledBorder(myResources.getString("MessageTitle")));
            messagePanel.add(expressionNumber, BorderLayout.WEST);
            messagePanel.add(expressionName, BorderLayout.EAST);
            result.add(messagePanel, BorderLayout.WEST);

            JButton left = new JButton(myResources.getString("LeftCommand"));
            left.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent e)
                {
                    previous();
                }
            });
            left.addKeyListener(this);
            result.add(left, BorderLayout.CENTER);
            JButton right = new JButton(myResources.getString("RightCommand"));
            right.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent e)
                {
                    next();
                }
            });
            right.addKeyListener(this);
            result.add(right, BorderLayout.EAST);

            return result;
        }


        /**
         * Display the previous favorite expression
         */
        private void previous ()
        {
            if (InputHandler.isFavoriteIndexValid(index - 1))
            {
                index--;
                updatePane();
            }
        }


        /**
         * Display the next favorite expression
         */
        private void next ()
        {
            if (InputHandler.isFavoriteIndexValid(index + 1))
            {
                index++;
                updatePane();
            }
        }


        /**
         * Update the Pixmap and display while evaluating a different favorite
         * expression.
         */
        private void updatePane ()
        {
            expressionName.setText(InputHandler.getFavoriteExpression(index));
            expressionNumber.setText((index + 1) + "");
            new ThreadedCommand<Pixmap>(new EvaluatableCommand(), myCanvas).execute(myCanvas.getPixmap());
            myCanvas.refresh();
        }
    }

}
