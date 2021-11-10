package main.java.com.viacomcbs.driver;

import java.util.HashMap;
import java.util.Map;

/** NOTES -> Class is for Driver Desired Capabilities*/

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;


import main.java.com.viacomcbs.PropertyConfig;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.PageObject;
import org.testng.Reporter;

@PageObject
public class Desired_Capabilities {

PropertyConfig config = new PropertyConfig();

	public DesiredCapabilities cap;
    
	 /**NOTES -> CHROME Desired Capabilities**/ 
	 public ChromeOptions ChromeDesiredCap(){
 
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = null;
	
		if(config.getConfig().getProperty("headless").toUpperCase().equals("ON")) {
			options.addArguments("headless");;
		}
		 options.addArguments("--no-sandbox");
		 options.addArguments("--disable-gpu");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--window-size=1600x900");
		 options.addArguments("--disable-notifications");
		 options.addArguments("--disable-popup-blocking");
//		options.addArguments("disable-infobars");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--enable-precise-memory-info");
//		options.addArguments("enable-automation");
//		options.addArguments("test-type=browser=chrome");
//		options.addArguments("--disable-notifications");
//		options.addArguments("w3c, False");
//		options.addArguments("--window-position=100,100");
//		options.addArguments("--start-maximized");
//		options.addArguments("test-type");
//		options.addArguments("enable-strict-powerful-feature-restrictions");
//		options.addArguments("disable-geolocation");
//		options.addArguments("--incognito");
		
//		prefs = new HashMap<String, Object>();
//	     prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
//	     prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
//	     prefs.put("profile.default_content_setting_values.geolocation", 2);
//	     prefs.put("profile.default_content_setting_values.notifications", 1);
//	     prefs.put("w3c", true);
//	     options.setExperimentalOption("prefs", prefs);
		return options;			
	}
	 	
	 /**NOTES -> FIREFOX Desired Capabilities**/ 
	public FirefoxOptions FirefoxDesiredCap(){
		FirefoxOptions capabilities = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();

		if(config.getConfig().getProperty("headless")
				.toUpperCase().equals("ON")) {
			capabilities.setHeadless(true);	
		}
		profile.setPreference("browser.private.browsing.autostart",true);
		profile.setPreference("dom.webnotifications.enabled", false);
		profile.setPreference("dom.push.enabled", false);
		profile.setPreference("dom.disable_open_during_load", false);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
		return capabilities;
	}
	
	 /**NOTES -> SAFARI Desired Capabilities**/ 
	 public SafariOptions SafariDesiredCap(){
		SafariOptions options = new SafariOptions();
		options.setCapability("browser.private.browsing.autostart",true);
		return options;
	}
	 
     /**NOTES -> EDGE Desired Capabilities**/  
	 public  EdgeOptions EdgeDesiredCap(){
		 EdgeOptions capabilities = new EdgeOptions();
		return capabilities;
	}
	
     /**NOTES -> ANDRIOD Desired Capabilities**/  
	public  DesiredCapabilities AndroidDevice(){
  DesiredCapabilities caps = new DesiredCapabilities();
	ChromeOptions options = new ChromeOptions();
	
	if(config.getConfig().getProperty("headless").toUpperCase().equals("ON")) {
		caps.setCapability("isHeadless", true);
	}	
	    caps.setCapability("automationName", "UiAutomator2");
    	caps.setCapability("deviceName", config.getConfig().getProperty("android1.name"));
  //  	caps.setCapability("chromedriverExecutable","src/main/resources/com/cbs/seleniumChrome/chromedriver");
 		caps.setCapability("platformVersion", config.getConfig().getProperty("android1.version"));
 		caps.setCapability("platformName",config.getConfig().getProperty("android1.platform"));
 		caps.setCapability("udid", config.getConfig().getProperty("android1.udid")); 	
 		caps.setCapability("browserName", config.getConfig().getProperty("android1.browser")); 
        caps.setCapability("newCommandTimeout", 100000);
        caps.setCapability("noReset", true);	
 		caps.setCapability("fullReset", false);  
		options.setExperimentalOption("w3c", false);
		caps.setCapability(ChromeOptions.CAPABILITY, options);	
  return caps; }
	
    /**NOTES -> IOS Desired Capabilities**/  
	public  DesiredCapabilities IOSDevice(){
    DesiredCapabilities caps = new DesiredCapabilities();
    
	if(config.getConfig().getProperty("headless").toUpperCase().equals("ON")) {
		caps.setCapability("isHeadless", true);
	}
	caps.setCapability("udid", config.getConfig().getProperty("ios1.udid"));   	
	caps.setCapability("automationName", "XCUITest");	
 	caps.setCapability("xcodeOrgId", config.getConfig().getProperty("ios1.codeOrgId")); 
 	caps.setCapability("xcodeSigningId", config.getConfig().getProperty("ios1.xcodeSigningId"));
    caps.setCapability("browserName", config.getConfig().getProperty("ios1.browser")); 
 	caps.setCapability("updatedWDABundleId", config.getConfig().getProperty("ios1.updatedWDABundleId"));
 	caps.setCapability("fullReset", false);  
 	caps.setCapability("showXcodeLog", true); 
    caps.setCapability("platformName", "Platform_Name");
    caps.setCapability("platformVersion", config.getConfig().getProperty("ios1.version"));
    caps.setCapability("deviceName",config.getConfig().getProperty("ios1.name"));
    caps.setCapability("noReset", false); 		
  return caps; }

	/**NOTES -> Cross Browser Testing Desired Capabilities **/
	public DesiredCapabilities CBT_ChromeDesiredCap(){

		String browser = Reporter.getCurrentTestResult()
				.getTestContext().getCurrentXmlTest()
				.getParameter("browser");

		String os = Reporter.getCurrentTestResult()
				.getTestContext().getCurrentXmlTest()
				.getParameter("os");


		String version = Reporter.getCurrentTestResult()
				.getTestContext().getCurrentXmlTest()
				.getParameter("os_version");

		String device = Reporter.getCurrentTestResult()
				.getTestContext().getCurrentXmlTest()
				.getParameter("device");

//		System.out.println(browser + " | " + os + " | " + version + " | " + device);

//		<parameter name="os" value="Mac OSX 10.14"/>
//        <parameter name="browser" value="chrome"/>
//        <parameter name="os_version" value="72"/>

//		String browser = "chrome";
//		String os = "Mac OSX 10.14";
//		String version = "72";
//		String device = "";

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("name", "1");
		caps.setCapability("os", os);
		caps.setCapability("record_video", "true");
		caps.setCapability("browser", browser);
		caps.setCapability("browserName", browser);
		caps.setCapability("version", version);
		caps.setCapability("screenResolution", "1366x768");
		caps.setCapability("record_network", "false");
		caps.setCapability("device", device);
		return caps;
	}
	

	
	
}
