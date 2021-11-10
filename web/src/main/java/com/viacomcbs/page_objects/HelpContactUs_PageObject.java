package main.java.com.viacomcbs.page_objects;

import main.java.com.viacomcbs.annotation.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class HelpContactUs_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(HelpContactUs_PageObject.class.getName());

    @Value("${helpContactUsPageURL:}")
    private String helpContactUsPageURL;

    @FindBy(className = "user-profile-name")
    private WebElement drop;

    @FindBy(how = How.CSS, using = "ul.header__account.header__nav--items li.header__nav--withsubMenu ul.header__subnav.content li:nth-child(3) > a:nth-child(1)")
    private WebElement help;

    @Value("${helpPageURL}")
    private String helpPageURL;

    @FindBy(how = How.CSS, using = " section.account-grid:nth-child(4) div.grid-item.grid-item--section-content:nth-child(2) div.row:nth-child(1) > button.row__action.action-button")
    private WebElement read;

    public String getHelpContactUsPageURL() {
        return helpContactUsPageURL;
    }

    public void goTo() {
        this.driver.get(helpContactUsPageURL);
    }

    public boolean iAmHere() {
        return this.atURL(helpContactUsPageURL);
    }

    public void observeSelectingReadRedirectsTheUserToHelpCenter() {

        LOGGER.log(Level.INFO, "Selecting Read... \n");

        tryClickingNTimes(read,5);

//        assertPageEquals();

    }
}