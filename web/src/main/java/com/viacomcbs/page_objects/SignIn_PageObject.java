package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.LazyAutowired;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
public class SignIn_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(SignIn_PageObject.class.getName());

    @Value("${env:}")
    private String env;

    @Value("${pPlusRegAccount:}")
    private String pPlusRegAccount;

    @Value("${registeredAccountCredentials:}")
    private String registeredAccountCredentials;

    @Value("${signInPageURL}")
    private String signInPageURL;

    @Value("${signInWithTVProviderURL}")
    private String signInWithTVProviderPageURL;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//div[@class='button__text' and normalize-space()='Continue']")
    private WebElement continuebtn;

    @FindBy(className = "form-message")
    private WebElement errorMessage;

    @FindBy(className = "text-input-error")
    private WebElement emailErrorMessage;

    @FindBy(className = "form-link")
    private WebElement forgotPassword;

    @FindBy(className = "qt-emailtxtfield")
    private WebElement email1;

    @FindBy(xpath = "//*[@id=\"main-aa-container\"]/section/div/div[4]/div/div")
    private WebElement signInWithTVProvider;

    @FindBy(className = "qt-signup")
    private WebElement signUp;

    @FindBy(how = How.CSS, using = "li.header__nav--withsubMenu button.filter.current-userprofile-anchor > div.user-profile-name")
    private WebElement drop1;

    @FindBy(how = How.CSS, using = "ul.header__subnav.content li:nth-child(4) > a.js-user-logout")
    private WebElement signOut;

    @Value("${homePageURL}")
    private String homePageURL;

    @Value("${signInWithTVProviderURL:}")
    private String signInWithTVProviderURL;

    @Value("${waveBroadbandCredentials:}")
    private String waveBroadbandCredentials;

    @Value("${greatPlainsCommunicationsCredentials:}")
    private String greatPlainsCommunicationsCredentials;

    @Value("${bindedRegisteredAccountCredentialsAndUsername:}")
    private String bindedRegisteredAccountCredentialsAndUsername;

    @FindBy(className = "js-dropdown")
    private WebElement moreProviders;

    @FindBy(css = "a[data-providerid=wavebroadband]")
    private WebElement waveBroadband;

    @FindBy(css = "a[data-providerid=gpcom]")
    private WebElement greatPlainsCommunications;

    @FindBy(id = "username")
    private WebElement mvpdEmail;

    @FindBy(id = "password")
    private WebElement mvpdPassword;

    @FindBy(css = "#content > form > table > tbody > tr:nth-of-type(5) > td:nth-of-type(2) > input:nth-of-type(3)")
    private WebElement greatPlainsCommunicationsLogin;

    @FindBy(css = "#content > form > table > tbody > tr:nth-of-type(7) > td:nth-of-type(2) > input:nth-of-type(3)")
    private WebElement waveBroadbandLogin;

    @FindBy(id = "mvpd__signin")
    private WebElement mvpdSuccessScreenCbsSignIn;//this is not popping up either because it's out of view or the mvpd is binded

    @FindBy(className = "qt-continuebtn")
    private WebElement bindedContinue;

    @FindBy(id = "mvpd__getstarted")
    private WebElement startWatching;

    @FindBy(id = "mvpd__signup")
    private WebElement createAnAccount;

    @LazyAutowired
    private Home_PageObject home;

    @LazyAutowired
    private SignIn_PageObject signin;

    public String getSignInPageURL() {
        return signInPageURL;
    }

    public void goTo() {
        this.driver.get("https://" + env + ".cbs.com/account/signin/");
    }

    public void iAmHereSignIn() {
        waitForPageLoaded();
         Assert.assertEquals(signInPageURL, driver.getCurrentUrl());
    }

    public void iAmHereSignInWithTvProvider() {
        assertPageEquals(signInWithTVProviderPageURL);
    }

    public void iAmHereEmail() {
        assertPageEquals(signInPageURL);
    }

    public void enterCredentials(String email, String pwd) {

        LOGGER.log(Level.INFO, "Entering credentials... \n");

        (this.returnVerifiedElement(this.email)).sendKeys(email);
        (this.returnVerifiedElement(this.password)).sendKeys(pwd);
    }

    public void signInAsRegistered() {

        LOGGER.log(Level.INFO, "Signing in as registered... \n");

        String username = registeredAccountCredentials.split("\\|")[0];
        String password = registeredAccountCredentials.split("\\|")[1];
        this.enterCredentials(username, password);
        this.clickContinueBtn();
    }

    public void enterPPlusCredentials() {

        LOGGER.log(Level.INFO, "Entering P+ credentials... \n");

        (this.returnVerifiedElement(this.email)).sendKeys(pPlusRegAccount.split("\\|")[0]);
        (this.returnVerifiedElement(this.password)).sendKeys(pPlusRegAccount.split("\\|")[1]);
    }

    public void observeSelectingSignOutSignsTheUserOut() {

        LOGGER.log(Level.INFO, "Verifying Sign Out functionality... \n");

        getActions().moveToElement(drop1).build().perform();
        signOut.click();
        waitForPageLoaded();
        assertPageEquals(homePageURL);
    }

    public void clickContinueBtn() {

        LOGGER.log(Level.INFO, "Clicking Continue button... \n");

        (this.returnVerifiedElement(this.continuebtn)).click();
    }

    public void clickForgotPasswordBtn() {

        LOGGER.log(Level.INFO, "Clicking Forgot Password button... \n");

        (this.returnVerifiedElement(this.forgotPassword)).click();
    }

    public String isAtHomePage() {
        return this.driver.getTitle();
    }

    public boolean continueCtaIsDisabled() {

        LOGGER.log(Level.INFO, "Verifying that Continue CTA is disabled... \n");

        boolean isDisabled = false;
        String classAttribute = (this.returnVerifiedElement(this.continuebtn)).getAttribute("class");
        if (classAttribute.contains("disabled")) {
            isDisabled = true;
        }
        return isDisabled;
    }

    public void emailFieldDisplaysCurrentEmail() {
        Assert.assertTrue(email1.isDisplayed());
    }

    public boolean invalidEmailPasswordPopsUp() {

        LOGGER.log(Level.INFO, "Verifying invalid email password Pop Up.. \n");

        String msg = (this.returnVerifiedElement(this.errorMessage)).getAttribute("innerHTML");
        return msg.contains("Invalid email and/or password");
    }

    public boolean invalidEmail() {

        LOGGER.log(Level.INFO, "Verifying invalid email Pop Up.. \n");

        String msg = (this.returnVerifiedElement(this.emailErrorMessage)).getAttribute("innerHTML");
        return msg.contains("Valid email required.");
    }

    public boolean legibleForgotPassword() {

        LOGGER.log(Level.INFO, "Verifying Forgot Password button.. \n");

        String msg = (this.returnVerifiedElement(this.forgotPassword)).getAttribute("innerHTML");
        return msg.contains("Forgot Password?");
    }

    public boolean signInWithTVProviderIsPresented() {

        LOGGER.log(Level.INFO, "Verifying Sign In with TV Provider.. \n");


        return (this.returnVerifiedElement(this.signInWithTVProvider)).isDisplayed() &&
                (this.returnVerifiedElement(this.signInWithTVProvider)).getText().toLowerCase().contains("sign in with tv provider");
    }

    public void clickSignInWithTVProvider() {
        (this.returnVerifiedElement(this.signInWithTVProvider)).click();
    }

    public boolean signUpIsLegible() {

        LOGGER.log(Level.INFO, "Verifying Sign Up.. \n");

        boolean legible;

        Wait<String> fluentWait = new FluentWait<String>("create account")
                .withTimeout(Duration.ofMillis(8000))
                .pollingEvery(Duration.ofMillis(400));

        legible = fluentWait.until(new Function<String, Boolean>() {
            public Boolean apply(String str) {
                boolean isLegible = false;
                try {
                    String text = signUp.getText();
                    if (text.toLowerCase().contains(str)) {
                        isLegible = true;
                    }
                } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException | NullPointerException e) {
                    e.getStackTrace();
                }
                return isLegible;
            }
        });

        return legible;
    }

    public void clickSignUp() {

        LOGGER.log(Level.INFO, "Clicking on Sign Up.. \n");

        (this.returnVerifiedElement(this.signUp)).click();
    }

    public void clickMoreProviders() {
        LOGGER.log(Level.INFO, "Clicking More Providers.. \n");

        (this.returnVerifiedElement(this.moreProviders)).click();
    }

    public void scrollToMoreProviders() {

        LOGGER.log(Level.INFO, "Scrolling to More Providers.. \n");

        scrollToElement(this.moreProviders);
    }

    public void scrollToWaveBroadband() {

        LOGGER.log(Level.INFO, "Scrolling to Wave BroadBand.. \n");

        scrollToElement(this.waveBroadband);
    }

    public void scrollToGreatPlainsCommunications() {

        LOGGER.log(Level.INFO, "Scrolling to Great Plains Communications.. \n");

        scrollToElement(this.greatPlainsCommunications);
    }

    public void selectWaveBroadband() {

        LOGGER.log(Level.INFO, "Selecting Wave BroadBand.. \n");

        (this.returnVerifiedElement(this.waveBroadband)).click();
    }

    public void selectGreatPlainsCommunications() {

        LOGGER.log(Level.INFO, "Selecting Great Plains Communications.. \n");

        (this.returnVerifiedElement(this.greatPlainsCommunications)).click();
    }

    public void signInToWaveBroadband() {

        LOGGER.log(Level.INFO, "Signing in to Wave BroadBand.. \n");

        String email = waveBroadbandCredentials.split("\\|")[0];
        String password = waveBroadbandCredentials.split("\\|")[1];
        (this.returnVerifiedElement(this.mvpdEmail)).sendKeys(email);
        (this.returnVerifiedElement(this.mvpdPassword)).sendKeys(password);
        (this.returnVerifiedElement(this.waveBroadbandLogin)).click();
    }

    public void signInToGreatPlainsCommunications() {

        LOGGER.log(Level.INFO, "Signing in to Great Plains Communications.. \n");

        String email = greatPlainsCommunicationsCredentials.split("\\|")[0];
        String password = greatPlainsCommunicationsCredentials.split("\\|")[1];
        (this.returnVerifiedElement(this.mvpdEmail)).sendKeys(email);
        (this.returnVerifiedElement(this.mvpdPassword)).sendKeys(password);
        (this.returnVerifiedElement(this.greatPlainsCommunicationsLogin, 20)).click();
    }

    public void clickSignInOnMVPDSuccessScreen() {

        LOGGER.log(Level.INFO, "Clicking on Sign In on MVPD success screen.. \n");

        (this.returnVerifiedElement(this.mvpdSuccessScreenCbsSignIn)).click();
    }

    public void clickStartWatching() {
        (this.returnVerifiedElement(this.startWatching)).click();
    }

    public void signInAsBindedRegisteredAccount() {

        LOGGER.log(Level.INFO, "Signing in as Binded Registered account.. \n");

        String user = this.bindedRegisteredAccountCredentialsAndUsername.split("\\|")[0];
        String password = this.bindedRegisteredAccountCredentialsAndUsername.split("\\|")[1];
        try {
            WebElement el = this.returnVerifiedElement(this.email);
            el.sendKeys(user);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            WebElement el = this.returnVerifiedElement(this.password);
            el.sendKeys(password);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            WebElement el = this.returnVerifiedElement(this.bindedContinue);
            el.click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void confirmSignedInAsBindedRegisteredAccount() {
        Assert.assertTrue(this.home.isOptionDisplayed(home.mvpdLogo));
        Assert.assertTrue(this.home.isUserProfileNameAMatchTo(bindedRegisteredAccountCredentialsAndUsername.split("\\|")[2]));
    }

    public boolean isPreghost() {
        return (this.returnVerifiedElement(this.createAnAccount) != null);
    }

    public void signInToMvpdWithGhost() {

        LOGGER.log(Level.INFO, "Signing in to MVPD with Ghost account.. \n");

        this.home.goToHome();
        this.home.clickSignInOptionsButton();
        this.signin.clickSignInWithTVProvider();
        this.scrollToMoreProviders();
        this.clickMoreProviders();
        this.scrollToGreatPlainsCommunications();
        this.selectGreatPlainsCommunications();
        this.signInToGreatPlainsCommunications();
        this.clickStartWatching();
        this.home.goToHome();

        if (!(this.home.isUserProfileNameAMatchTo("GUEST"))) {
            this.home.disconnectMVPD();
            this.signInToMvpdWithGhost();
        }
    }
}