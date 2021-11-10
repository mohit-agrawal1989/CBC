package main.java.com.viacomcbs.page_objects;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.PageObject;
import main.java.com.viacomcbs.entity.UserType;
import org.testng.Assert;

@PageObject
public class Show_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(Show_PageObject.class.getName());

    @LazyAutowired
    public UserType userType;

    @FindAll({@FindBy(css = "#latest-episodes > div:nth-of-type(2) > article")})
    public List<WebElement> thumbnails;

    public boolean iAmHere(String showName) {

        LOGGER.log(Level.INFO, "Verifying that I am on the show page... \n");

        String currentUrl = this.driver.getCurrentUrl();
        String dashedShowName = showName.replaceAll(" ", "-");
        String underscoredShowName = showName.replaceAll(" ", "_");

        boolean foundWithDash = currentUrl.contains(dashedShowName);
        boolean foundWithUnderscore = currentUrl.contains(underscoredShowName);

        return foundWithDash || foundWithUnderscore;

    }

    public void i_am_at_the_show_page(String showName) {
        Assert.assertTrue(iAmHere(showName.toLowerCase()), "Not in " + showName + " page");
    }



    public void clickFirstFreeFullEpisode() {

        LOGGER.log(Level.INFO, "Clicking on first free full episode... \n");

        String data = "";

        for (int i = 0; i < thumbnails.size(); i++) {
            data = thumbnails.get(i).findElement(By.tagName("a")).getAttribute("data-tracking");
            if (confirmEpisodeIsFreeOrPay(data, i).contentEquals("free")) {
                thumbnails.get(i).click();
                break;
            }
        }
    }

    public void clickFirstLockedFullEpisode() {

        LOGGER.log(Level.INFO, "Clicking on first locked full episode... \n");

        String data = "";
        boolean lockedEpisodeFound = false;
        for (int i = 0; i < thumbnails.size(); i++) {
            data = thumbnails.get(i).findElement(By.tagName("a")).getAttribute("data-tracking");
            if (confirmEpisodeIsFreeOrPay(data, i).contentEquals("pay")) {
                thumbnails.get(i).click();
                lockedEpisodeFound = true;
                break;
            }
        }

        Assert.assertTrue(lockedEpisodeFound, "No Locked Episode Found");
    }

    public String confirmEpisodeIsFreeOrPay(String data, int thumbnailIndex) {

        LOGGER.log(Level.INFO, "Checking if the episode is free or paid... \n");

        String tempType = "";
        String type = "";

        data = thumbnails.get(thumbnailIndex).findElement(By.tagName("a")).getAttribute("data-tracking");
        String[] parsedData = data.split("\\|");
        tempType = parsedData[parsedData.length - 1];
        if (tempType.contains("pay")) {
            type = "pay";
        } else if (tempType.contains("free")) {
            type = "free";
        }
        return type;
    }
}
