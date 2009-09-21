package commands;

import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import model.Pixmap;




public class Writer extends Command
{
    private static final JFileChooser ourChooser = new JFileChooser(System.getProperties().getProperty("user.dir"));
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");

    public Writer ()
    {
        super(myResources.getString("SaveCommand"));
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
