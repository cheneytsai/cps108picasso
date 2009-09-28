import java.awt.Dimension;

import tokens.TokenHandler;
import view.Frame;


/**
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main
{
    public static final Dimension SIZE = new Dimension(800, 600);
    public static final String TITLE = "PICASSO!";


    public static void main (String[] args)
    {
        TokenHandler.tokenMapGenerator();
        Frame frame = new Frame(TITLE, SIZE);
        frame.setVisible(true);
    }
}
