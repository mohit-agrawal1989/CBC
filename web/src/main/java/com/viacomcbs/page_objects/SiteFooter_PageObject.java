package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;


@PageObject
public class SiteFooter_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(SiteFooter_PageObject.class.getName());

    @Value("${copyrightText:}")
    private String copyrightText;

    @Value("${showsPageURL:}")
    private String showsPageURL;

    @Value("${helpContactUsPageURL:}")
    private String helpContactUsPageURL;

    @Value("${privacyPolicyURL:}")
    private String privacyPolicyURL;

    @Value("${termsOfUseURL:}")
    private String termsOfUseURL;

    @Value("${cookiesURL:}")
    private String cookiesURL;

    @FindBy(className = "siteDisclaimer")
    private WebElement copyright;

    @FindBy(css = "html > body > footer > div > div:nth-of-type(1) > ul:nth-of-type(3) > li:nth-of-type(2) > a")
    private WebElement helpContactUs;

    @FindBy(css = "html > body > footer > div > div:nth-of-type(1) > ul:nth-of-type(2) > li:nth-of-type(3) > a")
    private WebElement privacyPolicy;

    @FindBy(css = "html > body > footer > div > div:nth-of-type(1) > ul:nth-of-type(2) > li:nth-of-type(2) > a")
    private WebElement termsOfUse;

    @FindBy(css = "html > body > footer > div > div:nth-of-type(1) > ul:nth-of-type(2) > li:nth-of-type(4) > a")
    private WebElement cookies;

    public String getCopyrightText() {
        return copyrightText;
    }

    public void goTo() {
        scrollToElement(this.copyright);
    }

    public boolean iAmHere() {
        Assert.assertTrue(this.atURL(showsPageURL), "Not in " + showsPageURL);
        Assert.assertNotNull(this.returnVerifiedElement(this.copyright), "Cannot find copyright");
        return false;
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickOnHelpContactUs() {
        clickOnElement(this.helpContactUs);
    }

    public void clickOnPrivacyPolicy() {
        clickOnElement(this.privacyPolicy);
    }

    public void clickOnTermsOfUse() {
        clickOnElement(this.termsOfUse);
    }

    public void clickOnCookies() {
        clickOnElement(this.cookies);
    }

    public void tabToHelpContactUs() {
        tabToPage(helpContactUsPageURL);}

    public void the_copyright_reads_properly() {
        Assert.assertTrue(copyrightIsCorrect(), "Site Footer should be " + (174) + " " + getCopyrightText());
    }


    public void tabToPage(String pageUrl) {
        boolean here = false;

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofMillis(4000))
                .pollingEvery(Duration.ofMillis(400));

        here = fluentWait.until(dr -> {
            boolean isHere = false;
            try {
                String currentUrl = dr.getCurrentUrl();
                if (currentUrl.contentEquals(pageUrl)) {
                    isHere = true;
                } else {
                    ArrayList<String> tabs = new ArrayList<String>(dr.getWindowHandles());
                    tabs.remove(dr.getWindowHandle());
                    if (tabs.size() != 0) {
                        driver.switchTo().window(tabs.get(0));
                    }
                }
            } catch (TimeoutException e) {
                e.getStackTrace();
            }
            return isHere;
        });

    }

    public void tabToPrivacyPolicy() {

        LOGGER.log(Level.INFO, "Tabbing to Privacy Policy... \n");

        tabToPage(privacyPolicyURL); }


    public void tabToTermsOfUse() {
        LOGGER.log(Level.INFO, "Tabbing to Terms of Use... \n");

        tabToPage(termsOfUseURL);
    }
    public void tabToCookies() {

        LOGGER.log(Level.INFO, "Tabbing to Cookies... \n");

        tabToPage(cookiesURL);
    }

    public boolean copyrightIsCorrect() {

        LOGGER.log(Level.INFO, "Verifying that copyright is correct... \n");

        wait.until(ExpectedConditions.visibilityOf(copyright));
        return (this.copyright.getText()).contains(copyrightText);
    }
}
