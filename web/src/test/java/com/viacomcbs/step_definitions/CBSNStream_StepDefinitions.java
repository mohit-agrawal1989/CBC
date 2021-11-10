package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.LiveTv_PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest(classes = WebSpringApplication.class)
public class CBSNStream_StepDefinitions {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private LiveTv_PageObject livetv;

    private final Logger LOGGER = Logger.getLogger(CBSNStream_StepDefinitions.class.getName());

    @Then("I select livetv option and click on CBSN News and observe the stream")
    public void i_select_livetv_option_and_click_on_cbsn_news_and_observe_the_stream() throws InterruptedException {

        LOGGER.log(Level.INFO, "User is on account page...  \n");

        Assert.assertTrue(livetv.selectLiveTvOptionAndClickOnCBSNNewsAndObserveTheStream());

        LOGGER.log(Level.INFO, "User is observing the stream.  \n");


    }
}