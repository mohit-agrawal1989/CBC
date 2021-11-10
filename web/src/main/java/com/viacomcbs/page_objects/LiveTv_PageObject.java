package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.LazyAutowired;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class LiveTv_PageObject extends BasePage {

    @LazyAutowired
    private Home_PageObject home;

    private final Logger LOGGER = Logger.getLogger(LiveTv_PageObject.class.getName());

    @FindBy(xpath = "//nav//a[normalize-space()='Live TV']")
    private WebElement liveTV;

    @FindBy(xpath = "(//div[@data-channel-slug='cbssportshq'])[1]")
    private WebElement cbsnSports;

    @FindBy(xpath = "(//div[@data-channel-slug='cbsn'])[1]")
    private WebElement cbsnNews;

    @Value("${liveTvCBSSportsHQPageURL}")
    private String liveTvCbsSportsURL;

    @FindBy(xpath = "//*[@id=\"global-header-container\"]/div[1]/nav/ul/li[2]/a")
    private WebElement livetv;

    @FindBy(xpath = "//div[@class='sidebar']")
    private WebElement background;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[3]/div[1]/div[2]/img")
    private WebElement cbsSports;

    @Value("${liveTvCBSNPageURL}")
    private String liveTvCBSNPageURL;

    @Value("${liveTvPageURL}")
    private String liveTvPageURL;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/div[2]/div/div/div[2]/a/div")
    private WebElement signInWithTVProvider;

    @Value("${liveTvLocalPageURL:}")
    private String liveTvLocalPageURL;

    @Value("${liveTvCBSSportsHQPageURL:}")
    private String liveTvCBSSportsHQPageURL;

    @Value("${liveTvETLivePageURL:}")
    private String liveTvETLivePageURL;

    @FindBy(className = "video__lock-slate-container")
    private WebElement lockSlateContainer;

    @FindBy(linkText = "TV Provider")
    private WebElement tvProvider;

    @Value("${helpPageURL}")
    private String helpPageURL;

    @FindBy(how = How.CSS, using = "div.slate__provider__box:nth-child(6) > a:nth-child(1)")
    private WebElement optimum;

    @FindBy(className = "user-profile-name")
    private WebElement drop;

    @FindBy(id = "username")
    private WebElement id;

    @FindBy(how = How.CSS, using = "ul.header__account.header__nav--items li.header__nav--withsubMenu ul.header__subnav.content li:nth-child(3) > a:nth-child(1)")
    private WebElement help;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "signin_button")
    private WebElement button;

    @Value("${homePageURL}")
    private String homePageURL;

    @Value("${liveTvCBSSportsHQPageURL}")
    private String sportsPageURL;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[4]/div[1]/div[3]/div")
    private WebElement etlLive;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div[2]/img")
    private WebElement localStation;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[3]/div[1]/div/div/cbsplayer/div/div[1]/div/div[9]/div/div/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/img")
    private WebElement cbsn;


    public void selectLiveTVOptionAndClickOnEtLiveAndObserveTheStream() throws InterruptedException {
        clickOnLiveTVChannel(etlLive,liveTvETLivePageURL);
    }

    public boolean iAmHere() {
        return this.atURL(liveTvPageURL);
    }

    public void selectTvProviderAndEnterTheEmailAndPasswordForCredentials() {

        LOGGER.log(Level.INFO, "Selecting TV Provider and entering credentials... \n");

        waitForPageLoaded();

        for (int i = 0; i <= 2; i++) {
            try {
                tvProvider.click();
                optimum.click();
                Thread.sleep(1000);
                String idPut = "research1001";
                id.sendKeys(idPut);
                Thread.sleep(1000);
                String passPut = "support1001";
                pass.sendKeys(passPut);
                Thread.sleep(1000);
                button.click();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectLiveTVOptionsAndClickOnCBSNStationAndObserveTheStream() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting CBSN station... \n");

        //If the page lands on cbsn news by default the test case passes
        if (driver.getCurrentUrl().equals(liveTvCBSNPageURL)) {
            Assert.assertTrue(true);
        }

        //If the page doesn't land on cbsn news by default click on cbsn button and compare the urls
        else {
            clickOnLiveTVChannel(cbsn,liveTvCBSNPageURL);
        }

    }



    public void clickOnLiveTVChannel(WebElement channel, String expectedURL) throws InterruptedException {

        LOGGER.log(Level.INFO, "Clicking on Live TV channel... \n");


        waitForPageLoaded();

        //Click on Live Tv option
        moveToElementAndClick(liveTV);

        waitForPageLoaded();

        //Explicit wait doesn't apply here, thus 1 sec sleep
        Thread.sleep(1000);

        //Click on one of background containers to bring up the channel selection submenu
        moveToElementAndClick(background);

        //Explicit wait doesn't apply here, thus 10 sec sleep
        Thread.sleep(10000);

        //Click on etLive banner. The button is hidden behind the banner
        moveToElementAndClick(channel);

        assertPageEquals(expectedURL);

    }



    public void selectLiveTVOptionsAndClickOnLocalStationAndObserveTheStream() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting local station... \n");

        waitForPageLoaded();
        clickOnLiveTVChannel(localStation,liveTvLocalPageURL);
    }

    public void observeSelectingHelpTakesTheUserToTheCBSHelpPage() {

        LOGGER.log(Level.INFO, "Selecting help... \n");

        for (int i = 0; i <= 2; i++) {
            try {
                getActions().moveToElement(drop).build().perform();
                help.click();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertPageEquals(helpPageURL);
    }


    public boolean selectLiveTvOptionAndClickOnCBSNSportsAndObserveTheStream() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting CBSN News station... \n");

        boolean result = false;

        waitForPageLoaded();
        //If the page lands on cbsn news by default the test case passes
        if (driver.getCurrentUrl().contains("stream/sports/")) {
            Assert.assertTrue(true);
            LOGGER.log(Level.INFO, "Landed on CBSN sports by default... \n");
        }

        //If the page doesn't land on cbsn news by default click on cbsn button and compare the urls
        else {
            LOGGER.log(Level.INFO, "Page doesn't land on CBSN sports by default... \n");
            moveToElementAndClick(liveTV);
            LOGGER.log(Level.INFO, "Clicked on Live TV... \n");
            moveToElementAndClick(background);
            LOGGER.log(Level.INFO, "Clicked on background... \n");
            moveToElementAndClick(cbsnSports);
            LOGGER.log(Level.INFO, "Clicked on CBSN sports... \n");
            assertPageEquals(liveTvCBSSportsHQPageURL);
            result = true;
            LOGGER.log(Level.INFO, "Landed on CBSN sports... \n");
        }
        return result;
    }

    public boolean selectLiveTvOptionAndClickOnCBSNNewsAndObserveTheStream() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting CBSN News station... \n");

        boolean result = false;

        waitForPageLoaded();
        //If the page lands on cbsn news by default the test case passes
        if (driver.getCurrentUrl().contains("stream/cbsn/")) {
            Assert.assertTrue(true);
            LOGGER.log(Level.INFO, "Landed on CBSN news by default... \n");
        }

        //If the page doesn't land on cbsn news by default click on cbsn button and compare the urls
        else {
            LOGGER.log(Level.INFO, "Page doesn't land on CBSN sports by default... \n");
            waitUntilElementIsClickable(liveTV);
            moveToElementAndClick(liveTV);
            LOGGER.log(Level.INFO, "Clicked on Live TV... \n");
            returnVerifiedElement(background, 20);
            moveToElementAndClick(background);
            LOGGER.log(Level.INFO, "Clicked on background... \n");
            waitUntilElementIsClickable(cbsnNews);
            moveToElementAndClick(cbsnNews);
            LOGGER.log(Level.INFO, "Clicked on CBSN news... \n");
            assertPageEquals(liveTvCBSNPageURL);
            result = true;
            LOGGER.log(Level.INFO, "Landed on CBSN news... \n");
        }
        return result;
    }




    public String getLiveTvPageURL() {
        return liveTvPageURL;
    }

    public String getLiveTvLocalPageURL() {
        return liveTvLocalPageURL;
    }

    public String getLiveTvCBSNPageURL() {
        return liveTvCBSNPageURL;
    }

    public String getLiveTvCBSSportsHQPageURL() {
        return liveTvCBSSportsHQPageURL;
    }

    public String getLiveTvETLivePageURL() {
        return liveTvETLivePageURL;
    }

    boolean lockSlateContainerIsPresent;

    public void iAmAtTheLocalStation() throws InterruptedException {

        LOGGER.log(Level.INFO, "Verifying if on the local station... \n");

        waitForPageLoaded();

        try{
            if (signInWithTVProvider.isDisplayed()) {
            Assert.assertTrue(true);
            } else {
                assertPageEquals(liveTvCBSNPageURL);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ///KEEP THIS BLOCK COMMENTED OUT FOR NOW:

//		//Verify that this is live tv local page
//		Assert.assertTrue(driver.getCurrentUrl().contains("live%20local"));
//
//		//Check if lockSlateContainer contains Proxy element in it that exists only if its empty
//		lockSlateContainerIsPresent = lockSlateContainer.toString().contains("Proxy element");
//
//		//Assert that lockSlateContainer is present
//		Assert.assertTrue(lockSlateContainerIsPresent);

    }

    public void iAmAtTheLockedLocalStation() {

        LOGGER.log(Level.INFO, "Verifying that I'm at the local station and unable to watch it... \n");

        waitForPageLoaded();
        lockSlateContainerIsPresent = lockSlateContainer.toString().contains("Proxy element");
        Assert.assertFalse(lockSlateContainerIsPresent);

    }


    public void selectLiveTVOptionsAndClickOnCBSSportsAndObserveTheStream() throws InterruptedException {

        LOGGER.log(Level.INFO, "Selecting CBS sports... \n");

        clickOnLiveTVChannel(cbsSports,sportsPageURL);
    }

    public void iAmAtTheCBSNStation() {
        this.atURL(liveTvCBSNPageURL);
    }
    public void iAmAtTheCBSSportsHQStation() {
        this.atURL(liveTvCBSSportsHQPageURL);
    }
    public void iAmAtTheEtLiveStation() {
        this.atURL(liveTvETLivePageURL);
    }

}