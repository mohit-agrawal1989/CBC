package main.java.com.viacomcbs.page_objects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class Schedule_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Schedule_PageObject.class.getName());

    @Value("${schedulePageURL:}")
    private String schedulePageURL;

    @FindBy(className = "dateNav")
    private WebElement dateNav;

    @FindBy(css = "#addFilter > div:nth-of-type(2) > time")
    private WebElement time;

    @FindBy(css = "#addFilter > a:nth-of-type(1)")
    private WebElement content1;

    @FindBy(css = "#addFilter > div:nth-of-type(3)")
    private WebElement image1;

    @FindBy(css = "#lockDown > ul > li > button")
    private WebElement dropdown;

    @FindBy(css = "#lockDown > ul > li > ul > li:nth-of-type(1) > a")
    private WebElement dropdownFirstElement;

    @FindBy(css = "#lockDown > ul > li > ul > li:nth-of-type(7) > a")
    private WebElement dropdownSeventhElement;

    @FindBy(css = "#addFilter > div:nth-of-type(3) > a")
    private WebElement firstShow;

    @FindBy(css = "#addFilter > div:nth-of-type(3) > a > img")
    private WebElement firstShowThumbnail;

    @FindBy(css = "#addFilter > a:nth-of-type(1)")
    private WebElement firstShowNameContainer;

    @FindBy(css = "#addFilter > a:nth-of-type(1) > span:nth-of-type(1)")
    private WebElement firstShowName;

    @FindBy(className = "wlive")
    private WebElement watchLiveTVButton;

    @Value("${firstShowPageURL:}")
    private String firstShowURL;

    public String getSchedulePageURL() {
        return schedulePageURL;
    }

    public boolean iAmHere() {
        return this.atURL(schedulePageURL);
    }

    public void iAmHere(boolean useFluentWait) {
        this.waitUntilElementIsVisible(dateNav);
    }

    public void showsDatesAndTimesAreDisplayed() {

        LOGGER.log(Level.INFO, "Verifying UI elements of Navigation menu... \n");

        Assert.assertNotNull((this.returnVerifiedElement(this.dateNav)));
        Assert.assertNotNull((this.returnVerifiedElement(this.time)));
        Assert.assertNotNull((this.returnVerifiedElement(this.content1)));
        Assert.assertNotNull((this.returnVerifiedElement(this.image1)));
    }

    public void hoverOnDateDropDown() {
        getActions().moveToElement((this.returnVerifiedElement(this.dropdown)));
        getActions().perform();
    }

    public void dropDownAppears() {

        LOGGER.log(Level.INFO, "Verifying that drop down appears... \n");

        this.returnVerifiedElement(this.dropdownFirstElement);
        this.returnVerifiedElement(this.dropdownSeventhElement);
    }

    public boolean clickOnFirstShowNameAndLandOnRightPage() {

        LOGGER.log(Level.INFO, "Clicking on first show name... \n");

        boolean result = false;
        String href = firstShowNameContainer.getAttribute("href");

        waitForPageLoaded();


        if (href != null && href.length() > 0) {

            try {
                moveToElementAndClick(firstShowName);
            } catch (TimeoutException | StaleElementReferenceException | NullPointerException | NoSuchElementException e) {
                e.getStackTrace();
            }

            waitForPageLoaded();

            try {
            assertPageEquals(href);
            result = true;
            } catch (Exception e){
                e.printStackTrace();
            }

        }
        return result;
    }

    public void clickOnWatchLiveTV() {

        LOGGER.log(Level.INFO, "Clicking on Watch Live TV... \n");

        this.returnVerifiedElement(this.watchLiveTVButton).click();
    }
}
