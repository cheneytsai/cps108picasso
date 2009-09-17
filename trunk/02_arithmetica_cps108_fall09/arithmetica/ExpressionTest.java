package arithmetica;

import junit.framework.TestCase;
import java.io.*;
import java.util.*;
import Expressions.*;

/**
 * Test class
 * 
 * @author Michael
 * 
 */
public class ExpressionTest extends TestCase {

    /**
     * Tests to see if arithmetic operations +, -, /, *, (, ), % are working
     * properly
     * 
     * @throws Exception
     */
    public void testConstants() throws Exception {
        tester("constants");
    }

    /**
     * Tests to see if assignment is working properly
     * 
     * @throws Exception
     */
    public void testAssignment() throws Exception {
        tester("assignment");
    }

    /**
     * Tests to see if multiple argument, and single argument functions are
     * working properly
     * 
     * @throws Exception
     */
    public void testFunctions() throws Exception {
        tester("functions");
    }

    /**
     * Tests to see if negation operation is working properly
     * 
     * @throws Exception
     */
    public void testNegation() throws Exception {
        tester("negation_vars");
    }

    /**
     * Tests to see if history operations are working
     * 
     * @throws Exception
     */
    public void testHistory() throws Exception {
        TokenHandler.clearHistory();
        tester("history");
    }

    /**
     * Tests to see if some complicated expressions work
     * 
     * @throws Exception
     */
    public void testComplexExpressions() throws Exception {
        TokenHandler.clearHistory();
        tester("complex");
    }

    /**
     * Takes a file name and runs tests on that data
     * 
     * @param file
     * @throws Exception
     */
    public void tester(String file) throws Exception {
        Scanner scan = new Scanner(new File("testdata\\" + file + ".in"));
        Scanner scan2 = new Scanner(new File("testdata\\" + file
                + "_results.in"));
        Parser parse = new Parser();
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            assertEquals(parse.makeExpression(input), scan2.nextInt());
        }
    }
}
