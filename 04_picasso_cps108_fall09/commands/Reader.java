package commands;

import javax.swing.JFileChooser;
import model.Pixmap;




public class Reader extends Command
{
    private static final JFileChooser ourChooser = new JFileChooser(System.getProperties().getProperty("user.dir"));


    public Reader ()
    {
        super("Open");
    }


    public void execute (Pixmap target)
    {
        String fileName = getFileName();
        if (fileName != null)
        {
            target.read(fileName);
        }
    }


    protected String getFileName ()
    {
        int response = ourChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION)
        {
            return ourChooser.getSelectedFile().getPath();
        }
        return null;
    }
}
