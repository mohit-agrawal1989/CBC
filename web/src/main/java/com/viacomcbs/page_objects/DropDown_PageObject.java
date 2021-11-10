package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class DropDown_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(DropDown_PageObject.class.getName());

    @FindBy(xpath = "(//a[@href='/account/signin/' and normalize-space()='Sign In'])[1]")
    private WebElement signIn;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement pass;

    @FindBy(how = How.CSS, xpath = "//div[@class='button__text' and normalize-space()='Continue']")
    private WebElement contin;

    @Value("${homePageURL}")
    private String homePageURL;

    @FindBy(how = How.CSS, using = "button.filter.current-userprofile-anchor > div.user-profile-name")
    private WebElement drop;

    @FindBy(xpath = "//*[@id=\"user-profiles-menu-trigger\"]/li[1]/button/div")
    private WebElement guest;

    @Value("${signInPageURL}")
    private String signInPageURL;

    @Value("${registeredemail}")
    private String emailPut;

    @Value("${registeredpassword}")
    private String passPut;

    public void clickOnSignInButton() {

        LOGGER.log(Level.INFO, "Signing in... \n");
        waitUntilElementIsVisible(this.signIn);
        waitUntilElementIsClickable(this.signIn);
        signIn.click();
    }

    public void observeUserNameOnTheDropDownMenuDisplaysGuestForTvProviderNameUser() {

        LOGGER.log(Level.INFO, "Observing username on the dropdown menu display... \n");

        waitForPageLoaded();
        driver.manage().window().maximize();
        getActions().moveToElement(guest).build().perform();
        Assert.assertTrue(guest.isDisplayed());
        Assert.assertEquals(guest.getText(), "GUEST");

    }

    public void observeUserNameDropdownMenuDisplaysFirstNameForRegisteredUser() throws InterruptedException {

        //TODO: refactor - verifying first name displayed is missing, this only verifies if user is on home page

        LOGGER.log(Level.INFO, "Observing username on the dropdown menu display... \n");

        Thread.sleep(10000);
        getActions().moveToElement(drop).build().perform();
        this.wait.until((d) -> drop.isDisplayed());
        Assert.assertTrue(drop.isDisplayed());

    }

    public void enterTheEmailAndPasswordInSignInPage() {

        LOGGER.log(Level.INFO, "Entering credentials... \n");

        driver.get(signInPageURL);
        email.sendKeys(emailPut);
        pass.sendKeys(passPut);
        contin.click();

    }

    public void observeUserNameDropDownMenuContainsAccountHelpAndSignOutItems() throws InterruptedException {

        //TODO: refactor - verifying sign out and help is missing, this only verifies if user is on home page
        LOGGER.log(Level.INFO, "Observing dropdown menu contains Help and Sign Out items... \n");

        Thread.sleep(10000);
        getActions().moveToElement(drop).build().perform();
        this.wait.until((d) -> drop.isDisplayed());
        assertPageEquals(homePageURL);

    }
}
