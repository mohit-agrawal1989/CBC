package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class TryParamount_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(TryParamount_PageObject.class.getName());

    @FindBy(className = "button__text")
    private WebElement tryParamount;

    @Value("${homePageURL}")
    private String homePageURL;

    @FindBy(id = "js-li-sign-in")
    private WebElement signInOptions;

    @Value("${paramountPlusUpsellPageURL:}")
    private String paramountPlusUpsellPageURL;

    @FindBy(className = "qt-emailtxtfield")
    private WebElement email;

    @FindBy(className = "qt-passwordtxtfield")
    private WebElement pass;

    @FindBy(how = How.CSS, using = "a.button>div")
    private WebElement contin;

    @FindBy(className = "js-user-logout")
    private WebElement signOut;

    @FindBy(className = "user-profile-name\"")
    private WebElement afterSignIn;

    @FindBy(linkText = "TV Provider")
    private WebElement tvProvider;

    @FindBy(how = How.CSS, using = "div.slate__provider__box:nth-child(6) > a:nth-child(1)")
    private WebElement optimum;

    @FindBy(id = "username")
    private WebElement id;

    @FindBy(id = "password")
    private WebElement pass1;

    @FindBy(id = "signin_button")
    private WebElement button;

    String emailPut = "aqatv001p@gmail.com";

    String passPut = "aaaaaa";

    private String idPut = "research1001";

    private String passPut1 = "support1001";

    public void browseTheSiteAsAnAnonymousUserAndObserveTheCTAForTryParamount() {

        LOGGER.log(Level.INFO, "Browsing as an anonymous user... \n");

        waitForPageLoaded();

        tryParamount.click();
        Set<String> w = driver.getWindowHandles();
        Iterator<String> t = w.iterator();
        String ch = (String) t.next();
        String pw = (String) t.next();

        driver.switchTo().window(ch);

    }

    public String getParamountPlusUpsellPageURL() {
        return paramountPlusUpsellPageURL;
    }

    public boolean iAmHere() {
        return this.atURL(paramountPlusUpsellPageURL);
    }

    public void logInWithUnbindedRegisteredUserAndObserveTheCTAForTryParamountAndSignOut() {

        LOGGER.log(Level.INFO, "Logging in as Registered User... \n");


        waitForPageLoaded();

        driver.get(homePageURL);
        signInOptions.click();
        email.sendKeys(emailPut);
        pass.sendKeys(passPut);
        contin.click();
        driver.get(homePageURL);
        tryParamount.click();

        Set<String> w = driver.getWindowHandles();

        Iterator<String> t = w.iterator();

        String ch = (String) t.next();
        String pw = (String) t.next();
        driver.switchTo().window(ch);
        driver.get(homePageURL);
    }

    public void logInWithABindedRegisteredUserAndTVProviderAndClickStartWatching() {

        LOGGER.log(Level.INFO, "Logging in as Binded Registered User... \n");


        waitForPageLoaded();
        driver.get(homePageURL);
        tvProvider.click();
        optimum.click();
        id.sendKeys(idPut);
        pass1.sendKeys(passPut1);
        button.click();
        driver.get(homePageURL);

    }
}


