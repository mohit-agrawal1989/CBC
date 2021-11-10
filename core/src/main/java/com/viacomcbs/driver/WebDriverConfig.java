package main.java.com.viacomcbs.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.com.viacomcbs.PropertyConfig;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.annotation.LazyConfiguration;
import main.java.com.viacomcbs.annotation.ThreadBean;

import org.openqa.selenium.WebDriver;

/** NOTES -> Configuration of all drivers*/
@LazyConfiguration
public class WebDriverConfig {
	
	@LazyAutowired
    private WebDriver driver;
    private AppiumDriverLocalService AppiumService;

    @LazyAutowired
    Desired_Capabilities dc; 
    
    @LazyAutowired
    PropertyConfig config ;


    @ThreadBean
 	public WebDriver setDriverPlatform(){
 		switch(config.getConfig().getProperty("platform").toUpperCase())

	 		{
	 		case ("CHROME"):
	 		driver = chromeDriver();
	 		break;	
	 		case ("FIREFOX"): 
		 	driver = firefoxDriver();
	 		break;
	 	    case ("SAFARI"): 
			driver = safariDriver();
	 	    break;
	 	    case ("EDGE"): 
            driver = edgeDriver();
	 		break;
	 	    case ("ANDROID"): 
	        driver = androidDriver();
		 	break;
	 	    case ("IOS"): 
	 	    driver = iosDriver();
			break;
			case ("CBT"):
			driver = crossBrowserTesting();
			break;
			default:
	 	 //  	driver = chromeDriver();
			driver = crossBrowserTesting();
	 	    break;
		}
		return driver ;
		} 

    /** NOTES -> Firefox driver*/
    public WebDriver firefoxDriver(){
    	
    	if(config.getConfig().getProperty("remote").toUpperCase().equals("ON")) {
    		try {
				return new RemoteWebDriver(new URL(config.getConfig()
				.getProperty("selenium.grid.url")), DesiredCapabilities.firefox());
			} catch (MalformedURLException e) {
				e.printStackTrace();}
    	}
       WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(dc.FirefoxDesiredCap());}

    /** NOTES -> Chrome driver*/
    public WebDriver chromeDriver(){
    	if(config.getConfig().getProperty("remote").toUpperCase().equals("ON")) {
    		try {
				return new RemoteWebDriver(new URL(config.getConfig()
				.getProperty("selenium.grid.url")), DesiredCapabilities.chrome());
			} catch (MalformedURLException e) {
				e.printStackTrace();}       }
    	 WebDriverManager.chromedriver().setup();
    	return new ChromeDriver( dc.ChromeDesiredCap());}

    /** NOTES -> Safari driver*/
    public WebDriver safariDriver(){
    	if(config.getConfig().getProperty("remote").toUpperCase().equals("ON")) {
    		try {
				return new RemoteWebDriver(new URL(config.getConfig()
				.getProperty("selenium.grid.url")), DesiredCapabilities.safari());
			} catch (MalformedURLException e) {
				e.printStackTrace();}      
    } return new SafariDriver(dc.SafariDesiredCap());}
    

    /** NOTES -> Edge driver*/
    public WebDriver edgeDriver(){
      	 WebDriverManager.edgedriver();
     	if(config.getConfig().getProperty("remote").toUpperCase().equals("ON")) {
    		try {
				return new RemoteWebDriver(new URL(config.getConfig()
				.getProperty("selenium.grid.url")), DesiredCapabilities.edge());
			} catch (MalformedURLException e) {
				e.printStackTrace();}      
       } return new EdgeDriver(dc.EdgeDesiredCap());
      }

    /** NOTES -> Android driver*/
    public WebDriver androidDriver() {
    	try {
			 AppiumService =  AppiumDriverLocalService
					 .buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(config.getConfig()
							.getProperty("appiumpath")))
					.usingAnyFreePort()
					.withAppiumJS(new File(config.getConfig()
							.getProperty("appiumjs")))
			     	.withIPAddress(config.getConfig()
							.getProperty("selenium.grid.url")));
			 
			 AppiumService.start();		
		}catch(IllegalStateException e) {
			e.printStackTrace();		
		}				
		return driver = new AndroidDriver<MobileElement>(AppiumService,dc.AndroidDevice());
    	}

    /** NOTES -> IOS driver*/
    public WebDriver iosDriver() {
    	try {
			 AppiumService =  AppiumDriverLocalService
					 .buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(config.getConfig()
							.getProperty("appiumpath")))
					.usingAnyFreePort()
					.withAppiumJS(new File(config.getConfig()
							.getProperty("appiumjs")))
			     	.withIPAddress(config.getConfig()
							.getProperty("selenium.grid.url")));
			 AppiumService.start();				  
			
		}catch(IllegalStateException e) {
			e.printStackTrace();		
		}				
		return driver = new IOSDriver<MobileElement>(AppiumService,dc.IOSDevice());
    }

	/** NOTES -> CrossBrowserTesting  */
	public WebDriver crossBrowserTesting(){
//		System.out.println("crossBrowserTesting(): "
//				+ config.getConfig().getProperty("username") + ":"
//				+ config.getConfig().getProperty("authkey")
//				+ config.getConfig().getProperty("platform")
//		);

		try {
			driver = new RemoteWebDriver(new URL("http://"
					+ config.getConfig().getProperty("username") + ":"
					+ config.getConfig().getProperty("authkey")
					+"@hub.crossbrowsertesting.com:80/wd/hub"), dc.CBT_ChromeDesiredCap());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver; }
}