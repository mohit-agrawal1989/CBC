package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.BasePage;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.TermsOfUse_PageObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootTest(classes = WebSpringApplication.class)
public class Cookies_StepDefintions {

    @LazyAutowired
    private BasePage basepage;

    @LazyAutowired
    private Home_PageObject home;

    private final Logger LOGGER = Logger.getLogger(CBSSports_StepDefinitions.class.getName());

    @Then("I am at the Cookies page")
    public void i_am_at_the_Cookies_page() {

        LOGGER.log(Level.INFO, "Verifying user is on cookies page...  \n");

        Assert.assertTrue(home.iAmHereCookies());

        LOGGER.log(Level.INFO, "User is on cookies page...  \n");

    }


}
