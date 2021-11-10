package main.java.com.viacomcbs.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

@PageObject
public class VideoPlayer_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(VideoPlayer_PageObject.class.getName());

    @FindBy(className = "video__player-wrapper")
    public WebElement videoPlayer;

    @FindBy(className = "video__player-overlay")
    public WebElement videoOverlay;

    @FindBy(className = "video__lock-slate-text")
    public WebElement videoLockText;

    @FindBy(css = "#main-container > div:nth-of-type(3) > div:nth-of-type(1) > div > div > div:nth-of-type(3) > div > div > div:nth-of-type(2) > a > div")
    public WebElement button;

    String lockButtonText = "SIGN IN WITH TV PROVIDER";

    public boolean iAmHere() {
        return (this.returnVerifiedElement(videoPlayer, 5) != null);
    }

    public void i_am_at_the_video_player_page() {
        Assert.assertTrue(iAmHere(), "Not in VideoPlayer page");
    }

    public void the_video_should_be(String str) {
        if(str.toLowerCase().contentEquals("locked")) {
            videoIsLocked();
        }else if(str.toLowerCase().contentEquals("unlocked")){
            videoIsNotLocked();
        }
    }

    public void videoIsNotLocked() {

        LOGGER.log(Level.INFO, "Verifying that video is not locked... \n");

        Assert.assertNull(this.returnVerifiedElement(videoOverlay, 5), "videoIsNotLocked but videoOverlay is present");
    }

    public void videoIsLocked() {

        LOGGER.log(Level.INFO, "Verifying that video is locked... \n");

        Assert.assertNotNull(this.returnVerifiedElement(videoOverlay, 5), "videoIsLocked but videoOverlay is not present");
        Assert.assertNotNull(this.returnVerifiedElement(videoLockText, 5), "videoIsLocked but videoLockText is not present");
        WebElement el = this.returnVerifiedElement(button, 30);
        Assert.assertTrue(lockButtonText.contains(el.getText()));

    }

}
