package picasso;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Pixmap;

import tokens.*;

import junit.framework.TestCase;

public class PicassoTest extends TestCase {
    
    public static final double MARGIN_OF_ERROR = .000001;
    private PicassoParser parse;
    private PicassoParser parse2;
    private Scanner testInput;
    private Scanner testResults;
    
    public void setUp()
    {
        TokenHandler.tokenMapGenerator();
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
    
    public void testImageHandler() throws FileNotFoundException
    {
    }
    
    public void testAddSpaces() throws FileNotFoundException
    {
        initializeScanner("AddSpaces");
        while (testInput.hasNext())
        {
            assertEquals(parse.preProcess(testInput.nextLine()), testResults.nextLine());
        }
    }
    
    public void testConstant() throws FileNotFoundException
    {
        
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
                setCoordinates(testInput.nextInt(), testInput.nextInt(), size);
                double[] result = parse.evaluate();
                isEqual(testResults.nextDouble(), result[0]);
            }
            testInput.nextLine();
        }    
    }
    public void testAbsoluteVal() throws FileNotFoundException
    {
        initializeScanner("AbsoluteVal");
        while (testInput.hasNextLine())
        {
            String str = testInput.nextLine();
            String str2 = testResults.nextLine();
            parse.makeExpression(str);
            parse2.makeExpression(str2);
            Dimension size = new Dimension(5, 5);
            int count = 25;
            for (int k = 0; k < count; k++)
            {
                setCoordinates(testInput.nextInt(), testInput.nextInt(), size);
                double[] result = parse.evaluate();
                double[] result2 = parse2.evaluate();
                isEqual(result[0], result2[0]);
            }
        }    
    }    
    private void setCoordinates(int x, int y, Dimension size)
    {
        VariableHandler.setVariable("x", convertCoordinates(x, size.getWidth()));
        VariableHandler.setVariable("y", convertCoordinates(y, size.getHeight()));
    }
    
    private double convertCoordinates(int pixelCoords, double size)
    {
       return (pixelCoords / size) * 2 - 1;
    }
}
