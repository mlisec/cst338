import java.util.Scanner;

public class assig3 {

   public static void main(String [] args) {
      // init scanner
      Scanner reader = new Scanner(System.in);

      int userHand;

      do {
         // Display question
         System.out.print("How many hands? (1 - 10, please): ");

         // If user input not type of int
         while (!reader.hasNextInt()) {
            System.out.println("Not a valid answer.");
            reader.next();
         }
         // read user input
         userHand = reader.nextInt();

      } while (userHand < 1 || userHand > 10);

      // Init empty array of hand
      Hand[] allHands = new Hand[userHand];

      // Get user hand
      for (int i = 0; i < userHand; i++) {
         allHands[i] = new Hand();
      }

      // Init deck with 1 pack
      Deck myDecks = new Deck(1);

      // While decks still have card keep dealing
      while(myDecks.getTopCard() > 0) {
         for (int i = 0; i < userHand; i++) {
            // If deck is empty stop deal card
            if (myDecks.getTopCard() == 0) {
               break;
            }
            // Take card into user hand
            allHands[i].takeCard(myDecks.dealCard());
         }
      }


      // Display user hand with unshuffled deck
      System.out.println("Here are our hands, from unshuffled deck:");
      for (int i = 0; i < allHands.length; i++) {
         System.out.print("Hand = ");
         System.out.println(allHands[i] + "\n");
      }


      // Reset deck and shuffle
      myDecks.init(1);
      myDecks.shuffle();

      // Reset all hands
      for (int i = 0; i < userHand; i++) {
         allHands[i].resetHand();
      }

      // While decks still have card keep dealing
      while(myDecks.getTopCard() > 0) {
         for (int i = 0; i < userHand; i++) {
            // If deck is empty stop deal card
            if (myDecks.getTopCard() == 0) {
               break;
            }
            // Take card into user hand
            allHands[i].takeCard(myDecks.dealCard());
         }
      }

      // Display user hand with shuffled deck
      System.out.println("Here are our hands, from SHUFFLED deck:");
      for (int i = 0; i < allHands.length; i++) {
         System.out.print("Hand = ");
         System.out.println(allHands[i] + "\n");
      }

   }
}