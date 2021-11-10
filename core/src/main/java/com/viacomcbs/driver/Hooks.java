package main.java.com.viacomcbs.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import io.cucumber.java.After;
import main.java.com.viacomcbs.annotation.LazyAutowired;


public class Hooks {

    @LazyAutowired
    private ApplicationContext applicationContext;


//    @After
//    public void afterScenario(){
//
//        this.applicationContext.getBean(WebDriver.class).quit();
//    }

}
