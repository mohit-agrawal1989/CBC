package test.java.com.viacomcbs.step_definitions;

import io.cucumber.spring.CucumberContextConfiguration;


import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.ForgotPassword_PageObject;
import main.java.com.viacomcbs.page_objects.Gmail_PageObject;

import org.testng.Assert;
import org.testng.asserts.*;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@SpringBootTest(classes = WebSpringApplication.class)
public class ForgotPassword_StepDefinitions {
	@LazyAutowired
	private ForgotPassword_PageObject forgotPassword;

	@LazyAutowired
	private Home_PageObject home;

	@LazyAutowired
	private Gmail_PageObject gmail;

	@Then("I am at the Forgot Password page")
	public void i_am_at_the_forgot_password_page() {
		Assert.assertTrue(this.forgotPassword.iAmHere(), "Not in " + this.forgotPassword.getForgotPasswordURL());
	}

	@Then("Send Email is legible")
	public void send_email_is_legible() {
		boolean legible = this.forgotPassword.sendEmailIsLegible();
		Assert.assertTrue(legible,"'Send Email' is not legible");
	}

	@When("I click on Send Email")
	public void i_click_on_send_email() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.forgotPassword.clickSendEmail();
	}

	@When("I enter the email {string}")
	public void i_enter_the_email(String string) {
		boolean enterSuccess = this.forgotPassword.enterEmail(string);
		Assert.assertTrue(enterSuccess, "Entering email is unsuccessful");
	}

	@Then("the success message should come up")
	public void the_success_message_should_come_up() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		boolean success = this.forgotPassword.confirmSuccessMessage();
		Assert.assertTrue(success, "Success Message did not come up.");
	}

	@Then("Send Email becomes Gray")
	public void send_email_becomes_gray() {
		Assert.assertTrue(this.forgotPassword.sendEmailIsGray());
	}

	@Then("the user is redirected to cbs.com after {int} seconds")
	public void the_user_is_redirected_to_cbs_com_after_seconds(Integer int1) {
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Assert.assertTrue(this.home.isAtHomePage(), "User is not in homepage, it's in " + this.home.getCurrentUrl());
	}

	@Then("User views error message {string} appears below text box")
	public void user_views_error_message_appears_below_text_box(String msg) {
		boolean appears = this.forgotPassword.errorMessageAppears(msg);
		Assert.assertTrue(appears, this.forgotPassword.getErrorMessage() + " is not the same as " + msg);
	}

	@Then("the forgot password error message is red")
	public void the_forgot_password_error_message_is_red() {

		System.out.println(forgotPassword.getErrorColor() + "IS THE ERROR COLOR!!!!");

		Assert.assertTrue(this.forgotPassword.forgotPasswordErrorMessageIsRed(), this.forgotPassword.getErrorColor() + " isn't rgba (228, 33, 33, 1)");
	}

	@Then("Cancel is legible")
	public void cancel_is_legible() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		boolean legible = this.forgotPassword.cancelIsLegible();
		Assert.assertTrue(legible, "Cancel is not displayed and/or is not spelled 'Cancel'");
	}

	@Then("I click on Cancel")
	public void i_click_on_cancel() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.forgotPassword.clickCancel();
	}
}
