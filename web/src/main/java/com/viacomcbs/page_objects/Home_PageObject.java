package main.java.com.viacomcbs.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.PageObject;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class Home_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Home_PageObject.class.getName());

    @Value("${env:}")
    private String env;

    @FindBy(className = "burger")
    private WebElement burger;

    //@FindBy(how = How.CSS, using = "nav.header__nav > a.icon.siteLogo")
    @FindBy(xpath = "//a[@class='icon siteLogo' and contains(@aa-link,'global header')]")
    private WebElement cbsLogo1;

    @FindBy(how = How.CSS, using = "div.top-components section.js-le-carousel div.carousel-content div.carousel-width-wrapper div.carousel.js-video-carousel div.video-carousel-box div.wrap.swiper-container.swiper-container-virtual.swiper-container-initialized.swiper-container-horizontal div.carousel-container.swiper-wrapper.carousel-fader div.swiper-slide.swiper-slide-active.swiper-slide-visible:nth-child(1) a.link.fathom_tracked > div.thumb-wrapper")
    private WebElement watching;

    @Value("${cookiesURL:}")
    private String cookiesURL;

    @Value("${registeredAccountCredentials:}")
    private String registeredCredentials;

    @Value("${ghostAccountCredentials:}")
    private String ghostAccountCredentials;

    @Value("${tvePlusCbsAccountCredentials:}")
    private String tvePlusCbsAccountCredentials;

    @Value("${homePageURL}")
    private String homePageURL;

    @Value("${accountPageURL}")
    private String accountPageURL;

    @FindBy(id = "hero-content-slider")
    private WebElement heroContentSlider;

    @FindBy(xpath = "(//a[@href='/account/signin/' and normalize-space()='Sign In'])[1]")
    public WebElement signInOptionsButton;

    @FindBy(className = "header__nav_MVPD-logo")
    public WebElement mvpdLogo;

    @FindBy(className = "user-profile-name")
    private WebElement userProfileName;

    @FindBy(css = "#user-profiles-menu-trigger > li:nth-of-type(1) > ul > li:nth-of-type(1) > a")
    private WebElement accountButton;

    @LazyAutowired
    public SignIn_PageObject signin;

    @LazyAutowired
    private Account_PageObject account;

    public String getHomePageURL() {
        return homePageURL;
    }

    public void goToHome() {
        System.out.println("DEBUGGING: " + driver);
        this.driver.get(homePageURL);
        this.driver.manage().window().maximize();
        waitForPageLoaded();
    }

    public void observeOnSmallerScreensHamburgerMenuIsDisplayedOnFarLeft() {

        LOGGER.log(Level.INFO, "Checking Hamburger menu on smaller screens... \n");

        this.driver.manage().window().setSize(new Dimension(415, 736));
        Assert.assertTrue(burger.isDisplayed());
    }

    public boolean iAmHere() {
        return this.atURL(homePageURL);
    }

    public void signInOptionsButtonIsDisplayed() {
        Assert.assertTrue(isOptionDisplayed(signInOptionsButton));
    }

    public boolean isAtHomePage() {
        return (this.waitUntilSameUrl(homePageURL, 10));
    }

    public boolean isOptionDisplayed(WebElement option) {
        return this.returnVerifiedElement(option) != null;
    }

    public void clickSignInOptionsButton() {
        waitForPageLoaded();
        waitUntilElementIsVisible(this.signInOptionsButton);
        waitUntilElementIsClickable(this.signInOptionsButton);
        (this.returnVerifiedElement(this.signInOptionsButton)).click();
    }

    public String whatIsTheUserProfileName() {

        LOGGER.log(Level.INFO, "Checking user profile name... \n");

        String profileName;

        try {
            profileName = (this.returnVerifiedElement(this.userProfileName)).getText();
        } catch (NullPointerException e) {
            profileName = "Not found due to null element";
        }

        return profileName;
    }


    public boolean isUserProfileNameAMatchTo(String usernameParam) {

        LOGGER.log(Level.INFO, "Checking user profile name... \n");

        boolean match = false;
        String username;
        WebElement el = (this.returnVerifiedElement(this.userProfileName));
        try {
            username = el.getText().trim();
            if (username.contentEquals(usernameParam)) {
                match = true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return match;
    }

    public boolean iAmHereCookies() {
        return this.atURL(cookiesURL);
    }

    public void goToAccountSettings() {

        LOGGER.log(Level.INFO, "Going to account settings... \n");

        this.clickAccountName();
        this.clickAccount();
    }

    public void goTo() {
        this.driver.get(cookiesURL);
    }

    public String getCookiesURL() {
        return cookiesURL;
    }

    public void continueWatching() throws InterruptedException {
        Thread.sleep(10000);
        tryClickingNTimes(watching,2);
    }

    public void observeCBSLogoIsDisplayedOnTheTopLeft() {
        Assert.assertTrue(cbsLogo1.isDisplayed());
    }

    public String whichUsertypeAmI(String userType) {

        LOGGER.log(Level.INFO, "Verifying user type... \n");

        boolean signInIsVisible = false;
        boolean profileNameIsVisible = false;
        boolean mvpdLogoIsVisible = false;

        String user = "undefined";

        try {
            signInIsVisible = isOptionDisplayed(signInOptionsButton);
            profileNameIsVisible = isOptionDisplayed(userProfileName);
            mvpdLogoIsVisible = isOptionDisplayed(mvpdLogo);

        } catch (NoSuchElementException | TimeoutException e) {
            e.printStackTrace();
        }

        if (signInIsVisible) {
            if (mvpdLogoIsVisible) {
                user = "Ghost";
            } else {
                user = "Anonymous";
            }

        } else if (profileNameIsVisible) {
            if (mvpdLogoIsVisible) {
                user = "AuthZ";
            } else {
                user = "Registered";
            }
        }
        return user;
    }

    public void disconnectMVPD() {

        LOGGER.log(Level.INFO, "Disconnecting MVPD... \n");

        this.account.goTo();
        this.account.clickDisconnect();
    }

    public void setUserType(String str) {
        this.test = str;
    }

    public String getUserType() {
        return this.test;
    }

    public void clickAccountName() {
        returnVerifiedElement(userProfileName).click();
    }

    public void clickAccount() {
        returnVerifiedElement(accountButton).click();
    }

}
