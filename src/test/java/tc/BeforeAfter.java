package tc;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BeforeAfter {
    Calculator calculator;

    @BeforeMethod
    public void before() {
        calculator = new Calculator();
    }

    @AfterMethod
    public void after() {
        calculator = null;
    }
}
