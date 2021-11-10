package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.viacomcbs.page_objects.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import org.testng.Assert;

@SpringBootTest(classes = WebSpringApplication.class)
public class Utility_StepDefinitions {
	private final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

	@Autowired
	protected WebDriver driver;

	
	@Given("console log is grabbed")
	public void console_log_is_grabbed() {
	    // Write code here that turns the phrase above into concrete actions
	    
    	PrintStream err = System.err;
    	try {
			System.setErr(new PrintStream(new FileOutputStream("err.txt")));//not grabbing the cucumber banner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	System.err.println("In Utility_StepDefinitions");
    	System.err.println("Capture Test for Before Class");
	}

}
