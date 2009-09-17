import java.io.InputStreamReader;
import java.util.Scanner;

import arithmetica.ArithmeticaException;
import arithmetica.Parser;

/**
 * Repeatedly prompts the user for expressions to parse and evaluate.
 * 
 * This style of interaction is called the read-eval-print loop and forms the
 * basis of most interactive programming environments.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, constants)
 * @author Michael Yu
 */
public class Main {
    private static final String COMMENT = "#";
    public static final String VERSION = "0.1";
    public static final String TITLE = "Arithmetica";
    public static final String EXIT_COMMAND = ".";
    public static final String PROMPT = "-> ";

    public static void main(String[] args) {
        Scanner input = new Scanner(new InputStreamReader(System.in));
        Parser parser = new Parser();
        int numExpressions = 1;

        System.out.println("Welcome to " + TITLE + " " + VERSION);
        System.out.print(numExpressions + PROMPT);
        while (input.hasNext()) {
            String line = input.nextLine();
            if (line == null || line.equals(EXIT_COMMAND)) {
                break;
            } else {
                line = line.trim();
                if (line.length() == 0 || line.startsWith(COMMENT))
                    ;
                else {
                    try {
                        int i = parser.makeExpression(line);
                        System.out.println(line + " -> " + i);
                        numExpressions++;
                        System.out.print(numExpressions + PROMPT);
                    } catch (ArithmeticaException e) {
                        System.out.println("Invalid expression: " + line
                                + "\n --- " + e.getMessage());
                        parser.clearStack();
                    }
                }
            }
        }
    }
}
