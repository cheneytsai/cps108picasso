package commands;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import picasso.PicassoParser;
import view.Canvas;
import model.Pixmap;
import model.RGBColor;


public class InputHandler
{
    private static final int DELAY = 400;
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.English");
    private picasso.PicassoParser myParser;
    private Thread myPainter;
    private Thread myRenderer;
    private ArrayList<String> expressionHistory;
    private char historyToken = '$';
    private boolean isDone;

    public InputHandler ()
    {
        isDone = true;
        myParser = new PicassoParser();
        expressionHistory = new ArrayList<String>();
    }
    
    public void makeExpression (String inputString)
    {
        if (inputString.charAt(0) == historyToken)
        {
            showHistory(inputString.substring(1));
        }
        else
        {
            expressionHistory.add(inputString);
            myParser.makeExpression(inputString);
        }
    }


    public void showHistory (String expressionNumber)
    {
        int number = Integer.parseInt(expressionNumber);
        String expression = expressionHistory.get(number - 1);
        myParser.makeExpression(expression);
    }


    public void applyCommand (Canvas view)
    {
        if (isDone)
        {
            isDone = false;

            myRenderer = new Thread(new Renderer(view));
            myPainter = new Thread(new Painter(view));
            myRenderer.start();
            myPainter.start();
        }
        else
        {
            isDone = true;
        }
    }

    class Painter implements Runnable
    {
        private Canvas myView;

        public Painter (Canvas view)
        {
            myView = view;
        }

        public void run ()
        {
            try
            {
                while (!isDone)
                {
                    Thread.sleep(DELAY);
                    myView.refresh();
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    class Renderer implements Runnable
    {
        private Canvas myView;

        public Renderer (Canvas view)
        {
            myView = view;
        }

        public void run ()
        {
            execute(myView.getPixmap());
            myView.refresh();
            isDone = true;
        }
    }


    public void execute (Pixmap target)
    {
        Dimension size = target.getSize();
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                double[] colorArray = myParser.evaluate(imageX, imageY, size);
                RGBColor color =
                    new RGBColor(colorArray[0], colorArray[1], colorArray[2]);
                target.setColor(imageX, imageY, color.toJavaColor());
            }
        }
    }
    
    public void openHistoryWindow() {
        HistoryFrame frame =
            new HistoryFrame("PICASSO!", new Dimension(800, 600));
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    class HistoryFrame extends JFrame
    {
        private Canvas myCanvas;
        private JTextField expressionNumber;
        private JTextField expressionName;
        private int index;

        public HistoryFrame (String title, Dimension size)
        {
            setTitle(title);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(size);

            // create GUI components
            myCanvas = new Canvas(this);
            myCanvas.setSize(size);
            
            // add our container to Frame and show it
            getContentPane().add(myCanvas, BorderLayout.CENTER);
            getContentPane().add(makeMessage(), BorderLayout.SOUTH);
            
            index = 0;
            if(expressionHistory.size() == 0)
                expressionName.setText(myResources.getString("NoHistory"));
            else
                updatePane();
            pack();
        }
        
        protected JPanel makeMessage()
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
                    if(index == 0)
                        expressionName.setText(myResources.getString("NoHistory"));
                    else
                    {
                        index--;
                        updatePane();
                    }
                }
            });
            result.add(left, BorderLayout.CENTER);
            JButton right = new JButton(myResources.getString("RightCommand"));
            right.addActionListener(new ActionListener()
            {
                public void actionPerformed (ActionEvent e)
                {
                    if(index > expressionHistory.size() - 2)
                        expressionName.setText(myResources.getString("NoHistory"));
                    else
                    {
                    index++;
                    updatePane();
                    }
                }
            });
            result.add(right, BorderLayout.EAST);

            return result;
        }
        
        private void updatePane()
        {
            String expression = expressionHistory.get(index);
            myParser.makeExpression(expression);
            applyCommand(myCanvas);
            expressionNumber.setText((index + 1) + "");
            expressionName.setText(expression);
            myCanvas.refresh();
        }
    }

}
