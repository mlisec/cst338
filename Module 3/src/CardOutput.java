
public class CardOutput {

	public static void main(String[] args) {
		
		Card card1 = new Card();
		Card card2 = new Card('P', Card.Suit.HEARTS);
		Card card3 = new Card('K', Card.Suit.HEARTS);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		
		System.out.println();
		System.out.println();
		
		card1 = new Card('P', Card.Suit.DIAMONDS);
		card1 = new Card('9', Card.Suit.DIAMONDS);
		card1 = new Card('3', Card.Suit.CLUBS);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);

	}

}
