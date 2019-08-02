
public class ModelCardGame {
    
    static int NUM_CARDS_PER_HAND = 7;
    static int  NUM_PLAYERS = 2;
    static int numPacksPerDeck = 1;
    static int numJokersPerPack = 0;
    static int numUnusedCardsPerPack = 0;
    static int[] winnings = new int[NUM_PLAYERS];
    
    public int getNumCardsPerHand(){
        return NUM_CARDS_PER_HAND;
    }
    
    public int getNumPlayers(){
        return NUM_PLAYERS;
    }
    
    public int getNumPacksPerDeck(){
        return numPacksPerDeck;
    }
    
    public int getNumJokersPerPack(){
        return numJokersPerPack;
    }
    
    public int getNumUnusedCardsPerPack(){
        return numUnusedCardsPerPack;
    }
    
    public int[] getWinnings(){
        return winnings;
    }

}
