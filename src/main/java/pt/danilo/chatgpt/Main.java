package pt.danilo.chatgpt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.danilo.chatgpt.model.request.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenAiRequest req = new OpenAiRequest();
		req.setModel("text-davinci-003");
		req.setPrompt("You are and AI\nAI:");
		req.setTemperature(0.5f);
		req.setMaxTokens(60);
		req.setTopP(1.0f);
		req.setFrequencyPenalty(0.5f);
		req.setPresencePenalty(0.5f);
		req.setStop(new String[] {"AI: "});
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonPayload = null;
		try {
			jsonPayload = mapper.writeValueAsString(req);
		} catch (JsonProcessingException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return;
		}
		System.out.println(jsonPayload);
	}

}
