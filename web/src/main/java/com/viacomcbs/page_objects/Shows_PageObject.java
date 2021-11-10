package main.java.com.viacomcbs.page_objects;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

@PageObject
public class Shows_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Show_PageObject.class.getName());

    @Value("${showsPageURL:}")
    private String showsPageURL;

    @FindBy(how = How.CSS, using = "ul.navigation.header__nav--items li:nth-child(1) > a:nth-child(1)")
    private WebElement selectShow1;

    @FindBy(how = How.CSS, using = "ul.navigation.header__nav--items li:nth-child(5) > a.icon.search")
    private WebElement searchPage1;

    @Value("${searchPageURL}")
    private String searchPageURL;

    @FindBy(how = How.CSS, using = "div.search__inputWrap > input:nth-child(1)")
    private WebElement searchTitle;

    String titlePut = "Big Brother";

    @FindAll({@FindBy(css = "#main-container > section:nth-of-type(1) > div > article")})
    private List<WebElement> shows;

    public String getShowsPageURL() {
        return showsPageURL;
    }

    public void i_am_at_the_shows_page() {
        Assert.assertTrue(iAmHere(), "Not in " + getShowsPageURL());
    }

    public boolean iAmHere() {
        return this.atURL(showsPageURL);
    }

    public void goTo() {
        this.driver.get(showsPageURL);
    }

    public void iTypeShowAndObserveShowPosterArtDisplayedForAllTheShowsInSearchResults() {

        LOGGER.log(Level.INFO, "Checking posters for search results... \n");

        wait.until(ExpectedConditions.visibilityOf(searchPage1));
        driver.manage().window().maximize();
        searchPage1.click();
        searchTitle.sendKeys(titlePut);

        assertPageEquals(searchPageURL);

    }

    public void selectOnTheShowAndObserveOnSelectingShowsTakesTheUserToTheShowBrowsePageIsDisplayed() {

        LOGGER.log(Level.INFO, "Checking if clicking on the show takes to the show page... \n");


        waitForPageLoaded();
        selectShow1.click();
        assertPageEquals(showsPageURL);

    }

    public boolean clickOnShow(int placement) {
        boolean result = true;
        try {
        shows.get(placement).click();}
        catch(Exception e) {
            LOGGER.log(Level.SEVERE, "Was unable to click! \n");

            result=false;
        }

        return result;
    }

    public boolean clickOnShow(String title) {

        LOGGER.log(Level.INFO, "Clicking on the show... \n");

        String aalink;
        boolean found = false;

        title = title.toLowerCase();
        for (WebElement show : shows) {
            aalink = show.findElement(By.tagName("a")).getAttribute("aa-link").toLowerCase();
            if (aalink.contains(title)) {
                show.click();
                found = true;
            }
        }
        Assert.assertTrue(found, title + " was not found");

        return found;
    }



}
