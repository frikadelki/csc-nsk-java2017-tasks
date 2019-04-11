/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

import org.csc.nsk.java2017.utils.MathUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class CalculatorTests {
    @Test
    public void testOnePlusOne() {
        final Calculator calculator = CalculatorFactory.makeCalculator();
        assertEquals("One plus one should equal two.",
                2, calculator.calculate("1 + 1"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void testMore() {
        final Calculator calculator = CalculatorFactory.makeCalculator();
        assertEquals(0.90929742682, calculator.calculate("sin(2)"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test
    public void testMegaTrash(){
        final Calculator calculator = CalculatorFactory.makeCalculator();
        assertEquals(18000, calculator.calculate("sin(0) +abs( -3*4/2) * 3e+3"), MathUtils.DEFAULT_DOUBLE_EQ_DELTA);
    }

    @Test(expected = CalculationException.class)
    public void testImaginaryUnit() {
        final Calculator calculator = CalculatorFactory.makeCalculator();
        calculator.calculate("-1 ^ 0.5 +  195");
    }

    @Test(expected = CalculationException.class)
    public void testInfinity() {
        final Calculator calculator = CalculatorFactory.makeCalculator();
        calculator.calculate("10e300 * 10e+300");
    }
}
