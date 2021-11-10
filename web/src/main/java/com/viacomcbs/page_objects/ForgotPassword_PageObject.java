package main.java.com.viacomcbs.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;

import java.time.Duration;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;


@PageObject
public class ForgotPassword_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(ForgotPassword_PageObject.class.getName());

    @Value("${env:}")
    private String env;

    @Value("${forgotPasswordPageURL}")
    private String forgotPasswordURL;

    @FindBy(css = "#forgot-password-form > div > div:nth-of-type(1) > div > input")
    private WebElement emailTxtField;

    @FindBy(className = "qt-continuebtn")
    private WebElement sendEmailBtn;

    @FindBy(css = ".button.qt-continuebtn.disabled")
    private WebElement sendEmailContainer;

    @FindBy(className = "form-message")
    private WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"forgot-password-form\"]/div/div[1]/div[2]/div")
    private WebElement errorMessage;

    @FindBy(css = "#main-aa-container > section > div > div:nth-of-type(2) > a > span")
    private WebElement cancel;

    @FindBy(css = ".a.form-link.qt-cancelbtn")
    private WebElement cancelBtn;

    public void goTo() {
        this.driver.get("https://" + env + ".cbs.com/account/forgotpassword/");
    }

    public String getForgotPasswordURL() {
        return forgotPasswordURL;
    }

    public boolean iAmHere() {
        return this.atURL(forgotPasswordURL);
    }

    public boolean sendEmailIsLegible() {

        LOGGER.log(Level.INFO, "Sending email... \n");

        boolean legible;

        Wait<String> fluentWait = new FluentWait<String>("Send Email")
                .withTimeout(Duration.ofMillis(1000))
                .pollingEvery(Duration.ofMillis(40));

        legible = fluentWait.until(new Function<String, Boolean>() {
            public Boolean apply(String str) {
                boolean isLegible = false;
                try {
                    String btnText = (sendEmailBtn).findElement(By.className("button__text")).getAttribute("innerHTML");
                    if (btnText.contains(str)) {
                        isLegible = true;
                    }
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                }
                return isLegible;
            }
        });
        return legible;
    }

    public boolean enterEmail(String str) {

        LOGGER.log(Level.INFO, "Entering email... \n");

        boolean enterSuccess;

        Wait<String> fluentWait = new FluentWait<>(str)
                .withTimeout(Duration.ofMillis(3000))
                .pollingEvery(Duration.ofMillis(40));

        enterSuccess = fluentWait.until(strParam -> {
            boolean isSuccessful = false;
            try {
                emailTxtField.sendKeys(strParam);
                String input = emailTxtField.getAttribute("value");
                if (input.length() > 0) {
                    isSuccessful = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isSuccessful;
        });

        return enterSuccess;
    }

    public void clickSendEmail() {
        (this.returnVerifiedElement(this.sendEmailBtn)).click();
    }

    public boolean confirmSuccessMessage() {

        LOGGER.log(Level.INFO, "Confirming success message... \n");

        boolean appropriateMsgAppears;
        Wait<String> fluentWait = new FluentWait<String>("We’ve sent you a link to reset your password.")
                .withTimeout(Duration.ofMillis(2000))
                .pollingEvery(Duration.ofMillis(400));

        appropriateMsgAppears = fluentWait.until(new Function<String, Boolean>() {
            public Boolean apply(String str) {
                boolean isAppropriate = false;
                try {
                    String message = successMessage.getText();
                    if (message.contains(str)) {
                        isAppropriate = true;
                    }
                } catch (Exception e) {
                    e.getStackTrace();}
                return isAppropriate;
            }
        });
        return appropriateMsgAppears;
    }

    public boolean sendEmailIsGray() {
        LOGGER.log(Level.INFO, "Verifying that Send Email button is gray... \n");

        boolean isGray = false;
        String css = (this.returnVerifiedElement(this.sendEmailContainer)).getCssValue("background-color");
        if (css.contains("rgba(170, 170, 170, 0.8)")) {
            isGray = true;
        }
        return isGray;
    }

    public boolean errorMessageAppears(String msg) {

        LOGGER.log(Level.INFO, "Verifying that error message appears... \n");

        boolean appropriateMsgAppears;

        Wait<String> fluentWait = new FluentWait<>(msg)
                .withTimeout(Duration.ofMillis(2000))
                .pollingEvery(Duration.ofMillis(400));

        appropriateMsgAppears = fluentWait.until(str -> {
            boolean isAppropriate = false;
            try {
                if (returnVerifiedElement(errorMessage).getText().contains(msg)) {
                    isAppropriate = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isAppropriate;
        });

        return appropriateMsgAppears;
    }

    public String getErrorMessage() {
        return (this.returnVerifiedElement(this.errorMessage)).getText();
    }

    public boolean forgotPasswordErrorMessageIsRed() {

        LOGGER.log(Level.INFO, "Verifying that error message is red... \n");

        return this.getErrorColor().contains("rgba(228, 33, 33, 1)");
    }

    public String getErrorColor() {
        return (this.returnVerifiedElement(this.errorMessage)).getCssValue("color");
    }

    public boolean cancelIsLegible() {

        LOGGER.log(Level.INFO, "Checking if Cancel button is legible... \n");

        boolean legible;
        Wait<String> fluentWait = new FluentWait<>("Cancel")
                .withTimeout(Duration.ofMillis(4000))
                .pollingEvery(Duration.ofMillis(400));

        legible = fluentWait.until(str -> {
            boolean isLegible = false;
            try {
                if (getCancelButtonText().contains(str)) {
                    isLegible = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return isLegible;
        });

        return legible;
    }

    public String getCancelButtonText() {
        return (this.returnVerifiedElement(this.cancel)).getText();
    }

    public void clickCancel() {

        this.cancel.click();

    }
}