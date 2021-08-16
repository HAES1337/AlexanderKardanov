package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void firstExTest() {
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
        webDriver.findElement(By.xpath("//a[@href='index.html']")).isDisplayed();
        WebElement homeOnTheHeader = webDriver.findElement(By.xpath("//a[@href='index.html']"));
        webDriver.findElement(By.xpath("//a[@href='contacts.html']")).isDisplayed();
        WebElement contactsOnTheHeader = webDriver.findElement(By.xpath("//a[@href='contacts.html']"));
        webDriver.findElement(By.cssSelector(".dropdown")).isDisplayed();
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown"));
        webDriver.findElement(By.xpath("//a[@href='metals-colors.html']")).isDisplayed();
        WebElement metalsColors = webDriver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        softly.assertThat(homeOnTheHeader.getText()).isEqualTo("HOME");
        softly.assertThat(contactsOnTheHeader.getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(serviceOnTheHeader.getText()).isEqualTo("SERVICE");
        softly.assertThat(metalsColors.getText()).isEqualTo("METALS & COLORS");
        webDriver.findElement(By.xpath("//img[contains(@id,'epam-logo')]")).isDisplayed();
        webDriver.findElement(By.xpath("//img[contains(@id,'user-icon')]")).isDisplayed();
        webDriver.findElement(By.className("icon-practise")).isDisplayed();
        webDriver.findElement(By.className("icon-custom")).isDisplayed();
        webDriver.findElement(By.className("icon-multi")).isDisplayed();
        webDriver.findElement(By.className("icon-base")).isDisplayed();
        WebElement textUnder1 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To include')]"));
        softly.assertThat(textUnder1.getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        WebElement textUnder2 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be flexible and')]"));
        softly.assertThat(textUnder2.getText()).isEqualTo("To be flexible and\n"
            + "customizable \n");
        WebElement textUnder3 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be multiplatform')]"));
        softly.assertThat(textUnder3.getText()).isEqualTo("To be multiplatform");
        WebElement textUnder4 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'Already have good base')]"));
        softly.assertThat(textUnder4.getText()).isEqualTo("Already have good base\n"
            + "about 20 internal and \n"
            + "some external projects \n"
            + "wish to get more…");
        WebElement frame = webDriver.findElement(By.xpath("//*[@id='frame']"));
        frame.isDisplayed();
        webDriver.switchTo().frame("frame");
        WebElement frameButton = webDriver.findElement(By.xpath("//*[@id='frame-button']"));
        frameButton.isDisplayed();
        webDriver.switchTo().defaultContent();
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
        WebElement elementPacksOnLeftSection = webDriver.findElement(By.xpath("//span[contains(text(),'Service')]"));
        elementPacksOnLeftSection.isDisplayed();
        softly.assertThat(metalsAndColorsOnLeftSection.getText()).isEqualTo("Element packs");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }
}
