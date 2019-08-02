
public class HandOutput {

	public static void main(String[] args) {
		
		Card card1 = new Card();
		Card card2 = new Card('3', Card.Suit.DIAMONDS);
		Card card3 = new Card('P', Card.Suit.HEARTS);
		
		Hand hand = new Hand();
		
		hand.takeCard(card3);
		
		hand.inspectCard(0);
		
		hand.resetHand();
		
		card3 = new Card('K', Card.Suit.HEARTS);
		
		while(hand.getNumCards() < Hand.MAX_CARDS){
			hand.takeCard(card1);
			hand.takeCard(card2);
			hand.takeCard(card3);
		}
		
		System.out.println(hand);
		
		hand.inspectCard(4);
		
		while(hand.getNumCards() > 0){
		hand.playCard();
		}
		
		System.out.println(hand);

	}

}
