package tc;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class AddictionTest extends BeforeAfter {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Correct data for sum", groups = {"AddSubOperations"})

    public void sumTest(double num1, double num2) {
        double actual = calculator.sum(num1, num2);
        double expected = 6;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }
}
