package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger;

@PageObject
public class PrivacyPolicy_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(PrivacyPolicy_PageObject.class.getName());

    @Value("${privacyPolicyURL:}")
    private String privacyPolicyURL;

    public String getPrivacyPolicyURL() {
        return privacyPolicyURL;
    }

    public void goTo() {
        this.driver.get(privacyPolicyURL);
    }

    public boolean iAmHere() {
        return this.atURL(privacyPolicyURL);
    }

}
