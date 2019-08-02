//Defines the Card object
public class Card {
    //Defines a variable of type Suit
    public enum Suit{
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    //Used to hold the card value
    private char value;
    //Used to hold the card suit
    private Suit suit;
    //Used to verify a legal entry
    private boolean errorFlag;
    
    //constructor to allow arguments to be passed into the object
    public Card(char value, Suit suit){
        this.value = value;
        this.suit = suit;
        errorFlag = set(value, suit);
    }
    
    //a default constructor
    public Card(){
        value = 'A';
        suit = Suit.SPADES;
    }
    
    //enables the card to be printed
    public String toString(){
        //checks if it is valid before printing
        if(errorFlag == true){
            String invalid = "invalid";
            return invalid;
        }
        else{
            String str1 = (value + " of " + suit);
            return str1;
        }
    }
    
    //checks if the entry is a valid entry
    public boolean set(char value, Suit suit){
        if((Character.getNumericValue(value) < 2 || Character.getNumericValue(value) > 9) 
                && (value != 'T' && value != 'J'
                && value != 'Q' && value != 'K' && value != 'A')
                || (suit != Suit.CLUBS && suit != Suit.DIAMONDS
                && suit != Suit.HEARTS && suit != Suit. SPADES)){
            errorFlag = true;
            return errorFlag;
        }
        else{
            errorFlag = false;
            return errorFlag;
        }
    }
    
    //gets value of the card
    public char getValue(){
        return value;
    }
    
    //gets the suit of the card
    public Suit getSuit(){
        return suit;
    }
    
    //gets the validity of the card
    public boolean getFlag(){
        return errorFlag;
    }
    
    //checks if 2 cards are equal
    public boolean equals(Card card){
        //checks to see if the card is itself
        if(card == this){
            return true;
        }
    	
        //makes sure that the card is a Card object
        if(!(card instanceof Card)){
            return false;
        }
    	
        //superimposes the card value to be used for comparison
        Card x = (Card) card;
    	
        //comparison functions to see if 2 cards are equal
        return value == x.value && suit == x.suit;
    		
        }
    

}
