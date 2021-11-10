package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.entity.UserType;
import main.java.com.viacomcbs.page_objects.*;
//import main.java.com.viacomcbs.page_objects.Common_PageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.cucumber.java.en.*;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootTest(classes = WebSpringApplication.class)
public class Home_StepDefinitions {

	@Value("${bindedRegisteredAccountCredentialsAndUsername:}")
	String bindedRegisteredAccountCredentialsAndUsername;

	@Autowired
	private Home_PageObject home;

	@Autowired
	private SignIn_PageObject signin;

	@LazyAutowired
	public GlobalNavigation_PageObject globalNavigation;

	@Autowired
	ApplicationContext context;

	@Autowired
	private UserType userType;

	@LazyAutowired
	public LiveTv_PageObject livetv;

	private final Logger LOGGER = Logger.getLogger(SignUp_PageObject.class.getName());

	//TODO: refactor all the steps: move all actions to corresponding page objects and create assertion here

	@Given("I navigate to the CBS Digital website")
	public void i_navigate_to_the_CBS_Digital_website() {
		LOGGER.log(Level.INFO, "Navigating to CBS Digital... \n");

		home.goToHome();

		LOGGER.log(Level.INFO, "On CBS Digital home page. \n");

	}

	@Then("I am at the Home page")
	public void i_am_at_the_home_page() {

		LOGGER.log(Level.INFO, "Verifying on CBS home page... \n");

		Assert.assertTrue(home.iAmHere(), "Not in " + home.getHomePageURL());

		LOGGER.log(Level.INFO, "On CBS home page. \n");

	}

	@When("I click on Sign In")
	public void i_click_on_Sign_In() {

		//TODO: update LOGGER after refactoring function
		LOGGER.log(Level.INFO, "Clicking on Sign in... \n");

		home.clickSignInOptionsButton();

		LOGGER.log(Level.INFO, "Sign in clicked. \n");

	}

	//TODO: this step is not implemented; update LOGGER message once implemented
	@When("I sign in as {string}")
	public void i_sign_in_as_tve_cbs(String userType) {


		LOGGER.log(Level.INFO, "Verifying ... \n");

		LOGGER.log(Level.INFO, "Verified... \n");


	}

	//TODO: refactor pause into steps or a common page object
	@Then("Pause for {int} seconds")
	public void pause(int secs) {

		LOGGER.log(Level.INFO, "Waiting ... \n");

		try {
			Thread.sleep(secs*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.log(Level.INFO, "Wait is over. \n");

	}

	//TODO: move all of these to steps to Home_PageObject
	@When("I update access as {string}")
	public void i_update_access_as(String userTypeParam) {

		LOGGER.log(Level.INFO, "Verifying... \n");

		switch(userTypeParam) {
			case "Anonymous":
				if(home.isOptionDisplayed(home.signInOptionsButton)) {
					//do nothing
				}else {
					Assert.fail("This branch should not be triggered in Home_StepDefinitions.i_update_access_as(). Either the window is too small or this method is used outside of a fresh launch.");
				}
				break;
			case "Registered":
				home.clickSignInOptionsButton();
				this.signin.signInAsRegistered();
				break;
			case "Ghost":
				this.signin.signInToMvpdWithGhost();
				Assert.assertTrue(home.isAtHomePage());//this will have to be a wait until true
				Assert.assertTrue(home.isOptionDisplayed(home.mvpdLogo));

				break;
			case "AuthZ":
				home.clickSignInOptionsButton();
				this.signin.clickSignInWithTVProvider();
				this.signin.scrollToMoreProviders();
				this.signin.clickMoreProviders();
				this.signin.scrollToWaveBroadband();
				this.signin.selectWaveBroadband();
				this.signin.signInToWaveBroadband();

				String name = this.bindedRegisteredAccountCredentialsAndUsername.split("@")[0].toUpperCase();
				if(this.signin.isPreghost()){
					//Pre-Ghost
					////if create an account is visible
					this.signin.clickSignInOnMVPDSuccessScreen();
					this.signin.signInAsBindedRegisteredAccount();
				}else {
					//AuthZ
					////if create an account is not visible

				}
				home.goToHome();
				home.isAtHomePage();

				Assert.assertTrue(home.isOptionDisplayed(home.mvpdLogo), "MVPD Logo is not displayed");
				Assert.assertTrue(home.isUserProfileNameAMatchTo(name), "Profile name doesn't match");

				break;

			default:
				//need to catch when usertype is empty
				Assert.fail("Step Definitions using <userType> needs to be used with Scenario Outlines");
				break;
		}

		LOGGER.log(Level.INFO, "Verified... \n");

	}

	@When("I access my account info")
	public void i_access_my_account_info() {

		//TODO: update LOGGER message after refactoring function
		LOGGER.log(Level.INFO, "Verifying... \n");

		home.goToAccountSettings();

		LOGGER.log(Level.INFO, "Verified... \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click Shows")
	public void i_click_shows() {

		LOGGER.log(Level.INFO, "Selecting Shows... \n");

		globalNavigation.clickShows();

		LOGGER.log(Level.INFO, "Shows selected. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click Live TV")
	public void i_click_live_tv() throws InterruptedException {

		LOGGER.log(Level.INFO, "Selecting live tv... \n");

		globalNavigation.clickOnLiveTVButton();

		LOGGER.log(Level.INFO, "Live tv selected. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click TV Provider")
	public void i_click_tv_provider() {

		LOGGER.log(Level.INFO, "Selecting TV provider... \n");

		globalNavigation.clickTvProvider();

		LOGGER.log(Level.INFO, "TV provider selected. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click Try Paramount Plus")
	public void i_click_try_paramount_plus() {

		LOGGER.log(Level.INFO, "Selecting Try Paramount+... \n");

		globalNavigation.clickTryParamountPlus();

		LOGGER.log(Level.INFO, "Try Paramount+ selected. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I hover over Live TV")
	public void i_hover_over_live_tv() throws InterruptedException {

		LOGGER.log(Level.INFO, "Verifying that password is hidden as asterisks... \n");

		globalNavigation.hoverOnLiveTv();

		LOGGER.log(Level.INFO, "Verifying that password is hidden as asterisks... \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click on Cbs Local Station")
	public void i_click_on_cbs_local_station() throws InterruptedException {

		LOGGER.log(Level.INFO, "Clicking on CBS local station... \n");

		livetv.selectLiveTVOptionsAndClickOnLocalStationAndObserveTheStream();

		LOGGER.log(Level.INFO, "BS local station selected. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I am at the Cbs Local Station page")
	public void i_am_at_the_cbs_local_station_page() throws InterruptedException {

		LOGGER.log(Level.INFO, "Verifying on CBS local station... \n");

		livetv.iAmAtTheLocalStation();

		LOGGER.log(Level.INFO, "On CBS local station. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I am at the Locked Cbs Local Station page")
	public void i_am_at_the_locked_cbs_local_station_page() throws InterruptedException {

		LOGGER.log(Level.INFO, "Verifying locked local station... \n");

		livetv.iAmAtTheLockedLocalStation();

		LOGGER.log(Level.INFO, "On locked local station. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I click on CBSN")
	public void i_click_on_cbsn() {

		LOGGER.log(Level.INFO, "Selecting on CBSN... \n");

		globalNavigation.clickCBSN();

		LOGGER.log(Level.INFO, "Selected CBSN. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I am at the CBSN Station page")
	public void i_am_at_the_cbsn_station_page() {

		LOGGER.log(Level.INFO, "Verifying on CBSN... \n");

		livetv.iAmAtTheCBSNStation();

		LOGGER.log(Level.INFO, "On CBSN. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I click on CBS Sports HQ")
	public void i_click_on_cbs_sports_hq() {

		LOGGER.log(Level.INFO, "Selecting  CBS Sports HQ... \n");

		globalNavigation.clickCBSSportsHQ();

		LOGGER.log(Level.INFO, "Selected CBS Sports HQ. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I am at the CBS Sports HQ Station page")
	public void i_am_at_the_cbs_sports_hq_station_page() {

		LOGGER.log(Level.INFO, "Verifying on CBS Sports HQ... \n");

		livetv.iAmAtTheCBSSportsHQStation();

		LOGGER.log(Level.INFO, "On CBS Sports HQ. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I click on ET Live")
	public void i_click_on_et_live() {

		LOGGER.log(Level.INFO, "Selecting Live TV... \n");

		globalNavigation.clickEtLive();

		LOGGER.log(Level.INFO, "Selected Live TV. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@Then("I am at the ET Live Station page")
	public void i_am_at_the_et_live_station_page() {

		LOGGER.log(Level.INFO, "Verifying on ET Live Station... \n");

		livetv.iAmAtTheEtLiveStation();

		LOGGER.log(Level.INFO, "on ET Live station. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click on Schedule")
	public void i_click_on_schedule() {

		LOGGER.log(Level.INFO, "Selecting schedule... \n");

		globalNavigation.clickSchedule();

		LOGGER.log(Level.INFO, "Selected schedule. \n");

	}

	//consolidated from GlobalNavigation_StepDefinitions.java.
	@When("I click on the Search Icon")
	public void i_click_on_the_search_icon() {

		LOGGER.log(Level.INFO, "Selecting Search icon... \n");

		globalNavigation.clickSearch();

		LOGGER.log(Level.INFO, "Selected Search icon. \n");

	}



}
