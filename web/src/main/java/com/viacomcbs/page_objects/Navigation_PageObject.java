package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


@PageObject
public class Navigation_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Navigation_PageObject.class.getName());

    @LazyAutowired
    private Home_PageObject home;

    @FindBy(linkText = "Shows")
    private WebElement shows;

    @FindBy(xpath = "//*[@id=\"global-header-container\"]/div[1]/nav/ul/li[2]/a")
    private WebElement liveTV;

    @FindBy(linkText = "TV Provider")
    private WebElement tvProvider;

    @FindBy(how = How.CSS, using = "ul.navigation.header__nav--items li:nth-child(5) > a.icon.search")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"js-li-sign-in\"]/a")
    private WebElement signInOptions;

    @FindBy(className = "button__text")
    private WebElement tryParamount;

    @FindBy(how = How.LINK_TEXT, using = "Schedule")
    private WebElement schedule;

    public void observeHomeShowsLiveTVScheduleTVProviderSearchSignInOptionsTryParamountIsDisplayed() {

        LOGGER.log(Level.INFO, "Verifying UI elements of Navigation menu... \n");


        driver.manage().window().maximize();

        WebElement[] arrayOfElements = {shows,liveTV,schedule,tvProvider,search,signInOptions,tryParamount};

        for(WebElement element : arrayOfElements) {
            Assert.assertTrue(element.isDisplayed());
        }

    }

    public void observeHomeShowsLiveTVScheduleTVProviderSearchSignInOptionsTryParamount() {

        LOGGER.log(Level.INFO, "Verifying UI elements of Navigation menu... \n");


        waitForPageLoaded();

        driver.manage().window().maximize();

        WebElement[] arrayOfElements = {shows,liveTV,schedule,tvProvider,search};

        for (WebElement element : arrayOfElements) {
            Assert.assertTrue(element.isDisplayed());
        }

        getActions().moveToElement(signInOptions).build().perform();

        Assert.assertTrue(signInOptions.isDisplayed());
        Assert.assertTrue(tryParamount.isDisplayed());

    }
}