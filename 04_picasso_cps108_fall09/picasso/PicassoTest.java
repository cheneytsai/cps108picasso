package picasso;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tokens.*;

import junit.framework.TestCase;

public class PicassoTest extends TestCase {
    
    public static final double MARGIN_OF_ERROR = .000001;
    private PicassoParser parse;
    
    public void setUp()
    {
        parse = new PicassoParser();
    }
    
    public void testParser()
    {
        PicassoParser parse = new PicassoParser();
        String str = parse.stringFormat("abc(d");
        assertEquals(str, "abc ( d");
        str = parse.stringFormat("(aa,,aa )aa()a");
        assertEquals(str, " ( aa ,  , aa  ) aa (  ) a");
    }
    
    public void testXY() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("testdata\\XY.in"));
        Scanner scan2 = new Scanner(new File("testdata\\XY_results.in"));        
        int i = scan.nextInt();
        Dimension size = new Dimension(i, i);
        VarX x = new VarX();
        while (scan.hasNext())
        {
            double[] d = x.evaluate(scan.nextInt(), 0, size);
            double result = scan2.nextDouble();

                assertTrue(Math.abs(result - d[0]) < MARGIN_OF_ERROR);
        }

        scan = new Scanner(new File("testdata\\XY.in"));
        scan2 = new Scanner(new File("testdata\\XY_results.in"));        
        VarY y = new VarY();
        i = scan.nextInt();
        while (scan.hasNext())
        {
            double[] d = y.evaluate(0, scan.nextInt(), size);
            double result = scan2.nextDouble();

                assertTrue(Math.abs(result - d[0]) < MARGIN_OF_ERROR);

        }
    }
    
    public void testAddition() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("testdata\\Addition.in"));
        while (scan.hasNextLine()){
            parse.makeExpression(scan.nextLine());
            int i = scan.nextInt();
            for (int k = 1; k <= i; k ++)
            {
                for (int j = 1; j <= i; j ++)
                {
                    double[] d = parse.evaluate(k , j, new Dimension(i, i));
                    double result = scan.nextDouble();
                    assertTrue(Math.abs(result - d[0]) < MARGIN_OF_ERROR);
                }
            }
        }

        
    }
}
