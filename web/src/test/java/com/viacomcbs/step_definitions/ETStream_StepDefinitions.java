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
import java.time.Duration;

@SpringBootTest(classes = WebSpringApplication.class)
public class ETStream_StepDefinitions {

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

    @Then("I select livetv options and click on ET Live and observe the stream")
    public void i_select_livetv_options_and_click_on_et_live_and_observe_the_stream() throws InterruptedException{
        this.home.iAmHere();
        this.livetv.selectLiveTVOptionAndClickOnEtLiveAndObserveTheStream();
    }
}
