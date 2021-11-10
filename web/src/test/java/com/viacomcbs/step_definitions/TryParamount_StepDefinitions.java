package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.When;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebSpringApplication.class)
public class TryParamount_StepDefinitions {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private TryParamount_PageObject tryParamount;

    @When("I Browse the site as an anonymous user and observe the CTA for Try Paramount+")
    public void i_browse_the_site_as_an_anonymous_user_and_observe_the_cta_for_try_paramount(){
        this.tryParamount.browseTheSiteAsAnAnonymousUserAndObserveTheCTAForTryParamount();
    }

    @When("I Log in with unbinded registered user and Observe the CTA for Try Paramount+ and sign out")
    public void i_log_in_with_unbinded_registered_user_and_observe_the_cta_for_try_paramount_and_sign_out(){
        this.tryParamount.logInWithUnbindedRegisteredUserAndObserveTheCTAForTryParamountAndSignOut();
    }

    @When("I Log in with a binded registered user and TV Provider and click Start Watching")
    public void i_log_in_with_a_binded_registered_user_and_tv_provider_and_click_start_watching(){
        this.tryParamount.logInWithABindedRegisteredUserAndTVProviderAndClickStartWatching();
    }
    }

