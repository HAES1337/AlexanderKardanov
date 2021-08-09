package tc;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Correct data for sum")
    public Object[][] correctDataSum() {
        return new Object[][] {{3, 3}};
    }

    @DataProvider(name = "Correct data for sub")
    public Object[][] correctDataSub() {
        return new Object[][] {{3, 3}};
    }

    @DataProvider(name = "Correct data for multiply")
    public Object[][] correctDataMultiply() {
        return new Object[][] {{3, 3}};
    }

    @DataProvider(name = "Correct data for div")
    public Object[][] correctDataDiv() {
        return new Object[][] {{3, 3}};
    }
}
