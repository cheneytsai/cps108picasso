package view.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import view.InputHandler;
import model.Pixmap;


public class ExpressionReader extends ExpressionCommand
{
 // only one dialog box needed for an application
    private static final JFileChooser ourChooser = 
        new JFileChooser(System.getProperties().getProperty("user.dir"));
    // what kind of dialog to open, see JFileChooser constants
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
                System.out.println(InputHandler.getExpression());
                InputHandler.addToHistory();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}
