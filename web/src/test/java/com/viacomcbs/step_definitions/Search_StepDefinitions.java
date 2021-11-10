package test.java.com.viacomcbs.step_definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.SignIn_PageObject;
import main.java.com.viacomcbs.page_objects.SignUp_PageObject;
import main.java.com.viacomcbs.page_objects.Home_PageObject;
import main.java.com.viacomcbs.page_objects.Search_PageObject;
import main.java.com.viacomcbs.page_objects.Show_PageObject;
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
public class Search_StepDefinitions {
	
	@LazyAutowired
	public Search_PageObject search;
	
	@LazyAutowired
	public Show_PageObject show;
	
	@Then("I am at the Search page")
	public void i_am_at_the_search_page() {
		Assert.assertTrue(this.search.iAmHere(), "Not in " + this.search.getSearchPageURL());
	}
	
	@When("I enter an invalid term")
	public void i_enter_an_invalid_term() {
	    this.search.enterInvalidTerm();
	}
	
	@Then("there should be no results displayed")
	public void there_should_be_no_results_displayed() {
	    this.search.noResultsDisplayed();
	}
	
	@Then("An invalid search term error should appear")
	public void an_invalid_search_term_error_should_appear() {
	    this.search.invalidSearchErrorAppears();
	}
	
	@When("I enter a valid term")
	public void i_enter_a_valid_term() {
	    this.search.enterAValidTerm();
	}
	
	@Then("At least one show card should appear")
	public void at_least_one_show_card_should_appear() {
	    this.search.atLeastOneShowCardAppears();
	}
	
	@When("I enter a single letter term")
	public void i_enter_a_single_letter_term() {
	    this.search.enterASingleLetterTerm();
	}
	
	@When("I enter a number term")
	public void i_enter_a_number_term() {
	    this.search.enterANumberTerm();
	}
	
	@When("I enter the term {string}")
	public void i_enter_the_term(String string) {
	    this.search.enterTheSearchTerm(string);
//	    try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@When("I delete one character")
	public void i_delete_one_character() {
	    this.search.deleteACharacter();
	}
	
	@Then("the term should be {string}")
	public void the_term_should_be(String string) {
	    this.search.searchTermShouldEqual(string);
	}
	
	@Then("I clear the search input")
	public void i_clear_the_search_input() {
	    this.search.clearSearchInput();
	}
	
	@Then("I append the search term with a space")
	public void i_append_the_search_term_with_a_space() {
	    this.search.appendSearchTerm(" ");
	}
	
	@When("I click on the Search Close Icon")
	public void i_click_on_the_search_close_icon() {
	    this.search.clickCloseSearch();
	}
	
//	@Then("the results should contain {string}")
//	public void the_results_should_contain(String string) {
//	    this.search.searchTermIsInAllResults(string);
//	}
	
	@Then("the results should show {string}")
	public void the_results_should_show(String string) {
		boolean found = this.search.searchTermIsInSomeResults(string, 3);
		Assert.assertTrue(found, "Search term [" + string + "] was not found in any of the results");
	}

	@Then("I append the search term with {string}")
	public void i_append_the_search_term_with(String string) {
	    this.search.appendSearchTerm(string);
	}
	
	@Then("the results should not show {string}")
	public void the_results_should_not_show(String string) {
		boolean notShown = this.search.resultsShouldNotContain(string);
		Assert.assertTrue(notShown, string + " results are still shown");
	}
	
	@Then("I delete a letter from the search term")
	public void i_delete_a_letter_from_the_search_term() {
	    this.search.deleteALetterFromTheSearchTerm();
	}
	
	@When("I click the first result with the term {string}")
	public void i_click_the_first_result_with_the_term(String string) {
	    this.search.clickResultWithTerm(string);
	}
	
	@Then("I arrive at the showpage of {string}")
	public void i_arrive_at_the_showpage_of(String string) {
		this.show.iAmHere(string);
	}

}
