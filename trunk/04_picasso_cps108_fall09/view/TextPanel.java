package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import commands.InputHandler;


/**
 * The collection of commands to apply to the active image.
 * 
 * @author Jimmy Shedlick
 */
@SuppressWarnings("serial")
public class TextPanel extends JPanel
{
    private Canvas myView;
    private JTextField inputField;
    private static ResourceBundle myResources =
        ResourceBundle.getBundle("resources.English");
    private InputHandler myHandler;


    public TextPanel (Canvas view, InputHandler handler)
    {
        myView = view;
        myHandler = handler;
        makePanel();
    }


    public void makePanel ()
    {
        inputField = new JTextField(30);

        this.setBorder(BorderFactory.createTitledBorder(myResources.getString("ExpressionTitle")));
        this.add(inputField, BorderLayout.CENTER);

        JButton evaluate =
            new JButton(myResources.getString("EvaluateCommand"));
        evaluate.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                String s = inputField.getText();
                myHandler.makeExpression(s);
                myHandler.applyCommand(myView);
                //makeExpression();
                //applyCommand(myView);
            }
        });
        this.add(evaluate, BorderLayout.EAST);
        JButton preview = new JButton(myResources.getString("PreviewCommand"));
        preview.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                myHandler.makeExpression(inputField.getText());
                //makeExpression();
                PreviewFrame frame =
                    new PreviewFrame(myResources.getString("PreviewCommand"), new Dimension(400, 300));
                frame.setVisible(true);
                myHandler.applyCommand(frame.getView());
                //applyCommand(frame.getView());
                frame.getView().refresh();
            }
        });
        this.add(preview, BorderLayout.EAST);
    }

    class PreviewFrame extends JFrame
    {
        private Canvas myCanvas;

        public PreviewFrame (String title, Dimension size)
        {
            setTitle(title);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            // create GUI components
            myCanvas = new Canvas(this);
            myCanvas.setSize(size);

            // add our container to Frame and show it
            getContentPane().add(myCanvas, BorderLayout.CENTER);
            pack();
        }


        private Canvas getView ()
        {
            return myCanvas;
        }
    }
}
