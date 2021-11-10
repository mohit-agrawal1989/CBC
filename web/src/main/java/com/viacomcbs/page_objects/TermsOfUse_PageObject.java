package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.util.logging.Logger;


@PageObject
public class TermsOfUse_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(TermsOfUse_PageObject.class.getName());

    @Value("${termsOfUseURL:}")
    private String termsOfUseURL;

    public String getTermsOfUseURL() {
        return termsOfUseURL;
    }

    public void goTo() {
        this.driver.get(termsOfUseURL);
    }

    public boolean iAmHere() {
        return this.atURL(termsOfUseURL);
    }

    public void i_am_at_the_terms_of_use_page() {
        Assert.assertTrue(iAmHere(), "Not in " + getTermsOfUseURL());
    }
}
