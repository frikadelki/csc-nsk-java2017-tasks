/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

import org.csc.nsk.java2017.impl.EkaterinaValeeva.task02.Calc;
import org.csc.nsk.java2017.impl.frikadelki.task02.DummyCalculator;

final class CalculatorFactory {
    static Calculator makeCalculator() {
        // TODO (task02): replace this with your calculator instance creation
        return new Calc();
    }

    private CalculatorFactory() {
    }
}
