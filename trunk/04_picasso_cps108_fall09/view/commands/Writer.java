package view.commands;

import javax.swing.JFileChooser;
import util.FileCommand;
import model.Pixmap;


/**
 * Save the chosen file.
 * 
 * @author Robert C Duvall
 */
public class Writer extends FileCommand<Pixmap>
{
    public Writer ()
    {
        super(JFileChooser.SAVE_DIALOG);
    }


    public void execute (Pixmap target)
    {
        String fileName = getFileName();
        if (fileName != null)
        {
            target.write(fileName);
        }
    }
}
