package test.java.com.viacomcbs.step_definitions;
import com.slack.api.audit.response.ActionsResponse;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import  org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import java.time.Duration;
import java.util.logging.Level;

@SpringBootTest(classes = WebSpringApplication.class)
public class CBSSports_StepDefinitions {
    @LazyAutowired
    private Home_PageObject home;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private SignIn_PageObject signin;

    @LazyAutowired
    private LiveTv_PageObject livetv;

    private final Logger LOGGER = Logger.getLogger(CBSSports_StepDefinitions.class);

    @Then("I select livetv option and click on CBS Sports and observe the stream")
    public void i_select_livetv_option_and_click_on_cbs_sports_and_observe_the_stream() throws InterruptedException {

        //LOGGER.log(Level.INFO, "User is navigating to CBS Sports page...  \n");

        Assert.assertTrue(livetv.selectLiveTvOptionAndClickOnCBSNSportsAndObserveTheStream());

        //LOGGER.log(Level.INFO, "User is observing the stream.  \n");

    }
}