package util;

import java.awt.Dimension;

public enum FrameDimensions
{
    FRAME_LARGE
    {
        public Dimension size ()
        {
            return new Dimension(800, 600);
        }
    },
    FRAME_MEDIUM
    {
        public Dimension size ()
        {
            return new Dimension(600, 450);
        }
    },
    FRAME_SMALL
    {
        public Dimension size ()
        {
            return new Dimension(400, 300);
        }
    };
    
    abstract public Dimension size ();
}
