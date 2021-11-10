package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.HelpContactUs_PageObject;
import main.java.com.viacomcbs.page_objects.PrivacyPolicy_PageObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;


@SpringBootTest(classes = WebSpringApplication.class)
public class PrivacyPolicy_StepDefintions {

    @LazyAutowired
    private PrivacyPolicy_PageObject privacyPolicy;

    @Then("I am at the Privacy Policy page")
    public void i_am_at_the_privacy_policy_page() {
        Assert.assertTrue(this.privacyPolicy.iAmHere(), "Not in " + this.privacyPolicy.getPrivacyPolicyURL());
    }
}
