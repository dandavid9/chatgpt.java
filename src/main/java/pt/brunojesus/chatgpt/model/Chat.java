package pt.brunojesus.chatgpt.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private String prompt;
	private List<Message> messages;
	
//	public Chat() {
//		this.message = new ArrayList<>();
//	}
	
	public String getPrompt() {
		return prompt;
	}
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public void setMessages(List<Message> messages) {
		if (messages == null) {
			throw new IllegalArgumentException("messages list cannot be null");
		}
		this.messages = messages;
	}
	
	public void addMessage(Message message) {
		if (this.messages == null) {
			this.messages = new ArrayList<>();
		}
		this.messages.add(message);
	}
}
