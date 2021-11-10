package test.java.com.viacomcbs.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

@CucumberOptions(
		plugin = {"pretty"},
		features = "classpath:features",
		glue = "test.java.com.viacomcbs.step_definitions",
		tags =  "@cbsnstream",
		publish = true,
		monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@org.testng.annotations.BeforeClass
	public void init() {
		PrintStream fileErrorOut;

		try {
			fileErrorOut = new PrintStream(new FileOutputStream("fileErrorOut.txt"));
			System.setErr(fileErrorOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}