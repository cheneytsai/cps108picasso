package picasso;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Pixmap;

import tokens.*;

import junit.framework.TestCase;

public class PicassoTest extends TestCase {
    
    public static final double MARGIN_OF_ERROR = .00001;
    private PicassoParser parse;
    private PicassoParser parse2;
    private Scanner testInput;
    private Scanner testResults;
    
    public void setUp()
    {
        TokenHandler.tokenMapGenerator();
        parse = new PicassoParser();
        parse2 = new PicassoParser();
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
        initializeScanner("Image");
        while (testInput.hasNext())
        {
            assertEquals(ImageHandler.addImage(testInput.nextLine()), testResults.nextLine());
        }
    }  
    
    public void testPreProcess() throws FileNotFoundException
    {
        initializeScanner("PreProcess");
        ImageHandler.clearImages();
        while (testInput.hasNext())
        {
            assertEquals(parse.preProcess(testInput.nextLine()), testResults.nextLine());
        }
    }
    
    public void testConstant() throws FileNotFoundException
    {
        initializeScanner("Constants");
        while (testInput.hasNext())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(parse.evaluate()[0], testResults.nextDouble());
        }
    }
    
    public void testVariables() throws FileNotFoundException
    {
        initializeScanner("Variables");
        parse.makeExpression("x");
        while (testInput.hasNext())
        {
            VariableHandler.setVariable("x", testInput.nextDouble());
            isEqual(parse.evaluate()[0], testResults.nextDouble());
        }
    }
    
    public void testColor() throws FileNotFoundException
    {
        initializeScanner("Color");
        while (testInput.hasNext())
        {
            parse.makeExpression(testInput.nextLine());
            for (int k = 0; k < 3; k++)
            {
                isEqual(parse.evaluate()[k], testResults.nextDouble());                
            }
        }
    }
    
    public void testArithmetic() throws FileNotFoundException
    {
        initializeScanner("Arithmetic");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(parse.evaluate()[0], testResults.nextDouble());
        }    
    }
    
    public void testGrouping() throws FileNotFoundException
    {
        initializeScanner("Grouping");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(parse.evaluate()[0], testResults.nextDouble());
        }
    }
    public void testAbsoluteVal() throws FileNotFoundException
    {
        initializeScanner("AbsoluteVal");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            parse2.makeExpression(testResults.nextLine());    
            isEqual(parse.evaluate()[0], parse2.evaluate()[0]);
                
         }
            
    }    
    public void testTrig() throws FileNotFoundException
    {
        initializeScanner("Trig");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(testResults.nextDouble(), parse.evaluate()[0]);
        }    
    }
    public void testCeil() throws FileNotFoundException
    {
        initializeScanner("Ceil");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(testResults.nextDouble(), parse.evaluate()[0]);
        }    
    }
    public void testFloor() throws FileNotFoundException
    {
        initializeScanner("Floor");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(testResults.nextDouble(), parse.evaluate()[0]);
        }    
    }
    public void testClamp() throws FileNotFoundException
    {
        initializeScanner("Clamp");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(testResults.nextDouble(), parse.evaluate()[0]);
        }    
    }
    public void testWrap() throws FileNotFoundException
    {
        initializeScanner("Clamp");
        while (testInput.hasNextLine())
        {
            parse.makeExpression(testInput.nextLine());
            isEqual(testResults.nextDouble(), parse.evaluate()[0]);
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
