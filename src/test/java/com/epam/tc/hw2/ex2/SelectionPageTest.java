package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractBaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SelectionPageTest extends AbstractBaseTest {
    SoftAssertions softly = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    static final String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    @Test
    public void selectionCheckTest() {
        webDriver.navigate().to(EPAM_URL);
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        //Assert Browser title
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //Assert performing login
        WebElement loginForm = webDriver.findElement(By.id("user-icon"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginForm));
        loginForm.click();
        WebElement username = webDriver.findElement(By.id("name"));
        username.sendKeys("Roman");
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        softly.assertThat(webDriver.getCurrentUrl()).isEqualTo(EPAM_URL);
        //Assert User name in the left-top side of screen that user is loggined
        WebElement userNameLogged = webDriver.findElement(By.id("user-name"));
        boolean userName = userNameLogged.isDisplayed();
        softly.assertThat(userName).isEqualTo(true);
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
        WebElement selenBox =
            webDriver.findElement(By.xpath("//*[text()[contains(.,'Selen')]]"));
        selenBox.click();
        //Select in dropdown
        WebElement colorsBox =
            webDriver.findElement(By.className("colors"));
        colorsBox.click();
        WebElement yellowColor = webDriver.findElement(By.xpath("//*[contains(text(),'Yellow')]"));
        yellowColor.click();
        selenBox.click();
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
