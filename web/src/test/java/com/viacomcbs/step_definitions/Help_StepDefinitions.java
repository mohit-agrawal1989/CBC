package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest(classes = WebSpringApplication.class)
public class Help_StepDefinitions {

    private final Logger LOGGER = Logger.getLogger(HelpContactUs_PageObject.class.getName());

    @LazyAutowired
    private Home_PageObject home;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @Autowired
    protected LiveTv_PageObject livetv;

    @LazyAutowired
    private SignIn_PageObject signin;

    // consolidated from HelpContactUs_StepDefinitions.java
    @LazyAutowired
    private HelpContactUs_PageObject helpContactUs;

    // consolidated from HelpContactUs_StepDefinitions.java
    @Then("I am at the Help\\/Contact page")
    public void i_am_at_the_help_contact_page() {

        LOGGER.log(Level.INFO, "Verifying user is on help contacts us page... \n");

        Assert.assertTrue(this.helpContactUs.iAmHere(), "Not in " + this.helpContactUs.getHelpContactUsPageURL());

        LOGGER.log(Level.INFO, "User is on help contacts us page... \n");

    }

    @Then("I observe Selecting Help takes the user to the CBS Help page")
    public void i_observe_selecting_help_takes_the_user_to_the_cbs_help_page(){

        livetv.observeSelectingHelpTakesTheUserToTheCBSHelpPage();
    }
}
