package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractBaseTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractBaseTest {
    SoftAssertions softly = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void loginCheckTest() {
        webDriver.navigate().to(EPAM_URL);
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        //Assert Browser title
        webDriverWait.until(ExpectedConditions.titleIs("Home Page"));
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //Assert performing login
        WebElement loginForm = webDriver.findElement(By.id("user-icon"));
        loginForm.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginForm));
        WebElement username = webDriver.findElement(By.id("name"));
        username.sendKeys("Roman");
        webDriver.findElement(By.id("password"));
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        softly.assertThat(webDriver.getCurrentUrl()).isEqualTo(EPAM_URL);
        // Check loggined
        WebElement userNameLogged = webDriver.findElement(By.id("user-name"));
        userNameLogged.isDisplayed();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(userNameLogged, "ROMAN IOVLEV"));
        softly.assertThat(userNameLogged.getText()).isEqualTo("ROMAN IOVLEV");
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuWebElements = webDriver.findElements(By.xpath("//ul[contains(@class,'uui-navigation nav navbar-nav m-')]/li/a"));
        headerMenuWebElements.get(0).isDisplayed();
        headerMenuWebElements.get(1).isDisplayed();
        headerMenuWebElements.get(2).isDisplayed();
        headerMenuWebElements.get(3).isDisplayed();
        softly.assertThat(headerMenuWebElements.get(0).getText()).isEqualTo("HOME");
        softly.assertThat(headerMenuWebElements.get(1).getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(headerMenuWebElements.get(2).getText()).isEqualTo("SERVICE");
        softly.assertThat(headerMenuWebElements.get(3).getText()).isEqualTo("METALS & COLORS");
        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsWebElements = webDriver.findElements(By.className("benefit-icon"));
        iconsWebElements.get(0).isDisplayed();
        iconsWebElements.get(1).isDisplayed();
        iconsWebElements.get(2).isDisplayed();
        iconsWebElements.get(3).isDisplayed();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> allTextsUnderIcon = new ArrayList<>();
        List<WebElement> textUnderWebElements =
            webDriver.findElements(By.className("benefit-txt"));
        for (WebElement webElement : textUnderWebElements) {
            allTextsUnderIcon.add(webElement.getText());
        }
        softly.assertThat(allTextsUnderIcon.get(0)).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        softly.assertThat(allTextsUnderIcon.get(1)).isEqualTo("To be flexible and\n"
            + "customizable");
        softly.assertThat(allTextsUnderIcon.get(2)).isEqualTo("To be multiplatform");
        softly.assertThat(allTextsUnderIcon.get(3)).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");
        //Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = webDriver.findElement(By.id("frame"));
        frameWithButton.isDisplayed();
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frameWithButton);
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        frameButton.isDisplayed();
        //Switch to original window back
        webDriver.switchTo().defaultContent();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuWebElements = webDriver.findElements(By.xpath("//*[@class='sidebar-menu left']/li[@index]"));
        leftSideMenuWebElements.get(0).isDisplayed();
        leftSideMenuWebElements.get(1).isDisplayed();
        leftSideMenuWebElements.get(2).isDisplayed();
        leftSideMenuWebElements.get(3).isDisplayed();
        leftSideMenuWebElements.get(4).isDisplayed();
        softly.assertThat(leftSideMenuWebElements.get(0).getText()).isEqualTo("Home");
        softly.assertThat(leftSideMenuWebElements.get(1).getText()).isEqualTo("Contact form");
        softly.assertThat(leftSideMenuWebElements.get(2).getText()).isEqualTo("Service");
        softly.assertThat(leftSideMenuWebElements.get(3).getText()).isEqualTo("Metals & Colors");
        softly.assertThat(leftSideMenuWebElements.get(4).getText()).isEqualTo("Elements packs");
        softly.assertAll();
    }
}
