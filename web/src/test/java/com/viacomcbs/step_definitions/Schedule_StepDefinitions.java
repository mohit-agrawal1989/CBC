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


@SpringBootTest(classes = WebSpringApplication.class)
public class Schedule_StepDefinitions {
	
	@LazyAutowired
	public Schedule_PageObject schedule;

	@LazyAutowired
	public LiveTv_PageObject livetv;

	
	@Then("I am at the Schedule page")
	public void i_am_at_the_schedule_page() {
		Assert.assertTrue(this.schedule.iAmHere(), "Not in " + this.schedule.getSchedulePageURL());
	}
	
	@Then("Shows, Dates, and Times are displayed")
	public void shows_dates_and_times_are_displayed() {
	    this.schedule.showsDatesAndTimesAreDisplayed();
	}

	@When("I hover over the date drop down")
	public void i_hover_over_the_date_drop_down() {
		this.schedule.hoverOnDateDropDown();
	}

	@Then("the date drop down window appears")
	public void the_date_drop_down_window_appears() {
		this.schedule.dropDownAppears();
	}

	@When("I click on the first available show and land on the right page")
	public void i_click_on_the_first_available_show_and_land_on_the_right_page() {
		Assert.assertTrue(this.schedule.clickOnFirstShowNameAndLandOnRightPage(), "Did not land on right page when clicking on First Show Thumbnail");
	}

	@When("I click on the first available show name and land on the right page")
	public void i_click_on_the_first_available_show_name_and_land_on_the_right_page() {
		Assert.assertTrue(this.schedule.clickOnFirstShowNameAndLandOnRightPage(),"Did not land on right page when clicking on First Show Name");
	}

	@When("I click on Watch Live TV")
	public void i_click_on_watch_live_tv() {
		this.schedule.clickOnWatchLiveTV();
	}

	@Then("I am at the Live TV local page")
	public void i_am_at_the_live_tv_local_page() throws InterruptedException {
				this.livetv.iAmAtTheLocalStation();
		}

	@Then("I am at the Live TV local locked page")
	public void i_am_at_the_live_tv_local_locked_page() throws InterruptedException {
				this.livetv.iAmAtTheLockedLocalStation();
		}
	}

