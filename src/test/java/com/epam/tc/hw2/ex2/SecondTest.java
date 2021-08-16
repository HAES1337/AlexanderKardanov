package com.epam.tc.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void secondExTest() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        webDriver.findElement(By.id("user-icon"));
        WebElement loginForm = webDriver.findElement(By.id("user-icon"));
        loginForm.click();
        webDriver.findElement(By.id("name"));
        WebElement username = webDriver.findElement(By.id("name"));
        username.sendKeys("Roman");
        webDriver.findElement(By.id("password"));
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        webDriver.findElement(By.id("user-name"));
        WebElement userName = webDriver.findElement(By.id("user-name"));
        softly.assertThat(userName.getText()).isEqualTo("ROMAN IOVLEV");
        webDriver.findElement(By.cssSelector(".dropdown")).isDisplayed();
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown"));
        serviceOnTheHeader.click();
        WebElement differentElements = webDriver.findElement(By.xpath("//a[@href='different-elements.html']"));
        differentElements.click();
        WebElement water =
            webDriver.findElement(By.xpath("//label[@class='label-checkbox'][1]//input[@type='checkbox']"));
        water.click();
        WebElement wind =
            webDriver.findElement(By.xpath("//label[@class='label-checkbox'][3]//input[@type='checkbox']"));
        wind.click();
        WebElement selen =
            webDriver.findElement(By.xpath("//label[@class='label-radio'][4]//input[@type='radio']"));
        selen.click();
        WebElement colors =
            webDriver.findElement(By.className("colors"));
        colors.click();
        WebElement yellowColor = webDriver.findElement(By.xpath("//*[contains(text(),'Yellow')]"));
        yellowColor.click();
        selen.click();
        WebElement waterCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Water')]"));
        softly.assertThat(waterCheckBox.getText()).isEqualTo("Water: condition changed to true");
        WebElement windCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softly.assertThat(windCheckBox.getText()).isEqualTo("Wind: condition changed to true");
        WebElement selenRadioCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Selen')]"));
        softly.assertThat(selenRadioCheck.getText()).isEqualTo("metal: value changed to Selen");
        WebElement yellowColorCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Yellow')]"));
        softly.assertThat(yellowColorCheck.getText()).isEqualTo("Colors: value changed to Yellow");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
