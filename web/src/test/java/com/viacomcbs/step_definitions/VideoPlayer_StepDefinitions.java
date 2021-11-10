package test.java.com.viacomcbs.step_definitions;

import main.java.com.viacomcbs.WebSpringApplication;
import main.java.com.viacomcbs.annotation.LazyAutowired;
import main.java.com.viacomcbs.page_objects.VideoPlayer_PageObject;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Then;


@SpringBootTest(classes = WebSpringApplication.class)
public class VideoPlayer_StepDefinitions {
	
	@LazyAutowired
	public VideoPlayer_PageObject videoPlayer;
	
	@Then("I arrive at the Video Player page")
	public void i_am_at_the_video_player_page() {
		videoPlayer.i_am_at_the_video_player_page();
	}
	
	@Then("the video should be {string}")
	public void the_video_should_be(String str) {
		videoPlayer.the_video_should_be(str);
	    }
	}
