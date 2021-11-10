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
public class Guest_StepDefinitions {
    @LazyAutowired
    private Home_PageObject home;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private SignIn_PageObject signin;
    @LazyAutowired
    private DropDown_PageObject dropdown;

    @Then("I observe user name on the dropdown menu displays Guest for TV Provider Name user")
    public void i_observe_user_name_on_the_dropdown_menu_displays_guest_for_tv_provider_name_user(){
        this.dropdown.observeUserNameOnTheDropDownMenuDisplaysGuestForTvProviderNameUser();
    }

}
