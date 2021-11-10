package main.java.com.viacomcbs.testrail;

import java.io.IOException;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

public class SlackTest {
	
	public SlackTest() {
		// Load an env variable
		// If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
		String token = System.getenv("SLACK_TOKEN");

		// Initialize an API Methods client with the given token
		Slack slack = Slack.getInstance();
		MethodsClient methods = slack.methods(token);

		// Build a request object
		ChatPostMessageRequest request = ChatPostMessageRequest.builder()
		  .channel("#random") // Use a channel ID `C1234567` is preferrable
		  .text(":wave: Hi from a bot written in Java!")
		  .build();

		// Get a response as a Java object
		try {
			ChatPostMessageResponse response = methods.chatPostMessage(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SlackApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
