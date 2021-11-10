package test.java.com.viacomcbs.step_definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import main.java.com.viacomcbs.page_objects.SignUp_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.LiveTv_PageObject;
import main.java.com.viacomcbs.page_objects.Shows_PageObject;
import main.java.com.viacomcbs.page_objects.ForgotPassword_PageObject;

import org.testng.Assert;
import org.testng.asserts.*;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@SpringBootTest(classes = WebSpringApplication.class)
public class LiveTv_StepDefinitions {

	@LazyAutowired
	public LiveTv_PageObject livetv;

	@Then("I am at the Live TV page")
	public void i_am_at_the_live_tv_page() {
		Assert.assertTrue(this.livetv.iAmHere(), "Not in " + this.livetv.getLiveTvPageURL());
	}

}
