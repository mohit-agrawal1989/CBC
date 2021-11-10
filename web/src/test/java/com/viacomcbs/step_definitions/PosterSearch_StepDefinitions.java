package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.Account_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;

import main.java.com.viacomcbs.page_objects.Search_PageObject;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest(classes = WebSpringApplication.class)
public class PosterSearch_StepDefinitions {
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

    @LazyAutowired
    private Search_PageObject search;

    @Value("${searchPageURL}")
    private String searchPageURL;


    @Then("I type show and Posters from the search results are selectable and in high-res")
    public void i_type_show_and_posters_from_the_search_results_are_selectable_and_in_high_res() {
        this.search.showAndPostersFromTheSearchResultsAreSelectableAndInHighRes();

        String actualPageUrl=driver.getCurrentUrl();

        String  expectedPageUrl=searchPageURL ;

        Assert.assertEquals(actualPageUrl,expectedPageUrl);
    }
}
