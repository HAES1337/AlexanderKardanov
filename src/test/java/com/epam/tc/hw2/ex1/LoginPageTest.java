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
        List<WebElement> headerMenuWebElements =
            webDriver.findElements(By.xpath("//ul[contains(@class,'uui-navigation nav navbar-nav m-')]/li/a"));
        boolean headerMenuWebElementsFirst = headerMenuWebElements.get(0).isDisplayed();
        System.out.println(headerMenuWebElementsFirst);
        boolean headerMenuWebElementsSecond = headerMenuWebElements.get(1).isDisplayed();
        System.out.println(headerMenuWebElementsSecond);
        boolean headerMenuWebElementsThird = headerMenuWebElements.get(2).isDisplayed();
        System.out.println(headerMenuWebElementsThird);
        boolean headerMenuWebElementsFourth = headerMenuWebElements.get(3).isDisplayed();
        System.out.println(headerMenuWebElementsFourth);
        List<String> expectedHeaderMenuWebElementsTexts = List.of("HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS");
        List<String> allTextsHeaderMenu = new ArrayList<>();
        for (WebElement webElement : headerMenuWebElements) {
            allTextsHeaderMenu.add(webElement.getText());
        }
        softly.assertThat(allTextsHeaderMenu).containsExactlyInAnyOrderElementsOf(expectedHeaderMenuWebElementsTexts);
        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsWebElements = webDriver.findElements(By.className("benefit-icon"));
        boolean iconsWebElementsFirst = iconsWebElements.get(0).isDisplayed();
        System.out.println(iconsWebElementsFirst);
        boolean iconsWebElementsSecond = iconsWebElements.get(1).isDisplayed();
        System.out.println(iconsWebElementsSecond);
        boolean iconsWebElementsThird = iconsWebElements.get(2).isDisplayed();
        System.out.println(iconsWebElementsThird);
        boolean iconsWebElementsFourth = iconsWebElements.get(3).isDisplayed();
        System.out.println(iconsWebElementsFourth);
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedTextUnderIcons = List.of("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project",
            "To be flexible and\ncustomizable",
            "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…",
            "To be multiplatform");
        List<WebElement> textUnderWebElements =
            webDriver.findElements(By.className("benefit-txt"));
        List<String> allTextsUnderIcon = new ArrayList<>();
        for (WebElement webElement : textUnderWebElements) {
            allTextsUnderIcon.add(webElement.getText());
        }
        softly.assertThat(allTextsUnderIcon).containsExactlyInAnyOrderElementsOf(expectedTextUnderIcons);
        //Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = webDriver.findElement(By.id("frame"));
        boolean frameWithButtonCheck = frameWithButton.isDisplayed();
        System.out.println(frameWithButtonCheck);
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frameWithButton);
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        boolean frameButtonCheck = frameButton.isDisplayed();
        System.out.println(frameButtonCheck);
        //Switch to original window back
        webDriver.switchTo().defaultContent();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuWebElements =
            webDriver.findElements(By.xpath("//*[@class='sidebar-menu left']/li[@index]"));
        boolean leftSideMenuWebElementsFirst = leftSideMenuWebElements.get(0).isDisplayed();
        System.out.println(leftSideMenuWebElementsFirst);
        boolean leftSideMenuWebElementsSecond = leftSideMenuWebElements.get(1).isDisplayed();
        System.out.println(leftSideMenuWebElementsSecond);
        boolean leftSideMenuWebElementsThird = leftSideMenuWebElements.get(2).isDisplayed();
        System.out.println(leftSideMenuWebElementsThird);
        boolean leftSideMenuWebElementsFourth = leftSideMenuWebElements.get(3).isDisplayed();
        System.out.println(leftSideMenuWebElementsFourth);
        boolean leftSideMenuWebElementsFifth = leftSideMenuWebElements.get(4).isDisplayed();
        System.out.println(leftSideMenuWebElementsFifth);
        List<String> expectedLeftSideMenuTexts = List.of("Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");
        List<String> allTextsLeftSideMenu = new ArrayList<>();
        for (WebElement webElement : leftSideMenuWebElements) {
            allTextsLeftSideMenu.add(webElement.getText());
        }
        softly.assertThat(allTextsLeftSideMenu).containsExactlyInAnyOrderElementsOf(expectedLeftSideMenuTexts);
        softly.assertAll();
    }
}
