package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import main.java.com.viacomcbs.page_objects.SignUp_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.Account_PageObject;
import main.java.com.viacomcbs.page_objects.ForgotPassword_PageObject;
import org.testng.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Then;

import java.util.logging.Logger;
import java.util.logging.Level;


@SpringBootTest(classes = WebSpringApplication.class)
public class Account_StepDefintions {

    @LazyAutowired
    private Home_PageObject home;

    @LazyAutowired
    private SignIn_PageObject signin;

    @LazyAutowired
    private ForgotPassword_PageObject forgotpassword;

    @LazyAutowired
    private SignUp_PageObject signup;

    @LazyAutowired
    private Account_PageObject account;

    private final Logger LOGGER = Logger.getLogger(Account_StepDefintions.class.getName());

    @Then("I am at the Account page")
    public void i_am_at_the_account_page() {

        LOGGER.log(Level.INFO, "Validating user is on account page...  \n");

        Assert.assertTrue(this.account.iAmHere(), "Not at " + this.account.getAccountPageURL());

        LOGGER.log(Level.INFO, "User is on account page.  \n");
    }

    @Then("I observe Selecting Account takes the user to their Account page")
    public void i_observe_selecting_account_takes_the_user_to_their_account_page() throws InterruptedException {

        LOGGER.log(Level.INFO, "Validating user is taken to account page after selecting account...  \n");

        this.account.selectingAccountTakesUserToAccountPage();

        LOGGER.log(Level.INFO, "User is taken to account page after selecting account.  \n");

    }
}
