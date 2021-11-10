package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.Shows_PageObject;
import main.java.com.viacomcbs.page_objects.Utility_PageObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest(classes = WebSpringApplication.class)
public class Shows_StepDefinitions {

	private final Logger LOGGER = Logger.getLogger(Account_StepDefintions.class.getName());

	@LazyAutowired
	public Shows_PageObject shows;

	@LazyAutowired
	public Utility_PageObject utility_pageObject;

	@Value("${showsPageURL:}")
	private String showsPageURL;
	
	@Then("I am at the Shows page")
	public void  i_am_at_the_shows_page(){

		LOGGER.log(Level.INFO, "Validating user is on shows page...  \n");

		shows.i_am_at_the_shows_page();

		LOGGER.log(Level.INFO, "User is on shows page.  \n");

	}

	@When("I navigate to the Shows Page")
	public void i_navigate_to_the_shows_page() {

		LOGGER.log(Level.INFO, "Navigating to the shows page...  \n");

		shows.goTo();

		utility_pageObject.assertPageEquals(showsPageURL);

		LOGGER.log(Level.INFO, "Landed on the shows page.  \n");

	}

	//TODO No assertion currently
	@When("I click on the first show")
	public void i_click_on_the_first_show() {

		LOGGER.log(Level.INFO, "Clicking on the first show...  \n");

		Assert.assertTrue(shows.clickOnShow(0));

		LOGGER.log(Level.INFO, "Clicked on the first show.  \n");
	}
	
	@When("I click on the show titled {string}")
	public void i_click_on_the_show_titled(String string) {

		LOGGER.log(Level.INFO, "Clicking on the show...  \n");

		Assert.assertTrue(shows.clickOnShow(string));

		LOGGER.log(Level.INFO, "Clicked on the show.  \n");

	}

}
