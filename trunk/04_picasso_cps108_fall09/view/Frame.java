package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
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
        commands.add(new Reader());
        commands.add(new Evaluater());
        commands.add(new Writer());

        // add our container to Frame and show it
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(commands, BorderLayout.NORTH);
        pack();
    }
}
