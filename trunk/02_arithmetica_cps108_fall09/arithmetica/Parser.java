package arithmetica;

import java.util.*;
import Expressions.*;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions)
 */
public class Parser {
    /**
     * Converts the given string into expression tree for easier manipulation.
     * 
     * This is an implementation of Dijkstra's algorithm for converting infix to
     * postfix notation. It iterates through the infix version, adding operands
     * to end of one stack and keeping operators on another. When an operator is
     * encountered, all operators that have higher precedence (i.e., should be
     * evaluated first) are popped off operator stack with their corresponding
     * operands from the operand stack and combined into new operand. After the
     * input is exhausted, any remaining operators are popped similarly.
     * 
     * By giving grouping operators lower precedence than anything operator and
     * creating special case that prevents group opening operators from popping
     * previous operators off the stack, this algorithm can be adapted to give
     * such operators the effect of boosting the precedence of other operators.
     * 
     * @param infix
     *            space separated infix notation form of an expression
     * @return expression tree representing the given infix formula
     */
    private Scanner myScanner;
    private Stack<Token> myOperators = new Stack<Token>();
    private Stack<Token> myOperands = new Stack<Token>();

    /**
     * Produces an expression from a string
     * 
     * @param infix
     * @return
     */
    public int makeExpression(String infix) {
        myScanner = new Scanner(infix);

        while (myScanner.hasNext()) {
            String token = myScanner.next();
            Token e = TokenHandler.getExpression(token);
            if (e.getOrderOfOperation() == 0) {
                myOperands.push(e);
            }

            // operator -- convert previous higher order operators before push
            else {
                if (!e.isOpenGroup()) {
                    if (e.isCloseGroup()) {
                        Token op = myOperators.pop();
                        while (!op.isOpenGroup()) {
                            handleOperator(op);
                            op = myOperators.pop();
                        }
                    }

                    else {
                        while (myOperators.size() > 0
                                && myOperators.peek().getOrderOfOperation() >= e
                                        .getOrderOfOperation()) {
                            Token op = myOperators.pop();
                            // convert operator into expression
                            handleOperator(op);
                        }
                    }
                }
                if (!e.isCloseGroup()) {
                    myOperators.push(e);
                }
            }
        }

        // resolve any remaining operators
        while (myOperators.size() > 0) {
            Token op = myOperators.pop();
            // convert operator into expression
            handleOperator(op);
        }

        // all operators handled, should be only one operand left, the result
        if (myOperands.size() == 1) {
            Token t = myOperands.pop();
            int value = t.evaluate();
            TokenHandler.updateExpressionHistory(value);
            return value;
        } else {
            myOperands.clear();
            throw new ArithmeticaException("ill-formatted expression");
        }
    }

    /**
     * Takes an operator and handles the stack accordingly
     * 
     * @param op
     */
    private void handleOperator(Token op) {
        if (myOperands.size() < op.getNumOperands())
            throw new ArithmeticaException(
                    "Not enough operands to operate on: " + op.getOperation()
                            + " " + myOperands.size());

        for (int k = 0; k < op.getNumOperands(); k++) {
            op.addOperand(myOperands.pop());
        }
        myOperands.push(op);
    }

    /**
     * Clears the operator and operand stacks
     */
    public void clearStack() {
        myOperands.clear();
        myOperators.clear();
    }

}
