package tc;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.Operations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tc.DataProviders;

public class DivisionTest {
    private Operations operations;

    @BeforeMethod(groups = {"DivMultiplyOperations"})
    public void before() {
        operations = new Operations();
    }

    @Test(dataProviderClass = DataProviders.class,
          dataProvider = "Correct data for div",
          groups = {"DivMultiplyOperations"})
    public void divTest(double num1, double num2) {
        Operations num = new Operations();
        double actual = operations.div(num1, num2);
        double expected = 1;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }

    @AfterMethod(groups = {"DivMultiplyOperations"})
    public void after() {
        operations = null;
    }
}
