package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.Account_PageObject;
import main.java.com.viacomcbs.page_objects.HelpContactUs_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest(classes = WebSpringApplication.class)
public class SelectingRead_StepDefinition {

    @LazyAutowired
    private Home_PageObject home;
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private SignIn_PageObject signin;

    @LazyAutowired
    private Account_PageObject accountPage;

    @Value("${helpContactUsPageURL}")
    private String helpContactUsPageURL;

    @LazyAutowired
    private HelpContactUs_PageObject helpContactUs;


    @Then("I observe Selecting Read redirects the user to Help Center")
    public void i_observe_selecting_read_redirects_the_user_to_help_center() {
        this.helpContactUs.observeSelectingReadRedirectsTheUserToHelpCenter();

        driver.get(helpContactUsPageURL);
        String actualPageUrl=driver.getCurrentUrl();
        String  expectedPageUrl=  helpContactUsPageURL;
        Assert.assertEquals(actualPageUrl,expectedPageUrl); }

    }

