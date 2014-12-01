package misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import basic.queue.RandomQueue;

public class Card {
	
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS
	}
	
	public enum Rank {
		ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	public static Iterable<Card> sortedDeck() {
		List<Card> deck = new ArrayList<Card>();
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}
	
	public static Iterator<Card> shuffledDeck() {
		final RandomQueue<Card> rq = new RandomQueue<Card>();
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				rq.enqueue(new Card(rank, suit));
			}
		}
		return new Iterator<Card>() {
			
			@Override
			public boolean hasNext() {
				return !rq.isEmpty();
			}

			@Override
			public Card next() {
				return rq.dequeue();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	private Suit suit;
	private Rank rank;
	
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public static void main(String[] args) {
		Iterator<Card> cards = Card.shuffledDeck();
		while(cards.hasNext()) {
			Card card = cards.next();
			System.out.println("The "+card.getRank()+" of "+card.getSuit());
		}
	}
	
}
