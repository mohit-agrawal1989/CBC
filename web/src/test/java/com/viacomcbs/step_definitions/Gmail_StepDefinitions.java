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
public class Gmail_StepDefinitions {
	@LazyAutowired
	private Gmail_PageObject gmail;

	@When("I log in to gmail with the username {string} and password {string}")
	public void i_log_in_to_gmail_with_the_username_and_password(String username, String password) {

		this.gmail.goTo();//use incognito
//		this.gmail.iAmHere();
		this.gmail.enterEmail(username);
//		Assert.assertTrue(this.gmail.login(username, password));
//		Assert.assertTrue(this.gmail.cbsResetPasswordEmailIsPresent());
	}


}
