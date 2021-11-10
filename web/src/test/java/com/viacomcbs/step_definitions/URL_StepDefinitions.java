package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.page_objects.BasePage;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;

@CucumberContextConfiguration()
@SpringBootTest(classes = WebSpringApplication.class)
public class URL_StepDefinitions {

	@LazyAutowired
	private BasePage url;
	   
	@Given("I am on {string} page") 
	public void verify_interstitial(String path){		
		this.url.getaapath(path);
		}
}
