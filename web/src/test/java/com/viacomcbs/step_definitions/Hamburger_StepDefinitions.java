package test.java.com.viacomcbs.step_definitions;
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
public class Hamburger_StepDefinitions {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected FluentWait<WebDriver> wait;
    @LazyAutowired
    private Home_PageObject home;

    @Then("I observe on smaller screens: hamburger menu is displayed on far left instead of the nav menu is displayed")
    public void i_observe_on_smaller_screens_hamburger_menu_is_displayed_on_far_left_instead_of_the_nav_menu_is_displayed(){
        home.iAmHere();
        home.observeOnSmallerScreensHamburgerMenuIsDisplayedOnFarLeft();
    }
}