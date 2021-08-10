package tc;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubtractionTest {

    BeforeAfter beforeAfter = new BeforeAfter();



    @Test(dataProviderClass = DataProviders.class, dataProvider = "Correct data for sub", groups = {"AddSubOperations"})
    public void subTest(double num1, double num2) {
        beforeAfter.before();
        double actual = beforeAfter.calculator.sub(num1, num2);
        double expected = 2;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
        beforeAfter.after();
    }


}
