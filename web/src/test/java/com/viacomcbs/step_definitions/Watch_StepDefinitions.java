package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebSpringApplication.class)
public class Watch_StepDefinitions {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected FluentWait<WebDriver> wait;

    @LazyAutowired
    private Watch_PageObject watch;

   @When("I click on Shows and i am on the shows page")
    public void i_click_on_shows_and_i_am_on_the_shows_page() {

       watch.i_click_on_shows_and_i_am_on_the_shows_page()
       ;
    }

    @When("I select on the Show")
    public void i_select_on_the_show() {
       watch.i_select_on_the_show();
    }

    @Then("I select Full Episodes and observe the Watch")
    public void i_select_full_episodes_and_observe_the_watch() {
       watch.i_select_full_episodes_and_observe_the_watch();
   }

    @Then("I select Shows page, select a show, and select Full Episodes and observe watch page.")
    public void i_select_shows_page_select_a_show_and_select_full_episodes_and_observe_watch_page(){
        this.watch.selectShowsPageSelectAShowAndSelectFullEpisodesAndObserveWatchPage();
    }

    @Then("I observe Edit mode turns off")
    public void i_observe_edit_mode_turns_off() {
        this.watch.observeEditModeTurnsOff();
    }

    @Then("I observe Requested Shows video episode resumes")
    public void i_observe_requested_shows_video_episode_resumes() {
        this.watch.observeRequestedShowsVideoEpisodesResumes();
    }

    @Then("I observe Edit mode turns on; Cancel, Remove and select options displayed")
    public void i_observe_edit_mode_turns_on_cancel_remove_and_select_options_displayed() {
        this.watch.observeEditModeTurnsOnCancelRemoveAndSelectOptionsDisplayed();
    }

    @Then("I observe Thumbnail outstands")
    public void i_observe_thumbnail_outstands() {
        this.watch.observeThumbnilOutstands();
    }

    @Then("I observe Selected thumbnails removed")
    public void i_observe_selected_thumbnails_removed() {
        this.watch.obsrveSelectedThumbnailsRemoved();
    }

    @Then("I observe Thumbnails within carousel scroll through")
    public void i_observe_thumbnails_within_carousel_scroll_through() {
        this.watch.observeThumbnailsCarouselScrollThrough();
    }
}
