package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.TvProvider_PageObject;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Then;

@SpringBootTest(classes = WebSpringApplication.class)
public class TvProvider_StepDefinitions {
	
	@LazyAutowired
	public TvProvider_PageObject tvprovider;
	
	@Then("I am at the TV Provider page")
	public void i_am_at_the_tv_provider_page() {
		tvprovider.i_am_at_the_tv_provider_page();
	}
}
