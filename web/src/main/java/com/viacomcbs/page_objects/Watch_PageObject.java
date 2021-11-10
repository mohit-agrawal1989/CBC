package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class Watch_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Watch_PageObject.class.getName());

    @FindBy(how = How.CSS, using = "ul.navigation.header__nav--items li:nth-child(1) > a:nth-child(1)")
    private WebElement shows;

    @Value("${showsPageURL}")
    private String showsPageURL;

    @Value("${bigBrotherURL}")
    private String bigBrotherURL;

    @FindBy(how = How.CSS, using = "h2.video-section-title")
    private WebElement carousel;

    @Value("${homePageURL}")
    private String homePageURL;

    @FindBy(how = How.CSS, using = " div.carousel-content div.carousel-width-wrapper div.carousel.js-video-carousel > div.edit-carousel")
    private WebElement remove;

    @FindBy(how = How.CSS, using = " div.swiper-slide.swiper-slide-visible:nth-child(3) a.link.fathom_tracked div.thumb-wrapper label.edit-container:nth-child(1) > span.checkmark:nth-child(2)")
    private WebElement posterClick;

    @FindBy(xpath = "//*[@id=\"keep-watching\"]/div/div/div/div[3]/div[1]/div/div[1]/a/div[1]/img")
    private WebElement watching2;

    @FindBy(how = How.CSS, using = "article.show-browse-item:nth-child(1) a:nth-child(1) div.thumb-wrapper > img.thumb.lazy.loaded")
    private WebElement select1;

    @FindBy(how = How.CSS, using = "div.edit-carousel")
    private WebElement edit;

    @FindBy(xpath = "\"//body/main[@id='main-container']/section[1]/div[1]/article[1]/a[1]/div[1]/img[1]\"")
    private WebElement select;

    @FindBy(xpath = "//body/main[@id='main-container']/div[1]/section[3]/div[2]/article[1]/a[1]/div[1]")
    private WebElement full;

    @FindBy(how = How.CSS, using = "div.edit-cancel-carousel")
    private WebElement cancel;


    public void selectShowsPageSelectAShowAndSelectFullEpisodesAndObserveWatchPage() {

        LOGGER.log(Level.INFO, "Selecting a show... \n");

        waitForPageLoaded();
        shows.click();
        assertPageEquals(showsPageURL);
        select1.click();
        full.click();

    }

    public void observeEditModeTurnsOnCancelRemoveAndSelectOptionsDisplayed() {
        tryClickingNTimes(edit, 2);
    }

    public void i_click_on_shows_and_i_am_on_the_shows_page()  {
        shows.click();
        assertPageEquals(showsPageURL);
    }

    public void i_select_full_episodes_and_observe_the_watch() {

        driver.get(bigBrotherURL);
        waitForPageLoaded();
        full.click();
        Assert.assertTrue(full.isSelected());

    }

    public void i_select_on_the_show() {

        driver.get(bigBrotherURL);
        waitForPageLoaded();
        select.click();
        Assert.assertTrue(select.isEnabled());

    }

    public void obsrveSelectedThumbnailsRemoved() {

        LOGGER.log(Level.INFO, "Checking that thumbnails are removed... \n");

        tryClickingNTimes(posterClick,2);
        tryClickingNTimes(remove,2);
    }

    public void observeThumbnilOutstands() {

        LOGGER.log(Level.INFO, "Checking the thumbnails... \n");

        wait.until(ExpectedConditions.visibilityOf(watching2));

        //Test passes if user is able to move to this element
        getActions().moveToElement(watching2).build().perform();

    }

    public void observeRequestedShowsVideoEpisodesResumes() {

        LOGGER.log(Level.INFO, "Verifying that episodes resume... \n");

        waitForPageLoaded();
        driver.manage().window().maximize();
        scrollToElement(watching2);
        tryClickingNTimes(watching2,2);

        String actualPageUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualPageUrl.contains("/video/"));

    }

    public void observeEditModeTurnsOff() {

        LOGGER.log(Level.INFO, "Verifying that Edit Mode turns off... \n");

        waitForPageLoaded();
        tryClickingNTimes(cancel,2);

    }


    public void observeThumbnailsCarouselScrollThrough() {

        LOGGER.log(Level.INFO, "Verifying that carousel scrolls... \n");

        driver.manage().window().maximize();

        waitForPageLoaded();
        scrollToElement(carousel);
        tryClickingNTimes(carousel,2);

    }
}