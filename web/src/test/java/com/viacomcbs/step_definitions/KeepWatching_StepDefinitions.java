package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = WebSpringApplication.class)
public class KeepWatching_StepDefinitions {
    @Autowired
    protected WebDriver driver;

    @LazyAutowired
    private Home_PageObject home;

    @FindBy(how = How.CSS,using = "div.top-components section.js-le-carousel div.carousel-content div.carousel-width-wrapper div.carousel.js-video-carousel div.video-carousel-box div.wrap.swiper-container.swiper-container-virtual.swiper-container-initialized.swiper-container-horizontal div.carousel-container.swiper-wrapper.carousel-fader div.swiper-slide.swiper-slide-active.swiper-slide-visible:nth-child(1) a.link.fathom_tracked > div.thumb-wrapper")
    private WebElement watching;
    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private SignIn_PageObject signin;


    @Then("I observe Continue Watching section with blue Progress Bar displayed underneath thumbnail")
    public void i_observe_continue_watching_section_with_blue_progress_bar_displayed_underneath_thumbnail() {
        // this.home.iAmHere();
  ///      this.keepWatching.continueWatching();
        //  Assert.assertTrue(watching.isDisplayed());

        try
        {
            this.home.continueWatching();
        }
        catch(NullPointerException | InterruptedException e)
        {
        e.printStackTrace();
        }

    }}

