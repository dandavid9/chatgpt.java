package pt.brunojesus.chatgpt;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.brunojesus.chatgpt.model.request.*;
import pt.brunojesus.chatgpt.util.FileUtils;

public class Main {
	
	public static void main(String[] args) {
		FileUtils fileUtils = new FileUtils();
		List<String> lines = null;
		try {
			lines = fileUtils.readLines("application.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lines);
		
		
		OpenAiRequest req = new OpenAiRequest();
		req.setModel("text-davinci-003");
		req.setPrompt("You are and AI\nAI:");
		req.setTemperature(0.5f);
		req.setMaxTokens(60);
		req.setTopP(1.0f);
		req.setFrequencyPenalty(0.5f);
		req.setPresencePenalty(0.5f);
		req.setStop(new String[] {"AI:"});
				
		ObjectMapper mapper = new ObjectMapper();
		String jsonPayload = null;
		try {
			jsonPayload = mapper.writeValueAsString(req);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
			return;
		}
		
		System.out.println(jsonPayload);
	}

}
