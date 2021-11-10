package main.java.com.viacomcbs.page_objects;

import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

import java.util.logging.Logger;

@PageObject
public class TvProvider_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(TvProvider_PageObject.class.getName());

    @Value("${tvProviderURL:}")
    private String tvProviderURL;

    public String getTvProviderURL() {
        return tvProviderURL;
    }

    public boolean iAmHere() {
        return this.atURL(tvProviderURL);
    }

    public void i_am_at_the_tv_provider_page() {
        Assert.assertTrue(iAmHere(), "Not in " + getTvProviderURL());
    }

}
