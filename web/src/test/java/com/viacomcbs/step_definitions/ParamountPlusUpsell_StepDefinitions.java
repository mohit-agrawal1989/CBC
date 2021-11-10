package test.java.com.viacomcbs.step_definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;

import org.junit.platform.commons.function.Try;
import org.testng.Assert;
import org.testng.asserts.*;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@SpringBootTest(classes = WebSpringApplication.class)
public class ParamountPlusUpsell_StepDefinitions {
	
	@LazyAutowired
	public TryParamount_PageObject tryParamount;
	
	@Then("I am at the Paramount Plus Upsell page")
	public void i_am_at_the_paramount_plus_upsell_page() {
		Assert.assertTrue(this.tryParamount.iAmHere(), "Not in " + this.tryParamount.getParamountPlusUpsellPageURL());
	}

}
