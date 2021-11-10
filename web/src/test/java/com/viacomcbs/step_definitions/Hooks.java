package test.java.com.viacomcbs.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import main.java.com.viacomcbs.annotation.LazyAutowired;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.api.ApiTestResponse;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;


public class Hooks {

    @LazyAutowired
    private ApplicationContext applicationContext;



    @After
    public void afterScenario(Scenario scenario){

        this.applicationContext.getBean(WebDriver.class).quit();

    }


}
