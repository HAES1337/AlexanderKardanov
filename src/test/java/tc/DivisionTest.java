package tc;

import static org.assertj.core.api.Assertions.assertThat;


import org.testng.annotations.Test;

public class DivisionTest extends BeforeAfter{



    @Test(dataProviderClass = DataProviders.class,
          dataProvider = "Correct data for div",
          groups = {"DivMultiplyOperations"})
    public void divTest(double num1, double num2) {
        double actual = calculator.div(num1, num2);
        double expected = 5;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }


}
