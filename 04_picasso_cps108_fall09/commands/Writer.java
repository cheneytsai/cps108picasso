package commands;

import javax.swing.JFileChooser;
import model.Pixmap;




public class Writer extends Command
{
    private static final JFileChooser ourChooser = new JFileChooser(System.getProperties().getProperty("user.dir"));


    public Writer ()
    {
        super("Save");
    }


    public void execute (Pixmap target)
    {
        String fileName = getFileName();
        if (fileName != null)
        {
            target.write(fileName);
        }
    }


    protected String getFileName ()
    {
        int response = ourChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION)
        {
            return ourChooser.getSelectedFile().getPath();
        }
        return null;
    }
}
