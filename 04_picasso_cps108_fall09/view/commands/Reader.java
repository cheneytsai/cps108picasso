package view.commands;

import javax.swing.JFileChooser;
import util.FileCommand;
import model.Pixmap;


/**
 * Open the chosen file.
 * 
 * @author Robert C Duvall
 */
public class Reader extends FileCommand<Pixmap>
{
    public Reader ()
    {
        super(JFileChooser.OPEN_DIALOG);
    }


    public void execute (Pixmap target)
    {
        String fileName = getFileName();
        if (fileName != null)
        {
            target.read(fileName);
        }
    }
}
