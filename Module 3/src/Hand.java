import java.util.Arrays;

//Holds card values in an array
public class Hand {
    
	//needed to set hand size
    public static final int MAX_CARDS = 50;
    
    //private variables for hand and how many cards
    private Card[] myCards = new Card[MAX_CARDS];
    private int numCards = 0;
    
    //sets each card in hand array to null and card count to 0
    public void resetHand(){
        for(int i = 0; i < MAX_CARDS; i++){
            myCards[i] = null;
        }
        numCards = 0;
    }
    
    //takes a card and puts in in the next spot in the array
    public boolean takeCard(Card card){
        if(numCards < MAX_CARDS){

            Card x = new Card();
            x = card;
            myCards[numCards] = x;
            numCards++;
            return true;
        }
        else{
            System.out.println("Hand is full.");
            return false;
        }
    	
    }
    
    //takes the top most card in the array and displays it
    public Card playCard(){
        Card play = myCards[numCards - 1];
        myCards[numCards - 1] = null;
        numCards--;
        System.out.println("Playing " + play);
        if(myCards[0] == null){
            resetHand();
        }
        return play;
    }
    
    //String to see what is in hand or if your hand is empty
    public String toString() {

    	// build new array
    	Card[] temp = new Card[numCards];

    	for (int i = 0; i < numCards; i++) {
    	if (myCards[i] != null) {
    	temp[i] = myCards[i];
    	}
    	}

    	return Arrays.toString(temp).replace("[", "(").replace("]", ")");
    	}
    
    //accessor to get the number of cards in hand
    public int getNumCards(){
            return numCards;
        }
    
    
    //accessor to see if a card in hand is valid
    public Card inspectCard(int k){
        Card current = myCards[k];
        if (k > numCards) {
            return new Card('P', Card.Suit.CLUBS);
        }
        if(current.getFlag() == true){
            System.out.println("Card is invalid.");
            return current;
    	}
        else{
            System.out.println(current);
            return current;
        }
    }

}
