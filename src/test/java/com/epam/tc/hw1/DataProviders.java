package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Correct data for sum")
    public static Object[][] correctDataSum() {
        return new Object[][] {{4, 2}};
    }

    @DataProvider(name = "Correct data for sub")
    public static Object[][] correctDataSub() {
        return new Object[][] {{7, 5}};
    }

    @DataProvider(name = "Correct data for multiply")
    public static Object[][] correctDataMultiply() {
        return new Object[][] {{5, 5}};
    }

    @DataProvider(name = "Correct data for div")
    public static Object[][] correctDataDiv() {
        return new Object[][] {{10, 2}};
    }
}
