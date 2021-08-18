package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractBeforeAfter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest extends AbstractBeforeAfter {
    WebDriverWait webDriverWait;
    SoftAssertions softly = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    static final String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    @Test
    public void secondExTest() {
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(EPAM_URL);
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        //Assert Browser title
        WebElement title = webDriver.findElement(By.name("main-title"));
        webDriverWait.until(ExpectedConditions.titleIs("Home Page"));
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //Assert performing login
        WebElement loginForm = webDriver.findElement(By.id("user-icon"));
        loginForm.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginForm));
        WebElement username = webDriver.findElement(By.id("name"));
        username.sendKeys("Roman");
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        softly.assertThat(webDriver.getCurrentUrl()).isEqualTo(EPAM_URL);
        //Assert User name in the left-top side of screen that user is loggined
        WebElement userNameLogged = webDriver.findElement(By.id("user-name"));
        userNameLogged.isDisplayed();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(userNameLogged, "ROMAN IOVLEV"));
        softly.assertThat(userNameLogged.getText()).isEqualTo("ROMAN IOVLEV");
        //Open through the header menu Service -> Different Elements Page
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown-toggle"));
        serviceOnTheHeader.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(serviceOnTheHeader));
        WebElement differentElements = webDriver.findElement(By.xpath("//a[@href='different-elements.html']"));
        differentElements.click();
        webDriverWait.until(ExpectedConditions.urlToBe(DIFFERENT_ELEMENTS_URL));
        softly.assertThat(webDriver.getCurrentUrl()).isEqualTo(DIFFERENT_ELEMENTS_URL);
        //Select checkboxes
        WebElement waterBox =
            webDriver.findElement(By.xpath("//*[text()[contains(.,'Water')]]"));
        waterBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(waterBox));
        WebElement windBox =
            webDriver.findElement(By.xpath("//*[text()[contains(.,'Wind')]]"));
        windBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(windBox));
        WebElement selenBox =
            webDriver.findElement(By.xpath("//*[text()[contains(.,'Selen')]]"));
        selenBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selenBox));
        //Select in dropdown
        WebElement colorsBox =
            webDriver.findElement(By.className("colors"));
        colorsBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(colorsBox));
        WebElement yellowColor = webDriver.findElement(By.xpath("//*[contains(text(),'Yellow')]"));
        yellowColor.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(yellowColor));
        selenBox.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selenBox));
        WebElement waterCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Water')]"));
        softly.assertThat(waterCheckBox.getText()).isEqualTo(waterCheckBox.getText().substring(0, 9)
            + "Water: condition changed to true");
        WebElement windCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softly.assertThat(windCheckBox.getText()).isEqualTo(windCheckBox.getText().substring(0, 9)
            + "Wind: condition changed to true");
        WebElement selenRadioCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Selen')]"));
        softly.assertThat(selenRadioCheck.getText()).isEqualTo(selenRadioCheck.getText().substring(0, 9)
            + "metal: value changed to Selen");
        WebElement yellowColorCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Yellow')]"));
        softly.assertThat(yellowColorCheck.getText()).isEqualTo(yellowColorCheck.getText().substring(0, 9)
            + "Colors: value changed to Yellow");
        softly.assertAll();
    }

}
