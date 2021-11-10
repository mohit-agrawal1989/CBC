package main.java.com.viacomcbs.page_objects;

import org.testng.Assert;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;
import main.java.com.viacomcbs.annotation.PageObject;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.NoSuchElementException;

@PageObject
public class SignUp_PageObject extends BasePage {

    private final Logger LOGGER = Logger.getLogger(SignUp_PageObject.class.getName());

    @Value("${signUpPageURL:where you at}")
    private String signUpPageURL;

    @FindBy(className = "qt-passwordtxtfield")
    private WebElement password;
    String passput = "aaaaaaa";

    @Value("${accountPageURL}")
    private String accountPageURL;

    @Value("${pPlusRegAccount:}")
    private String pPlusRegAccount;

    @Value("${registeredAccountCredentials:}")
    private String registeredAccountCredentials;

    @LazyAutowired
	public User user;

    @FindBy(how = How.CLASS_NAME, using = "qt-nametxtfield")
    private WebElement NameTextfield;

    @FindBy(how = How.CLASS_NAME, using = "qt-emailtxtfield")
    private WebElement EmailTextfield;

    @FindBy(how = How.CLASS_NAME, using = "qt-pwdtxtfield")
    private WebElement PwdTextfield;

    @FindBy(how = How.CLASS_NAME, using = "qt-ziptxtfield")
    private WebElement zipcode;

    @FindBy(how = How.CLASS_NAME, using = "qt-bdaytxtfield")
    private WebElement birthdayTextfield;

    @FindBy(how = How.CLASS_NAME, using = "button__text")
    private WebElement ContinueBtn;

    @FindBy(how = How.CLASS_NAME, using = "qt-gendertxtfield")
    private WebElement GenderDropdown;

    @FindBy(how = How.CLASS_NAME, using = "qt-addresstxtfield")
    private WebElement AddressTextfield;

    @FindBy(how = How.CLASS_NAME, using = "qt-citytxtfield")
    private WebElement CityTextfield;

    @FindBy(how = How.CLASS_NAME, using = "qt-statetxtfield")
    private WebElement StateDropdown;

    @FindBy(how = How.CSS, using = "#main-aa-container > section > form > div > div.order-summary-wrapper.payment-layout__summary > button")
    private WebElement SubmitBtn;

    @FindBy(how = How.CLASS_NAME, using = "qt-lcbanner")
    private WebElement LCPlan;

    @FindBy(how = How.CLASS_NAME, using = "qt-cfbanner")
    private WebElement CFPlan;

    @FindBy(how = How.ID, using = "annual-plan")
    private WebElement AnnualPlan;

    @FindBy(how = How.ID, using = "recurly-hosted-field-input")
    private WebElement recurlyfield;

    @FindBy(how = How.TAG_NAME, using = "iframe")
    private WebElement IFRAME;

    @FindBy(how = How.CSS, using = "#main-container > section > div.showpicker-scroll-container > div.show-picker-header > div.show-picker-header-left > div.show-picker--description")
    private WebElement showpicker;

    @FindBy(how = How.CSS, using = "#main-aa-container > div > div > div.interstitial-steps-title")
    private WebElement interstitial;

	public String get_url(){
		this.wait.until((d) -> ContinueBtn.isDisplayed());

		this.currentURL = driver.getCurrentUrl();
		return  currentURL;
	}

	public String get_interstitial_url(){
		this.wait.until((d) -> interstitial.isDisplayed());

		this.currentURL = driver.getCurrentUrl();
		return  currentURL;
	}

	public String getPlan_url(){
		this.wait.until((d) -> LCPlan.isDisplayed());
		this.currentURL = driver.getCurrentUrl();
		return  currentURL;
	}

	public void input_CreateanAccountInfo(){

        LOGGER.log(Level.INFO, "Creating an account... \n");

        this.wait.until((d) -> NameTextfield.isDisplayed());
		NameTextfield.sendKeys(this.user.NAME);
		EmailTextfield.sendKeys(this.user.getEmail());
		PwdTextfield.sendKeys(this.user.getPassword());
		zipcode.sendKeys(this.user.ZIP);
		birthdayTextfield.sendKeys(this.user.BDAY);

		Select Dropdown = new Select(GenderDropdown);
		Dropdown.selectByVisibleText("Prefer Not To Say");
		Dropdown.selectByVisibleText("Prefer Not To Say");

	}

	public void input_payment() {

		LOGGER.log(Level.INFO, "Entering payment info... \n");

		this.wait.until((d) -> AddressTextfield.isDisplayed());
		AddressTextfield.sendKeys(this.user.getAddress());
		CityTextfield.sendKeys(this.user.CITY);

		Select Dropdown = new Select(StateDropdown);
		Dropdown.selectByVisibleText("CA");

		zipcode.sendKeys(this.user.ZIP);

		By iFRAME = By.tagName("iframe");
		By Recurly = By.id("recurly-hosted-field-input");

		 try {
		      int iframe = driver.findElements(iFRAME).size();

		      for(int i = 0; i < iframe; i++) {

	               int total = driver.findElements(Recurly).size();

                   driver.switchTo().frame(i);
                   driver.switchTo().defaultContent();

                   if (total!=0) {

		    		driver.switchTo().defaultContent();
		    		driver.switchTo().frame(i);
		    		recurlyfield.sendKeys(user.getCCN());
		    		driver.switchTo().defaultContent();
		    		driver.switchTo().frame(i+1);
		    		recurlyfield.sendKeys(user.getCCM());
		    		driver.switchTo().defaultContent();
		    		driver.switchTo().frame(i+2);
		    		recurlyfield.sendKeys(user.getCCY());
		    		driver.switchTo().defaultContent();
		    		driver.switchTo().frame(i+3);
		    		recurlyfield.sendKeys(user.getCVV());
		    		driver.switchTo().parentFrame();
		    		driver.switchTo().defaultContent();
		    		break;

		    	}
		    }
	}
		 catch(NoSuchElementException ignored) {
	}
	}

	/** NOTES -> Verifies error message for incorrect password*/
	public void selectSubmitBtn() {

		LOGGER.log(Level.INFO, "Selecting submit button... \n");

		this.wait.until((d) -> SubmitBtn.isDisplayed());
		SubmitBtn.click();
	}

	public String verify_showpicker() {
		this.wait.until((d) -> showpicker.isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("picker"));

		return driver.getCurrentUrl();

	}


	/** NOTES -> Verifies error message for incorrect password*/
	public void clickContinueBtn() {

		LOGGER.log(Level.INFO, "Clicking on Continue button... \n");

		ContinueBtn.click();
	}

    public void iAmHere() {
		assertPageEquals(signUpPageURL);
    }

    public void observePasswordFieldDisplaysHiddenPasswordAsAsterisks() {

        //TODO: refactor below; irrelevant method; missing asterisk validation.

		LOGGER.log(Level.INFO, "Verifying that password is hidden as asterisks... \n");

		for (int i = 0; i <= 2; i++) {
            try {
                password.sendKeys(passput);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public void verify_PAP(int testcase){
		main.java.com.viacomcbs.Assert.assertTrue(getPlan_url()
				.contains("plan"), testcase);
	}

	public void clickContinue() {
		clickContinueBtn();
	}

	public void verify_interstitial2( int testcase){
		main.java.com.viacomcbs.Assert.assertTrue(get_interstitial_url()
				.contains("interstitial/2"), testcase);
	}

	public void verify_CreateAnAccount( int testcase){
		main.java.com.viacomcbs.Assert.assertTrue(get_url()
				.contains("signup"), testcase);
	}

	public void verify_CreateAnAccount_textfield(){
		input_CreateanAccountInfo();
	}

	public void verify_interstitial3( int testcase){
		main.java.com.viacomcbs.Assert.assertTrue(get_interstitial_url()
				.contains("interstitial/3"), testcase);
	}

	public void verify_payment_textfield(){
		input_payment();
	}

	public void clickSubmitBtn(){
		selectSubmitBtn();
	}

}
