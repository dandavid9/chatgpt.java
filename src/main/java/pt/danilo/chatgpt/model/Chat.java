package pt.danilo.chatgpt.model;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private final String prompt;
	private final List<Message> messages;
	
	public Chat(String prompt) {
		super();
		this.prompt = prompt;
		this.messages = new ArrayList<>();
	}
	
	public String getPrompt() {
		return prompt;
	}
	public List<Message> getMessages() {
		return messages;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
}