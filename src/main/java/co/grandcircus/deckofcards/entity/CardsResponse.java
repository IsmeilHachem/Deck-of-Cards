package co.grandcircus.deckofcards.entity;

import java.util.List;

public class CardsResponse {
	
	private List<DrawCards> cards;

	public List<DrawCards> getCards() {
		return cards;
	}

	public void setCards(List<DrawCards> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "CardsResponse [cards=" + cards + "]";
	}
	
	


}
