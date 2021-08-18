package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractBeforeAfter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractBeforeAfter {
    WebDriverWait webDriverWait;
    SoftAssertions softly = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void LoginCheckTest() {
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
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
        WebElement homeOnTheHeader = webDriver.findElement(By.xpath("//a[@href='index.html']"));
        homeOnTheHeader.isDisplayed();
        WebElement contactsOnTheHeader = webDriver.findElement(By.xpath("//a[@href='contacts.html']"));
        contactsOnTheHeader.isDisplayed();
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown"));
        serviceOnTheHeader.isDisplayed();
        WebElement metalsColors = webDriver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        metalsColors.isDisplayed();
        softly.assertThat(homeOnTheHeader.getText()).isEqualTo("HOME");
        softly.assertThat(contactsOnTheHeader.getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(serviceOnTheHeader.getText()).isEqualTo("SERVICE");
        softly.assertThat(metalsColors.getText()).isEqualTo("METALS & COLORS");
        //Assert that there are 4 images on the Index Page and they are displayed
        webDriver.findElement(By.xpath("//img[contains(@id,'epam-logo')]")).isDisplayed();
        webDriver.findElement(By.xpath("//img[contains(@id,'user-icon')]")).isDisplayed();
        WebElement icon1 = webDriver.findElement(By.className("icon-practise"));
        icon1.isDisplayed();
        WebElement icon2 = webDriver.findElement(By.className("icon-custom"));
        icon2.isDisplayed();
        WebElement icon3 = webDriver.findElement(By.className("icon-multi"));
        icon3.isDisplayed();
        WebElement icon4 = webDriver.findElement(By.className("icon-base"));
        icon4.isDisplayed();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement textUnder1 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To include')]"));
        textUnder1.isDisplayed();
        softly.assertThat(textUnder1.getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        WebElement textUnder2 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be flexible')]"));
        textUnder2.isDisplayed();
        softly.assertThat(textUnder2.getText()).isEqualTo("To be flexible and\n"
            + "customizable");
        WebElement textUnder3 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be multiplatform')]"));
        textUnder3.isDisplayed();
        softly.assertThat(textUnder3.getText()).isEqualTo("To be multiplatform");
        WebElement textUnder4 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'Already have good base')]"));
        textUnder4.isDisplayed();
        softly.assertThat(textUnder4.getText()).isEqualTo("Already have good base\n"
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
        WebElement homeOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='index.html']"));
        homeOnLeftSection.isDisplayed();
        softly.assertThat(homeOnLeftSection.getText()).isEqualTo("Home");
        WebElement contactOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='contacts.html']"));
        contactOnLeftSection.isDisplayed();
        softly.assertThat(contactOnLeftSection.getText()).isEqualTo("Contact form");
        WebElement serviceOnLeftSection = webDriver.findElement(By.xpath("//span[contains(text(),'Service')]"));
        serviceOnLeftSection.isDisplayed();
        softly.assertThat(serviceOnLeftSection.getText()).isEqualTo("Service");
        WebElement metalsAndColorsOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='metals-colors.html']"));
        serviceOnLeftSection.isDisplayed();
        softly.assertThat(metalsAndColorsOnLeftSection.getText()).isEqualTo("Metals & Colors");
        WebElement elementPacksOnLeftSection = webDriver.findElement(By.xpath("//span[contains(text(),'Element')]"));
        elementPacksOnLeftSection.isDisplayed();
        softly.assertThat(elementPacksOnLeftSection.getText()).isEqualTo("Elements packs");
        softly.assertAll();
    }
}
