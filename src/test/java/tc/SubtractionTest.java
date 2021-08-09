package tc;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.Operations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tc.DataProviders;

public class SubtractionTest {

    private Operations operations;

    @BeforeMethod(groups = {"AddSubOperations"})
    public void before() {
        operations = new Operations();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Correct data for sub", groups = {"AddSubOperations"})
    public void subTest(double num1, double num2) {
        double actual = operations.sub(num1, num2);
        double expected = 0;
        assertThat(actual).as("Addition was wrong").isEqualTo(expected);
    }

    @AfterMethod(groups = {"AddSubOperations"})
    public void after() {
        operations = null;
    }
}
