package test.java.com.viacomcbs.step_definitions;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import main.java.com.viacomcbs.WebSpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.time.Duration;
@SpringBootTest(classes = WebSpringApplication.class)
public class Navigation_StepDefinitions{
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;
    @LazyAutowired
    private Home_PageObject home;
    @LazyAutowired
    private Navigation_PageObject navigation;

    @Then("I observe Home | Shows | Live TV | Schedule | TV Provider | Search | Sign In Options | Try Paramount+ is displayed")
    public void i_observe_home_shows_live_tv_schedule_tv_provider_search_sign_in_options_try_paramount_is_displayed(){
        this.home.iAmHere();
        this.navigation.observeHomeShowsLiveTVScheduleTVProviderSearchSignInOptionsTryParamountIsDisplayed();
    }
}