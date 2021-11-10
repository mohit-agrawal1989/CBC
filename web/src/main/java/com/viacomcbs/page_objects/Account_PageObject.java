package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class Account_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Account_PageObject.class.getName());

    @Value("${env:}")
    private String env;

    @FindBy(xpath = "(//div[@class='user-profile-name'])[1]")
    private WebElement dropTheAccount;

    @FindBy(xpath = "(//a[@href='/account/'])[1]")
    private WebElement accountSelect;

    @Value("${accountPageURL}")
    private String accountPageURL;

    @FindBy(css = "html > body > main > div > div:nth-of-type(2) > div > span > section:nth-of-type(2) > div:nth-of-type(2) > div > button")
    private WebElement disconnect;

    public void goTo() {
        this.driver.get("https://" + env + ".cbs.com/account/");
    }

    public void selectingAccountTakesUserToAccountPage() {

        LOGGER.log(Level.INFO, "Selecting the account... \n");

        waitForPageLoaded();
        getActions().moveToElement(dropTheAccount).build().perform();
        this.wait.until((d) -> dropTheAccount.isDisplayed());
        accountSelect.click();
        assertPageEquals(accountPageURL);

    }

    public boolean iAmHere() {
        return this.atURL(accountPageURL);
    }

    public void clickDisconnect() {

        LOGGER.log(Level.INFO, "Clicking disconnect... \n");

        (this.returnVerifiedElement(this.disconnect, 10)).click();
    }

    public String getAccountPageURL() {

        LOGGER.log(Level.INFO, "Getting Account Page URL... \n");

        return accountPageURL;
    }

}
