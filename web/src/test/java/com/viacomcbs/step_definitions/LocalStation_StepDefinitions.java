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

public class LocalStation_StepDefinitions {
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

    @When("I select Tv provider and enter the email and password for credentials")
    public void i_select_tv_provider_and_enter_the_email_and_password_for_credentials() throws InterruptedException {

//        LiveTv_PageObject livetv = new LiveTv_PageObject();
        home.iAmHere();
        livetv.selectTvProviderAndEnterTheEmailAndPasswordForCredentials();
        Thread.sleep(10000);
    }
    @Then("I select livetv options and click on local station and obseve the stream")
    public void i_select_livetv_options_and_click_on_local_station_and_obseve_the_stream() throws InterruptedException {

        livetv.selectLiveTVOptionsAndClickOnLocalStationAndObserveTheStream();
    }
}