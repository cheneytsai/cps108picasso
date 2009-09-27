package picasso;
import tokens.*;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;


import tokens.Token;
import tokens.TokenHandler;



public class PicassoParser {
    
    private Scanner myScanner;
    private Stack<Token> myOperators = new Stack<Token>();
    private Stack<Token> myOperands = new Stack<Token>();
    private EvaluatableToken myCurrentExpression;
    private static ResourceBundle myResources = ResourceBundle.getBundle("resources.OrderOfOperations");
    
    protected String addSpaces(String infix)
    {
        StringBuilder build = new StringBuilder(infix);
        for (int k = 0; k < build.length(); k++)
        {
            String s = build.charAt(k) + "";
            if (myResources.containsKey(s))
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
                if (!(e instanceof OpenGroup)) {
                    if (e instanceof CloseGroup) {
                        Token op = myOperators.pop();
                        while (!(op instanceof OpenGroup)) {
                            handleOperator((EvaluatableToken) op);
                            op = myOperators.pop();
                        }
                    }

                    else {
                        while (myOperators.size() > 0
                                && myOperators.peek().getOrderOfOperation() >= e
                                        .getOrderOfOperation()) {
                            Token op = myOperators.pop();
                            // convert operator into expression
                            handleOperator((EvaluatableToken) op);
                        }
                    }
                }
                if (!(e instanceof CloseGroup)) {
                    myOperators.push(e);
                }
            }
        }

        // resolve any remaining operators
        while (myOperators.size() > 0) {
            Token op = myOperators.pop();
            // convert operator into expression
            handleOperator((EvaluatableToken )op);
        }
        
        if (myOperands.size() == 1) {
            myCurrentExpression = (EvaluatableToken) myOperands.pop();
            
        } else {
            System.out.println(myOperands.size());
            clearStack();
            throw new PicassoException("ill-formatted expression");
        }
              
    }

    /**
     * Takes an operator and handles the stack accordingly
     * 
     * @param op
     */
    private void handleOperator(EvaluatableToken op) {
        if (!(op instanceof EvaluatableToken))
        {
            throw new PicassoException("Ill-formatted expression");
        }
        if (myOperands.size() < op.getNumOperands())
            throw new PicassoException(
                    "Not enough operands to operate on: " + op.getOperation()
                            + " " + myOperands.size());

        for (int k = 0; k < op.getNumOperands(); k++) {
            op.addOperand((EvaluatableToken) myOperands.pop());
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
    
    public double[] evaluate()
    {
        return myCurrentExpression.evaluate();
    }
}
