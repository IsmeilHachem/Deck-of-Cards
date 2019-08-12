package co.grandcircus.deckofcards.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Homepage {

	private Boolean shuffled;
	private Boolean success;
	@JsonProperty("deck_id")
	private String deckId;
	private Integer remaining;

	public Boolean getShuffled() {
		return shuffled;
	}

	public void setShuffled(Boolean shuffled) {
		this.shuffled = shuffled;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getdeckId() {
		return deckId;
	}

	public void setdeckId(String deckId) {
		this.deckId = deckId;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "Homepage [shuffled=" + shuffled + ", success=" + success + ", id=" + deckId + ", remaining=" + remaining
				+ "]";
	}

}
