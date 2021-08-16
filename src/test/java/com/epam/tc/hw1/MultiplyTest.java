package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MultiplyTest extends BeforeAfter {

    @Test(dataProviderClass = DataProviders.class,
          dataProvider = "Correct data for multiply",
          groups = {"DivMultiplyOperations"})
    public void multiTest(double num1, double num2) {
        double actual = calculator.mult(num1, num2);
        double expected = 25;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }
}
