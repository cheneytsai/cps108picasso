package view.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import view.InputHandler;
import model.Pixmap;


/**
 * An abstract command which can be evaluated. This command opens a file to load
 * an expression to evaluate.
 * 
 * @author Jimmy Shedlick
 */
public class ExpressionReader extends EvaluatableCommand
{
    private static final JFileChooser ourChooser =
        new JFileChooser(System.getProperties().getProperty("user.dir"));
    private int myDialogType;


    public ExpressionReader ()
    {
        myDialogType = JFileChooser.OPEN_DIALOG;
    }


    /**
     * Returns the file chosen by the user.
     */
    protected String getFileName ()
    {
        ourChooser.setDialogType(myDialogType);
        int response = ourChooser.showDialog(null, null);
        if (response == JFileChooser.APPROVE_OPTION)
        {
            return ourChooser.getSelectedFile().getPath();
        }
        return null;
    }


    public void execute (Pixmap target)
    {
        String fileName = getFileName();
        if (fileName != null)
        {
            try
            {
                Scanner in = new Scanner(new File(fileName));
                String exp = in.nextLine();
                InputHandler.setExpression(exp);
                super.execute(target);
                InputHandler.addToHistory();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}
