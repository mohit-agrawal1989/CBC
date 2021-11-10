package test.java.com.viacomcbs.step_definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;

import org.testng.Assert;
import org.testng.asserts.*;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootTest(classes = WebSpringApplication.class)
public class Signin_StepDefinitions {
	@LazyAutowired
	private Home_PageObject home;

	@LazyAutowired
	private DropDown_PageObject dropDown;

	@LazyAutowired
	private SignIn_PageObject signin;

	@LazyAutowired
	private ForgotPassword_PageObject forgotpassword;

	@LazyAutowired
	private SignUp_PageObject signup;

	private final Logger LOGGER = Logger.getLogger(CBSSports_StepDefinitions.class.getName());

	@Given("I go to the sign in page on {int}")
	public void iGoToTheSignInPage(int testcase) {
		this.signin.goTo();
	}

	@Given("I go to the sign in page")
	public void iGoToTheSignInPage() {
		this.signin.goTo();
	}

	@Given("I am at the sign in page")
	public void iAmAtTheSignInPage() {
		signin.iAmHereSignIn();
	}

	@Given("I am at the forgot password page")
	public void iAmAtTheForgotPasswordPage() {
		this.forgotpassword.iAmHere();
	}

	@When("I enter the email and password as {string} and {string}")
	public void enterNames(String email, String pwd) {
		this.signin.enterCredentials(email, pwd);
	}

	@Then("I am at the Sign In with TV Provider page")
	public void i_am_at_the_sign_in_with_tv_provider_page() {
		this.signin.iAmHereSignInWithTvProvider();
	}

	@When("I enter the email and password as a P+ user")
	public void i_enter_the_email_and_password_as_a_p_user() {
		this.signin.enterPPlusCredentials();
	}

	@And("I click continue")
	public void submit() {
		this.signin.clickContinueBtn();
	}

	@And("I click on Forgot Password")
	public void clickForgotPassword() {
		this.signin.clickForgotPasswordBtn();
	}

	@Then("I am taken to the homepage on {int}")
	public void verifyArriveAtHomePage(int testcase) {
		this.home.isAtHomePage();
	}

	@Then("Sign In Options button is displayed")
	public void signInOptionsButtonIsDisplayed() {
		home.signInOptionsButtonIsDisplayed();
	}

	@Then("Continue CTA is disabled")
	public void continueCtaIsDisabled() {
		Assert.assertTrue(this.signin.continueCtaIsDisabled());
	}


	@Then("Error message Invalid email and or password appears above text boxes")
	public void errorMessageInvaidEmailAndOrPassword() {
		Assert.assertTrue(this.signin.invalidEmailPasswordPopsUp());
	}

	@Then("Error message appears with Email text box highlighted red and Valid email required. text below")
	public void errorMessageValidEmailRequired() {
		Assert.assertTrue(this.signin.invalidEmail());
	}

	@Then("Forgot Password link is legible")
	public void forgotPasswordLinkIsLegible() {
		Assert.assertTrue(this.signin.legibleForgotPassword());
	}

	@Then("Sign In With TV Provider is presented")
	public void sign_in_with_tv_provider_is_presented() {
		Assert.assertTrue(this.signin.signInWithTVProviderIsPresented());
	}

	@When("I click on Sign In with TV Provider")
	public void i_click_on_sign_in_with_tv_provider() {
		this.signin.clickSignInWithTVProvider();
	}

	@Then("Sign Up CTA on the right corner is legible")
	public void sign_up_cta_on_the_right_corner_is_legible() {
		boolean legible = this.signin.signUpIsLegible();
		Assert.assertTrue(legible, "Sign up is not legible");
	}

	@When("I click on Sign Up")
	public void i_click_on_sign_up() {
		this.signin.clickSignUp();
	}

	@Then("I am at the Sign Up page")
	public void i_am_at_the_sign_up_page() {
		this.signup.iAmHere();
	}

	//TODO: refactor below block; step def should only include assertions; consolidated from Email_StepDefinitions.java.
	@Then("Email field displays current email")
	public void email_field_displays_current_email() {

		LOGGER.log(Level.INFO, "Verfiying email field displays current email...  \n");

		this.signin.iAmHereEmail();
		this.signin.emailFieldDisplaysCurrentEmail();

		LOGGER.log(Level.INFO, "Email field displays current email.  \n");

	}

	@When("I click on sign in button")
	public void i_click_on_sign_in_button(){

		LOGGER.log(Level.INFO, "Clicking on sign in button...  \n");

		this.dropDown.clickOnSignInButton();

		LOGGER.log(Level.INFO, "Sign in button clicked.  \n");
	}

	@When("I enter the email and password in sign in page")
	public void i_enter_the_email_and_password_in_sign_in_page(){

		LOGGER.log(Level.INFO, "Entering email and password in sign in page...  \n");

		this.dropDown.enterTheEmailAndPasswordInSignInPage();

		LOGGER.log(Level.INFO, "credentials entered and continue button clicked  \n");

	}

	@Then("I observe Password field displays hidden password")
	public void i_observe_password_field_displays_hidden_password_as_asterisks() {

		LOGGER.log(Level.INFO, "Verifying password characters show up as asterisks...  \n");

		this.signup.observePasswordFieldDisplaysHiddenPasswordAsAsterisks();

		LOGGER.log(Level.INFO, "Password characters show up as asterisks.  \n");

	}

	@Then("I observe User name dropdown menu contains Account, Help and Sign Out items")
	public void i_observe_user_name_dropdown_menu_contains_account_help_and_sign_out_items() throws InterruptedException {

		LOGGER.log(Level.INFO, "Verifying username dropdown contains account help and sign out...  \n");

		//TODO: refactor - below method is not doing what it is supposed to do
		this.dropDown.observeUserNameDropDownMenuContainsAccountHelpAndSignOutItems();

		LOGGER.log(Level.INFO, "Username dropdown contains account help and sign out.  \n");

	}

	@Then("I observe User name dropdown menu displays first name for registered user")
	public void i_observe_user_name_dropdown_menu_displays_first_name_for_registered_user() throws InterruptedException {

		LOGGER.log(Level.INFO, "Verifying username dropdown displays first name for registered user...  \n");

		this.dropDown.observeUserNameDropdownMenuDisplaysFirstNameForRegisteredUser();

		LOGGER.log(Level.INFO, "Username dropdown displays first name for registered user.  \n");

	}

}
