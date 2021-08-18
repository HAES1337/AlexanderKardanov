package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBeforeAfter {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        webDriver.close();
    }
}
