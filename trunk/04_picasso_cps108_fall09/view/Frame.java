package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import model.Expression;
import commands.Reader;
import commands.Evaluater;
import commands.Writer;


@SuppressWarnings("serial")
public class Frame extends JFrame
{
    public Frame (String title, Dimension size)
    {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // create GUI components
        Canvas canvas = new Canvas(this);
        canvas.setSize(size);

        // add commands to test here
        ButtonPanel commands = new ButtonPanel(canvas);
        JComboBox expressionChooser = new JComboBox();
        for (Expression expr : Expression.values())
        {
            expressionChooser.addItem(expr);
        }
        commands.add(new Reader());
        commands.add(new Evaluater(expressionChooser));
        commands.add(expressionChooser);
        commands.add(new Writer());

        TextPanel textpanel = new TextPanel(canvas);
        
        // add our container to Frame and show it
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(commands, BorderLayout.NORTH);
        getContentPane().add(textpanel, BorderLayout.SOUTH);
        pack();
    }
}
