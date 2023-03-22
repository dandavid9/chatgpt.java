package pt.danilo.chatgpt.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiRequest {

	private String model;
	private String prompt;

	@JsonProperty("max_tokens")
	private Integer maxTokens;

	private Float temperature;

	@JsonProperty("top_p")
	private Float topP;

	@JsonProperty("frequency_penalty")
	private Float frequencyPenalty;

	@JsonProperty("presence_penalty")
	private Float presencePenalty;

	private String[] stop;

	public String getModel() {
		return model;
	}

	public String getPrompt() {
		return prompt;
	}

	public Integer getMaxTokens() {
		return maxTokens;
	}

	public Float getTemperature() {
		return temperature;
	}

	public Float getTopP() {
		return topP;
	}

	public Float getFrequencyPenalty() {
		return frequencyPenalty;
	}

	public Float getPresencePenalty() {
		return presencePenalty;
	}

	public String[] getStop() {
		return stop;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public void setMaxTokens(Integer maxTokens) {
		this.maxTokens = maxTokens;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public void setTopP(Float topP) {
		this.topP = topP;
	}

	public void setFrequencyPenalty(Float frequencyPenalty) {
		this.frequencyPenalty = frequencyPenalty;
	}

	public void setPresencePenalty(Float presencePenalty) {
		this.presencePenalty = presencePenalty;
	}

	public void setStop(String[] stop) {
		this.stop = stop;
	}
}
