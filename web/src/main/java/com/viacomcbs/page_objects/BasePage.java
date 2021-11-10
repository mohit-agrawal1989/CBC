package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.PropertyConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import test.java.com.viacomcbs.step_definitions.CBSSports_StepDefinitions;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

public abstract class BasePage {

    private final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    @Autowired
    PropertyConfig config;

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected FluentWait<WebDriver> wait;

    public String test;

    String URL;
    String protocol = "https://";
    String domain = ".cbs.com/";
    String allaccess_path = "cbs-all-access/";
    String currentURL;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    /**
     * Initializes the driver, sets default fluent wait parameters
     */
    @PostConstruct
    private void init() {

        LOGGER.log(Level.INFO, "Initializing the driver... \n");

        PageFactory.initElements(this.driver, this);

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

    }

    /**
     * Scrolls to the given element
     */
    public void scrollToElement(WebElement element) {

        LOGGER.log(Level.INFO, "Scrolling to the element... \n");

        try{
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", (this.returnVerifiedElement(element)));}
        catch (Exception e) {
            LOGGER.log(Level.SEVERE,"Unable to scroll to the element");
            Assert.fail();
        }
    }

    public Wait<String> setupFluentWaitParameters(int timeout, int polling, String input) {

        return new FluentWait<>(input)
                .withTimeout(Duration.ofMillis(timeout))
                .pollingEvery(Duration.ofMillis(polling));
    }

    /**
     * Builds and navigates to the cbs-all-access URL
     */
    public void getaapath(String path) {
        URL = protocol + config.getConfig().getProperty("env") + domain + allaccess_path + path;
        this.driver.get(URL);
        currentURL = driver.getCurrentUrl();
    }

    /**
     * Getter method for Actions class
     */
    public Actions getActions() {
        return new Actions(driver);
    }

    /**
     * Waits for the page to load
     */
    public void waitForPageLoaded() {

        LOGGER.log(Level.INFO, "Waiting until the page is loaded... \n");

        ExpectedCondition<Boolean> expectation = driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     * Checks if currently at the provided url address
     */
    public boolean atURL(String url) {
        boolean here;
        Wait<WebDriver> fluentWait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofMillis(4000))
                .pollingEvery(Duration.ofMillis(400));

        here = fluentWait.until(dr -> {
            boolean isHere = false;
            try {
                if (dr.getCurrentUrl().contentEquals(url)) {
                    isHere = true;
                }
            } catch (TimeoutException e) {
                e.getStackTrace();
            }
            return isHere;
        });

        return here;
    }

    /**
     * Returns current URL
     */
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    /**
     * Deletes all cookies
     */
    public void clearCache() {
        LOGGER.log(Level.INFO, "Clearing cache... \n");

        this.driver.manage().deleteAllCookies();
    }

    /**
     * Waits until element is visible
     */
    public void waitUntilElementIsVisible(WebElement el) {
        this.wait.until(ExpectedConditions.visibilityOf(el));
    }

    /**
     * Waits until element is clickable
     */
    public void waitUntilElementIsClickable(WebElement el) {
        this.wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    /**
     * Takes in expected page URL and asserts that it equals the current page URL
     */
    public void assertPageEquals(String expectedPageURL) {
        waitForPageLoaded();
        String actualPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPageUrl, expectedPageURL);
    }

    /**
     * Takes in expected page URL and asserts that it equals the current page URL
     */
    public void moveToElementAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1500);");
        getActions().moveToElement(element).click().build().perform();
        waitForPageLoaded();
    }

    /**
     * Clicks an element N Times
     */
    public void tryClickingNTimes(WebElement element, int times) {

        for (int i = 0; i <= times; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Waits until current URL is replaced by the given URL
     */
    public boolean waitUntilSameUrl(String url, int seconds) {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(seconds * 1000L))
                .pollingEvery(Duration.ofMillis(40));

        boolean isTrue = false;
        try {
            isTrue = fluentWait.until(driverParam -> driverParam.getCurrentUrl().contentEquals(url));
        } catch (TimeoutException e) {
            e.getStackTrace();
        }
        return isTrue;
    }

    /**
     * Returns an element if it exists, null if not
     */
    public WebElement returnVerifiedElement(WebElement element, int seconds) {
        this.wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);

        try {
            element = this.wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            element = null;
        }
        return element;
    }

    /**
     * Returns an element if it exists, null if not with 10 sec timeout value
     */
    public WebElement returnVerifiedElement(WebElement element) {
        return returnVerifiedElement(element, 10);
    }
}

