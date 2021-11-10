package test.java.com.viacomcbs.step_definitions;
import com.slack.api.audit.response.ActionsResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class NavigationAfterSignIn_StepDefinitions {
    @LazyAutowired
    private Home_PageObject home;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private SignIn_PageObject signin;
    @LazyAutowired
    private Navigation_PageObject navigation;

    @Then("I observe Home | Shows | Live TV | Schedule | TV Provider | Search | Sign In Options | Try Paramount+")
    public void i_observe_home_shows_live_tv_schedule_tv_provider_search_sign_in_options_try_paramount(){
        this.home.iAmHere();
        this.navigation.observeHomeShowsLiveTVScheduleTVProviderSearchSignInOptionsTryParamount();
    }
}