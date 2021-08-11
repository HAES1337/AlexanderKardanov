package tc;

import static org.assertj.core.api.Assertions.assertThat;


import org.testng.annotations.Test;

public class SubtractionTest extends BeforeAfter{




    @Test(dataProviderClass = DataProviders.class, dataProvider = "Correct data for sub", groups = {"AddSubOperations"})
    public void subTest(double num1, double num2) {
        double actual = calculator.sub(num1, num2);
        double expected = 2;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }


}
