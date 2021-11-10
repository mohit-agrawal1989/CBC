package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.LazyAutowired;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class GlobalNavigation_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(GlobalNavigation_PageObject.class.getName());

    @FindBy(css = "#global-header-container > div:nth-of-type(1) > nav > ul > li:nth-of-type(1) > a")
    private WebElement shows;

    @FindBy(xpath = "//*[@id=\"global-header-container\"]/div[1]/nav/ul/li[2]/a")
    private WebElement liveTV;

    @FindBy(css = "#global-header-container > div:nth-of-type(1) > nav > ul > li:nth-of-type(3) > a")
    private WebElement schedule;

    @FindBy(xpath="//*[@id=\"global-header-container\"]/div[1]/nav/ul/li[4]/a")
    private WebElement tvprovider;

    @FindBy(css = "#global-header-container > div:nth-of-type(1) > nav > ul > li:nth-of-type(5) > a")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"user-profiles-menu-trigger\"]/li[2]/a")
    private WebElement tryParamountPlus;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[2]/img")
    private WebElement cbsLocalStation;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/img")
    private WebElement cbsn;

    @FindBy(css = "#global-header-container > div:nth-of-type(1) > nav > ul > li:nth-of-type(2) > ul > li:nth-of-type(3) > a")
    private WebElement cbsSportsHQ;

    @FindBy(css = "#global-header-container > div:nth-of-type(1) > nav > ul > li:nth-of-type(2) > ul > li:nth-of-type(4) > a")
    private WebElement etLive;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[2]/div[2]")
    private WebElement background;

    @Value("${livetvLocal}")
    private String liveTvLocal;

    @LazyAutowired
    private LiveTv_PageObject livetv;

    public void clickShows() {
        (this.returnVerifiedElement(shows)).click();
    }

    public void clickOnLiveTVButton()  {
        LOGGER.log(Level.INFO, "Clicking on Live TV button... \n");

        waitForPageLoaded();
        moveToElementAndClick(liveTV);
    }

    public void clickCBSStation() throws InterruptedException {
        LOGGER.log(Level.INFO, "Clicking on CBS Station channel... \n");

        livetv.clickOnLiveTVChannel(cbsLocalStation,liveTvLocal);
            }

    public void clickSchedule() {
        LOGGER.log(Level.INFO, "Clicking on TV Schedule... \n");

        (this.returnVerifiedElement(this.schedule)).click();
    }

    public void clickTvProvider() {
        LOGGER.log(Level.INFO, "Clicking on TV provider... \n");

        (this.returnVerifiedElement(tvprovider)).click();
    }

    public void clickSearch() {
        LOGGER.log(Level.INFO, "Clicking on Search... \n");

        (this.returnVerifiedElement(this.search)).click();
    }

    public void clickTryParamountPlus() {
        LOGGER.log(Level.INFO, "Clicking on Try Paramount Plus... \n");

        waitForPageLoaded();
        moveToElementAndClick(tryParamountPlus);
    }

    public void hoverOnLiveTv()  {
        getActions().moveToElement((this.returnVerifiedElement(this.liveTV))).perform();
        this.returnVerifiedElement(this.etLive);//waits for the menu to fully open
    }

    public void clickCbsLocalStation() throws InterruptedException {
        LOGGER.log(Level.INFO, "Clicking on CBS local station... \n");

        waitForPageLoaded();
        livetv.clickOnLiveTVChannel(cbsLocalStation,liveTvLocal);
    }

    public void clickCBSN() {
        LOGGER.log(Level.INFO, "Clicking on CBSN... \n");

        (this.returnVerifiedElement(this.cbsn)).click();
    }
    public void clickCBSSportsHQ() {
        LOGGER.log(Level.INFO, "Clicking on CBS Sports station... \n");

        (this.returnVerifiedElement(this.cbsSportsHQ)).click();
    }
    public void clickEtLive() {
        LOGGER.log(Level.INFO, "Clicking on ET Live station... \n");

        (this.returnVerifiedElement(this.etLive)).click();
    }
}
