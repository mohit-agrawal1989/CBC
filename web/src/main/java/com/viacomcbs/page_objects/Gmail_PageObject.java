package main.java.com.viacomcbs.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class Gmail_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Gmail_PageObject.class.getName());

    @Value("${env:}")
    private String env;

    @FindBy(id = "identifierId")
    private WebElement email;

    @FindBy(id = "identifierNext")
    private WebElement next;

    public void goTo() {
        this.driver.get("https://mail.google.com");
    }

    public boolean iAmHere() {

        LOGGER.log(Level.INFO, "Verifying the URL... \n");

        String currentUrl = this.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://accounts.google.com/"), currentUrl + " != " + "https://accounts.google.com/");
        return false;
    }

    public void enterEmail(String emailAddress) {

        LOGGER.log(Level.INFO, "Entering email... \n");

        (this.returnVerifiedElement(this.email)).click();
        (this.returnVerifiedElement(this.email)).sendKeys(emailAddress);
        (this.returnVerifiedElement(this.next)).click();
    }


}
