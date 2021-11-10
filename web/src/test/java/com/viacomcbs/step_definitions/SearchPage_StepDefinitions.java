package test.java.com.viacomcbs.step_definitions;
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
public class SearchPage_StepDefinitions {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;
    @LazyAutowired
    private Home_PageObject home;
    @LazyAutowired
    private Search_PageObject search;

    @Then("I observe on Selecting search icon takes user to Search page is displayed")
    public void i_observe_on_selecting_search_icon_takes_user_to_search_page_is_displayed() throws InterruptedException {
        this.home.iAmHere();
        this.search.observeOnSelectingSearchiconTakesUserToSearchPageIsDisplayed();
    }

}
