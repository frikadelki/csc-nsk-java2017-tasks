package org.csc.nsk.java2017.impl.EkaterinaValeeva.task02;

import org.csc.nsk.java2017.task02.BadSyntaxException;
import org.csc.nsk.java2017.task02.CalculationException;
import org.csc.nsk.java2017.task02.Calculator;

import java.util.*;

public class Calc implements Calculator {

    private int pos;
    private String expression;
    private final List<String> supportedFunctions;

    public Calc() {
        this.pos = 0;
        supportedFunctions = Arrays.asList("sin", "cos", "abs");
    }

    private String getFuncName() {
        int startPos = pos;
        while ((pos < this.expression.length()) && (Character.isLetter(this.expression.charAt(pos))))
            pos++;
        String func = this.expression.substring(startPos, pos);
        if (supportedFunctions.contains(func))
            return func;
        else
            throw new BadSyntaxException("Wrong function name at " + pos-- + "\n Supported functions: " + supportedFunctions.toString());
    }

    private boolean isCharFromDouble(char ch) {
        return ((ch >= '0') && (ch <= '9')) || (ch == '.');
    }

    private double getNumber() {
        int startPos = pos;
        while (pos < this.expression.length() && isCharFromDouble(expression.charAt(pos))) //parse the base
            pos++;

        if (consumeToken('e')) { //scientific notation
            if (!consumeToken('-')) {
                //skip sign as the scientific notation also allows numbers like ##e#
                //the current position is  moved inside the consumeToken method
                //but here do nothing
                consumeToken('+');
            }

            if ((pos < this.expression.length() && isCharFromDouble(expression.charAt(pos)) && (expression.charAt(pos) != '.'))) { //parse the exponent
                while (pos < this.expression.length() && isCharFromDouble(expression.charAt(pos)))
                    pos++;
            } else
                throw new BadSyntaxException("Wrong number format at " + startPos);
        }

        try {
            return Double.parseDouble(this.expression.substring(startPos, pos));
        } catch (Exception ex) {
            throw new BadSyntaxException("Wrong number format at " + startPos);
        }
    }

    private double callFunction(String name, double argument) {
        double result;
        switch (name) {
            case "sin":
                result = Math.sin(argument);
                break;
            case "cos":
                result = Math.cos(argument);
                break;
            case "abs":
                result = Math.abs(argument);
                break;
            default:
                throw new InternalError("Unexpected function");
        }
        return result;
    }

    private void checkResultNaNOrInf(double result) {
        if (!Double.isFinite(result))
            throw new CalculationException("NaN or INFINITY appeared as a result of the calculation step");
    }

    private boolean consumeToken(char ch) {
        if (pos < this.expression.length()) {
            while (Character.isWhitespace(expression.charAt(pos))) //skip whitespaces
                pos++;
            if (ch == expression.charAt(pos)) {
                pos++;
                return true;
            }
        }
        return false;
    }

    private double calcExpression() {
        double term = calcTerm();
        while (true) {
            if (consumeToken('-'))
                term -= calcTerm();
            else if (consumeToken('+'))
                term += calcTerm();
            else
                return term;
        }
    }

    private double calcTerm() throws CalculationException {
        double factor = calcFactor();

        while (true) {
            if (consumeToken('*'))
                factor *= calcFactor();
            else if (consumeToken('/')) {
                double divisor = calcFactor();
                if (divisor != 0)
                    factor /= divisor;
                else
                    throw new CalculationException("Division by zero!");
            } else if (consumeToken('^'))
                factor = Math.pow(factor, calcFactor());
            else {
                checkResultNaNOrInf(factor);
                return factor;
            }
        }
    }

    private double calcFactor() {
        if (consumeToken('+'))
            return calcFactor();
        else if (consumeToken('-'))
            return -calcFactor();

        double result;
        if (consumeToken('(')) {
            result = calcExpression();
            consumeToken(')');
        }

        else if ((pos < expression.length()) && (Character.isLetter(expression.charAt(pos)))) {
            String func = getFuncName();
            result = calcFactor();
            result = callFunction(func, result);
        } else if ((pos < expression.length()) && (isCharFromDouble(expression.charAt(pos)))) {
            result = getNumber();
        } else
            throw new BadSyntaxException("Incorrect expression syntax at  " + (pos - 1));

        return result;
    }

    @Override
    public double calculate(String expression) throws BadSyntaxException, CalculationException {
        this.expression = expression.toLowerCase(Locale.ENGLISH).replaceAll("\\s", "");

        return calcExpression();
    }
}
