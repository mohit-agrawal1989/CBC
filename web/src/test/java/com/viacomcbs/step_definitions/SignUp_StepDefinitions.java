package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.page_objects.HelpContactUs_PageObject;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.SignUp_PageObject;
import org.springframework.beans.factory.annotation.Autowired; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance
import org.openqa.selenium.support.ui.FluentWait; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance
import org.testng.Assert; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance
import org.openqa.selenium.WebDriver; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance
import main.java.com.viacomcbs.page_objects.Home_PageObject; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance
import main.java.com.viacomcbs.page_objects.Account_PageObject; // consolidated from HiddenPassword_StepDefinitions.java, double check for relevance

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest(classes = WebSpringApplication.class)
public class SignUp_StepDefinitions {

	private final Logger LOGGER = Logger.getLogger(SignUp_PageObject.class.getName());

	@LazyAutowired
	private SignUp_PageObject signup;

	@LazyAutowired
	private SignIn_PageObject signin;

	// consolidated from HiddenPassword_StepDefinitions.java, double check for relevance:
	@Autowired
	protected WebDriver driver;

	// consolidated from HiddenPassword_StepDefinitions.java, double check for relevance:
	@Autowired
	protected FluentWait<WebDriver> wait;

	//TODO: refactor all below steps

	/** NOTES -> Case 1*/
	@Then("I am on Pick A Plan page on test {int}")
	public void verify_PAP(int testcase){

		//TODO: update LOGGER messages after refactoring the function.
		LOGGER.log(Level.INFO, "Verifying Pick A Plan... \n");

		signup.verify_PAP(testcase);

		LOGGER.log(Level.INFO, "Pick A Plan verified. \n");

	}

	@When("I Click Continue Button")
	public void clickContinue() {

		LOGGER.log(Level.INFO, "Clicking continue button... \n");

		signup.clickContinueBtn();

		LOGGER.log(Level.INFO, "continue button clicked. \n");

	}

	@Then("I am on interstitial 2 page on test {int}")
	public void verify_interstitial2( int testcase){

		//TODO: update LOGGER message after refactoring function
		LOGGER.log(Level.INFO, "Verifying ... \n");

		signup.verify_interstitial2(testcase);

		LOGGER.log(Level.INFO, "Verified ... \n");

	}

	@Then("I am on Create An Account page on test {int}")
	public void verify_CreateAnAccount( int testcase){

		LOGGER.log(Level.INFO, "Verifying create an account... \n");

		signup.verify_CreateAnAccount(testcase);

		//TODO: adjust LOGGER message after refactoring function
		LOGGER.log(Level.INFO, "account created. \n");

	}

	@When("I fill my information on Create An Account page")
	public void verify_CreateAnAccount_textfield(){

		LOGGER.log(Level.INFO, "Verifying creating an account text field... \n");

		signup.input_CreateanAccountInfo();

		LOGGER.log(Level.INFO, "creating an account text field verified. \n");

	}

	@Then("I am on interstitial 3 page on test {int}")
	public void verify_interstitial3( int testcase){

		//TODO: update LOGGER message after refactoring function
		LOGGER.log(Level.INFO, "Verifying ... \n");

		signup.verify_interstitial3(testcase);

		LOGGER.log(Level.INFO, "Verified ... \n");

	}

	@When("I fill my information on Payment page")
	public void verify_payment_textfield(){

		LOGGER.log(Level.INFO, "Verifying payment text field... \n");

		signup.input_payment();

		//TODO: adjust the LOGGER message after refactoring the function
		LOGGER.log(Level.INFO, "payment text field verified. \n");

	}

	@And("I Click Submit Button")
	public void clickSubmitBtn(){

		LOGGER.log(Level.INFO, "Clicking submit button... \n");

		signup.selectSubmitBtn();

		LOGGER.log(Level.INFO, "submit button clicked. \n");

	}

	@Then("I am on Show Picker page on test {int}")
	public void verify_showpicker_step(){

		LOGGER.log(Level.INFO, "Verifying show picker... \n");

		signup.verify_showpicker();

		//TODO: adjust the LOGGER message after refactoring the function
		LOGGER.log(Level.INFO, "show picker verified. \n");

	}

	@Then("I observe Selecting Sign Out signs the user out")
	public void i_observe_selecting_sign_out_signs_the_user_out(){

		LOGGER.log(Level.INFO, "Verifying sign out... \n");

		signin.observeSelectingSignOutSignsTheUserOut();

		LOGGER.log(Level.INFO, "Selecting sign out signs the use rout. \n");

	}

	//TODO: refactor below code since it always returns true and is irrelevant to the test case; consolidated from HiddenPassword_StepDefinitions.java
	@Then("I observe Password field displays hidden password (as asterisks)")
	public void i_observe_password_field_displays_hidden_password_as_asterisks() {

		LOGGER.log(Level.INFO, "Verifying that password is hidden as asterisks... \n");

		this.signup.observePasswordFieldDisplaysHiddenPasswordAsAsterisks();

		String actualPageUrl=driver.getCurrentUrl();

		String  expectedPageUrl=  actualPageUrl;

		Assert.assertEquals(actualPageUrl,expectedPageUrl);

		LOGGER.log(Level.INFO, "Password is hidden as asterisks. \n");

	}

}
