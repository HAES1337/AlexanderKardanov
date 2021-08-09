package tc;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.Operations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tc.DataProviders;

public class MultiplyTest {

    private Operations operations;

    @BeforeMethod(groups = {"DivMultiplyOperations"})
    public void before() {
        operations = new Operations();
    }

    @Test(dataProviderClass = DataProviders.class,
          dataProvider = "Correct data for multiply",
          groups = {"DivMultiplyOperations"})
    public void multiTest(double num1, double num2) {
        double actual = operations.mult(num1, num2);
        double expected = 9;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }

    @AfterMethod(groups = {"DivMultiplyOperations"})
    public void after() {
        operations = null;
    }
}
