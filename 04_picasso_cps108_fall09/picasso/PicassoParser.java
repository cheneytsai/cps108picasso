package picasso;
import java.awt.Dimension;
import java.util.Scanner;
import java.util.Stack;


import tokens.Token;
import tokens.TokenHandler;

import model.RGBColor;

public class PicassoParser {
    
    private Scanner myScanner;
    private Stack<Token> myOperators = new Stack<Token>();
    private Stack<Token> myOperands = new Stack<Token>();
    private Token myCurrentExpression;
    
    protected String stringFormat(String infix)
    {
        StringBuilder build = new StringBuilder(infix);
        for (int k = 0; k < build.length(); k++)
        {
            char c = build.charAt(k);
            if (c == ',' || c == ')' || c == '(')
            {
                build.insert(k+1, ' ');
                build.insert(k, ' ');
                k++;
            }
        }
        return build.toString();
    }
    
    public void makeExpression(String infix) {
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
        
        if (myOperands.size() == 1) {
            myCurrentExpression = myOperands.pop();
            
        } else {
            myOperands.clear();
            throw new PicassoException("ill-formatted expression");
        }
              
    }

    /**
     * Takes an operator and handles the stack accordingly
     * 
     * @param op
     */
    private void handleOperator(Token op) {
        if (myOperands.size() < op.getNumOperands())
            throw new PicassoException(
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
    
    public double[] evaluate(int x, int y, Dimension size)
    {
        return myCurrentExpression.evaluate(x, y, size);
    }
}
