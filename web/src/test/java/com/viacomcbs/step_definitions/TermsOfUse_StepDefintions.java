package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.en.Then;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.TermsOfUse_PageObject;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebSpringApplication.class)
public class TermsOfUse_StepDefintions {

    @LazyAutowired
    private TermsOfUse_PageObject termsOfUse;

    @Then("I am at the Terms of Use page")
    public void i_am_at_the_terms_of_use_page() {


        termsOfUse.i_am_at_the_terms_of_use_page();
    }
}
