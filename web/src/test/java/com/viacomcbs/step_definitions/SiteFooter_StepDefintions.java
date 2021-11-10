package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;


@SpringBootTest(classes = WebSpringApplication.class)
public class SiteFooter_StepDefintions {

    @LazyAutowired
    private SiteFooter_PageObject siteFooter;


    @LazyAutowired
    private SignIn_PageObject signin;


    @Value("${helpContactUsPageURL}")
    private String contactUs;


    @When("I navigate to the Site Footer on the Shows page")
    public void i_navigate_to_the_site_footer_on_the_shows_page() {
        this.siteFooter.goTo();
    }

    @When("I click on Help-Contact Us on the site footer")
    public void i_click_on_help_contact_us_on_the_site_footer() {
        this.siteFooter.clickOnHelpContactUs();
    }

    @When("I tab to the Help-Contact page")
    public void i_tab_to_the_help_contact_page() {
        this.siteFooter.tabToHelpContactUs();
    }

    @Then("I am at the Help-Contact page")
    public void i_am_at_the_help_contact_page() {
        Assert.assertTrue(this.signin.atURL(contactUs));
    }

    @When("I click on Privacy Policy on the site footer")
    public void i_click_on_privacy_policy_on_the_site_footer() {
        this.siteFooter.clickOnPrivacyPolicy();
    }

    @When("I tab to the Privacy Policy page")
    public void i_tab_to_the_privacy_policy_page() {
        this.siteFooter.tabToPrivacyPolicy();
    }

    @When("I click on Terms of Use on the site footer")
    public void i_click_on_terms_of_use_on_the_site_footer() {
        this.siteFooter.clickOnTermsOfUse();
    }

    @When("I tab to the Terms of Use page")
    public void i_tab_to_the_terms_of_use_page() {
        this.siteFooter.tabToTermsOfUse();
    }

    @When("I click on Cookies on the site footer")
    public void i_click_on_cookies_on_the_site_footer() {
        this.siteFooter.clickOnCookies();
    }

    @When("I tab to the Cookies page")
    public void i_tab_to_the_cookies_page() {
        this.siteFooter.tabToCookies();
    }

    @Then("the copyright reads properly")
    public void the_copyright_reads_properly() {
        this.siteFooter.the_copyright_reads_properly();
    }
}
