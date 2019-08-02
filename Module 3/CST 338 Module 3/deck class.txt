import java.lang.Math;

class Deck {

   public final int MAX_CARDS = 260;

   private static Card[] masterPack;

   private Card[] cards;
   private int topCard;
   private int numPacks;

   // default constructor
   public Deck() {

      allocateMasterPack();
      cards = masterPack;
      numPacks = 1;
      topCard = 52;

   }

   public Deck(int numPacks) {
      // Only allow if numbers of cards not exceed max cards
      if (MAX_CARDS > 52 * numPacks) {
         // Initialize Master Pack
         allocateMasterPack();
         // Initialize cards array size of 52 * numpacks
         cards = new Card[52 * numPacks];
         topCard = 0;
         
         // Loop to add card into cards array
         for (int k = 0; k < numPacks; k++) {
            for (int i = 0; i < masterPack.length; i++) {
               cards[topCard] = masterPack[i];
               topCard++;
            }
         }

         this.numPacks = numPacks;
      }
   }

   public void init(int numPacks) {

      // Only allow if numbers of cards not exceed max cards
      if (MAX_CARDS > 52 * numPacks) {
         // Initialize Master Pack
         allocateMasterPack();
         
         // Initialize cards array size of 52 * numpacks
         cards = new Card[52 * numPacks];
         topCard = 0;
         
         // Loop to add card into cards array
         for (int k = 0; k < numPacks; k++) {
            for (int i = 0; i < masterPack.length; i++) {
               cards[topCard] = masterPack[i];
               topCard++;
            }
         }

         this.numPacks = numPacks;
      }

   }

   public void shuffle() {
      // Loop cards array to shuffle card
      for(int i = 0; i < cards.length; i++) {
         // Generate a random number from 0 to cards length
         int random = (int)(Math.random() * cards.length);

         // Swap the random position with the current index element
         Card temp = cards[i];
         cards[i] = cards[random];
         cards[random] = temp;
      }
   }

   public Card dealCard() {

      // Get top position of card deck
      Card card = cards[topCard - 1];

      // Remove card from deck
      cards[topCard - 1] = null;

      // Reduce number of card on deck
      topCard--;

      // Return card
      return card;

   }

   public int getTopCard() {
      return topCard;
   }

   public Card inspectCard(int k) {
      
      // If k is invalid return Invalid card
      if (k >= topCard) {
         return new Card('P', Card.Suit.CLUBS);
      }

      // Return card
      return cards[k];

   }

   private static void allocateMasterPack() {
      // Create master deck only when it never created
      if (masterPack == null) {
         masterPack = new Card[]{
            new Card('A', Card.Suit.CLUBS),
            new Card('A', Card.Suit.HEARTS),
            new Card('A', Card.Suit.SPADES),
            new Card('A', Card.Suit.DIAMONDS),
            new Card('2', Card.Suit.CLUBS),
            new Card('2', Card.Suit.HEARTS),
            new Card('2', Card.Suit.SPADES),
            new Card('2', Card.Suit.DIAMONDS),
            new Card('3', Card.Suit.CLUBS),
            new Card('3', Card.Suit.HEARTS),
            new Card('3', Card.Suit.SPADES),
            new Card('3', Card.Suit.DIAMONDS),
            new Card('4', Card.Suit.CLUBS),
            new Card('4', Card.Suit.HEARTS),
            new Card('4', Card.Suit.SPADES),
            new Card('4', Card.Suit.DIAMONDS),
            new Card('5', Card.Suit.CLUBS),
            new Card('5', Card.Suit.HEARTS),
            new Card('5', Card.Suit.SPADES),
            new Card('5', Card.Suit.DIAMONDS),
            new Card('6', Card.Suit.CLUBS),
            new Card('6', Card.Suit.HEARTS),
            new Card('6', Card.Suit.SPADES),
            new Card('6', Card.Suit.DIAMONDS),
            new Card('7', Card.Suit.CLUBS),
            new Card('7', Card.Suit.HEARTS),
            new Card('7', Card.Suit.SPADES),
            new Card('7', Card.Suit.DIAMONDS),
            new Card('8', Card.Suit.CLUBS),
            new Card('8', Card.Suit.HEARTS),
            new Card('8', Card.Suit.SPADES),
            new Card('8', Card.Suit.DIAMONDS),
            new Card('9', Card.Suit.CLUBS),
            new Card('9', Card.Suit.HEARTS),
            new Card('9', Card.Suit.SPADES),
            new Card('9', Card.Suit.DIAMONDS),
            new Card('T', Card.Suit.CLUBS),
            new Card('T', Card.Suit.HEARTS),
            new Card('T', Card.Suit.SPADES),
            new Card('T', Card.Suit.DIAMONDS),
            new Card('J', Card.Suit.CLUBS),
            new Card('J', Card.Suit.HEARTS),
            new Card('J', Card.Suit.SPADES),
            new Card('J', Card.Suit.DIAMONDS),
            new Card('Q', Card.Suit.CLUBS),
            new Card('Q', Card.Suit.HEARTS),
            new Card('Q', Card.Suit.SPADES),
            new Card('Q', Card.Suit.DIAMONDS),
            new Card('K', Card.Suit.CLUBS),
            new Card('K', Card.Suit.HEARTS),
            new Card('K', Card.Suit.SPADES),
            new Card('K', Card.Suit.DIAMONDS),
         };
      }
   }
}