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
    private Scanner testInput;
    private Scanner testResults;
    
    public void setUp()
    {
        parse = new PicassoParser();
    }
    
    private void initializeScanner(String fileName) throws FileNotFoundException
    {
        testInput = new Scanner(new File("testdata\\" + fileName + ".in"));
        testResults = new Scanner(new File("testdata\\" + fileName + "_results.in"));
    }
    
    private void isEqual(double arg0, double arg1)
    {
        assertTrue(Math.abs(arg0 - arg1) < MARGIN_OF_ERROR);
    }
    
    public void testAddSpaces() throws FileNotFoundException
    {
        initializeScanner("AddSpaces");
        while (testInput.hasNext())
        {
            assertEquals(parse.stringFormat(testInput.nextLine()), testResults.nextLine());
        }
    }
    
    public void testX() throws FileNotFoundException
    {
        initializeScanner("XY"); 
        int i = testInput.nextInt();
        Dimension size = new Dimension(i, i);
        VarX x = new VarX();
        while (testInput.hasNext())
        {
            double[] d = x.evaluate(testInput.nextInt(), 0, size);
            double result = testResults.nextDouble();

                isEqual(result, d[0]);
        }       
    }
    
    public void testY() throws FileNotFoundException
    {
        initializeScanner("XY");      
        VarY y = new VarY();
        int i = testInput.nextInt();
        Dimension size = new Dimension(i, i);
        while (testInput.hasNext())
        {
            double[] d = y.evaluate(0, testInput.nextInt(), size);
            isEqual(testResults.nextDouble(), d[0]);

        }
    }
    public void testAddition() throws FileNotFoundException
    {
        initializeScanner("Addition");
        while (testInput.hasNextLine())
        {
            String str = testInput.nextLine();
            parse.makeExpression(str);
            int d = testInput.nextInt();
            Dimension size = new Dimension(d, d);
            int count = testInput.nextInt();
            for (int k = 0; k < count; k++)
            {
                double[] result = parse.evaluate(testInput.nextInt(), testInput.nextInt(), size);
                isEqual(testResults.nextDouble(), result[0]);
            }
            testInput.nextLine();
        }
        
        
    }
}
