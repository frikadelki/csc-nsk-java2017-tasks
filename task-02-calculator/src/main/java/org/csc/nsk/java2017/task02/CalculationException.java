/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

public final class CalculationException extends RuntimeException {
    public CalculationException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CalculationException(final String message) {
        super(message);
    }
}