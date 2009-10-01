package picasso;

import tokens.*;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;

import tokens.Token;
import tokens.TokenHandler;

/**
 * PicassoParser.java
 * 
 * @author Jimmy Shedlick, Cheney Tsai, Michael Yu
 * 
 */

public class PicassoParser
{

    private Scanner myScanner;
    private Stack<Token> myOperators = new Stack<Token>();
    private Stack<Token> myOperands = new Stack<Token>();
    private EvaluatableToken myCurrentExpression;
    private static ResourceBundle myResources = ResourceBundle
            .getBundle("resources.Preprocessor");

    protected String preProcess(String infix)
    {
        StringBuilder build = new StringBuilder();
        for (int k = 0; k < infix.length(); k++)
        {
            String s = infix.charAt(k) + "";
            if (myResources.containsKey(s))
            {
                String insert = myResources.getString(s);
                build.append(" ");
                if (insert.equals("Image"))
                {
                    infix = parseImageFile(infix, build, k + 1);
                    k = -1;
                } else
                {
                    build.append(insert);
                }
            } else
            {
                build.append(s);
            }
        }
        return build.toString();
    }

    private String parseImageFile(String infix, StringBuilder build, int index)
    {
        int imageEnd = infix.indexOf(myResources.getString("MarkImage"), index);
        String sub = infix.substring(index, imageEnd);
        build.append(ImageHandler.addImage(sub));
        infix = infix.substring(imageEnd + 1);
        return infix;
    }

    public void makeExpression(String infix)
    {
        myScanner = new Scanner(preProcess(infix));

        while (myScanner.hasNext())
        {
            String token = myScanner.next();
            Token e = TokenHandler.getExpression(token);
            if (e.getOrderOfOperation() == 0)
            {
                myOperands.push(e);
            }
            // operator -- convert previous higher order operators before push
            else
            {
                if (!(e instanceof OpenGroup))
                {
                    if (e instanceof CloseGroup)
                    {
                        Token op = myOperators.pop();
                        while (!(op instanceof OpenGroup))
                        {
                            handleOperator(op);
                            op = myOperators.pop();
                        }
                    }

                    else
                    {
                        while (myOperators.size() > 0
                                && myOperators.peek().getOrderOfOperation() >= e
                                        .getOrderOfOperation())
                        {
                            Token op = myOperators.pop();
                            // convert operator into expression
                            handleOperator(op);
                        }
                    }
                }
                if (!(e instanceof CloseGroup))
                {
                    myOperators.push(e);
                }
            }
        }
        // resolve any remaining operators
        while (myOperators.size() > 0)
        {
            Token op = myOperators.pop();
            // convert operator into expression
            handleOperator(op);
        }

        if (myOperands.size() == 1)
        {
            myCurrentExpression = (EvaluatableToken) myOperands.pop();

        } else
        {
            clearStack();
            throw new PicassoException("ill-formatted expression");
        }

    }

    /**
     * Takes an operator and handles the stack accordingly
     * 
     * @param op
     */
    private void handleOperator(Token operator)
    {
        if (!(operator instanceof EvaluatableToken))
        {
            return;
        }
        EvaluatableToken op = (EvaluatableToken) operator;
        if (myOperands.size() < op.getNumOperands())
        {
            clearStack();
            throw new PicassoException("Not enough operands to operate on: "
                    + op.getOperation() + " " + myOperands.size());
        }
        for (int k = 0; k < op.getNumOperands(); k++)
        {
            op.addOperand((EvaluatableToken) myOperands.pop());
        }
        myOperands.push(op);
    }

    /**
     * Clears the operator and operand stacks
     */
    public void clearStack()
    {
        myOperands.clear();
        myOperators.clear();
    }

    public double[] evaluate()
    {
        return myCurrentExpression.evaluate();
    }
}
