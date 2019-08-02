import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

class GUICard {

    private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    static boolean iconsLoaded = false;

    public GUICard() {
       if (!iconsLoaded) {
          loadCardIcons();
          iconBack = new ImageIcon(GUICard.class.getResource
             ("/resources/images/BK.gif"));
       }
    }

    static void loadCardIcons()
    {
       // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
       // in a SHORT loop.  For each file name, read it in and use it to
       // instantiate each of the 57 Icons in the icon[] array.
       // Loop 0-13
       for (int j = 0; j < 4; j++) {
          // Loop 0-3
          String cardSuite = turnIntIntoCardSuit(j);
          for (int k = 0; k < 14; k ++) {
             String cardValue = turnIntIntoCardValue(k);
             iconCards[k][j] = new ImageIcon(GUICard.class.getResource
                ("/resources/images/" + cardValue + cardSuite + ".gif"));
          }
       }
       iconsLoaded = true;
    }

    // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
    static String turnIntIntoCardValue(int k)
    {
       String temp = "";
       switch (k) {
          case 0: {
             temp = "A";
          }break;
          case 1: {
             temp = "2";
          }break;
          case 2: {
             temp = "3";
          }break;
          case 3: {
             temp = "4";
          }break;
          case 4: {
             temp = "5";
          }break;
          case 5: {
             temp = "6";
          }break;
          case 6: {
             temp = "7";
          }break;
          case 7: {
             temp = "8";
          }break;
          case 8: {
             temp = "9";
          }break;
          case 9: {
             temp = "T";
          }break;
          case 10: {
             temp = "J";
          }break;
          case 11: {
             temp = "Q";
          }break;
          case 12: {
             temp = "K";
          }break;
          case 13: {
             temp = "X";
          }break;
       }
       // an idea for a helper method (do it differently if you wish)
       return temp;
    }

    // turns 0 - 3 into "C", "D", "H", "S"
    static String turnIntIntoCardSuit(int j)
    {
       String temp = "";
       switch (j) {
          case 0: {
             temp = "C";
          }break;
          case 1: {
             temp = "D";
          }break;
          case 2: {
             temp = "H";
          }break;
          case 3: {
             temp = "S";
          }break;
       }
       // an idea for a helper method (do it differently if you wish)
       return temp;
    }
    static int valueAsInt(char card) {
       int temp = 0;
       switch (card) {
          case 'A': {
             temp = 0;
          }break;
          case '2': {
             temp = 1;
          }break;
          case '3': {
             temp = 2;
          }break;
          case '4': {
             temp = 3;
          }break;
          case '5': {
             temp = 4;
          }break;
          case '6': {
             temp = 5;
          }break;
          case '7': {
             temp = 6;
          }break;
          case '8': {
             temp = 7;
          }break;
          case '9': {
             temp = 8;
          }break;
          case 'T': {
             temp = 9;
          }break;
          case 'J': {
             temp = 10;
          }break;
          case 'Q': {
             temp = 11;
          }break;
          case 'K': {
             temp = 12;
          }break;
          case 'X': {
             temp = 13;
          }break;
       }
       // an idea for a helper method (do it differently if you wish)
       return temp;
    }
    static int suitAsInt(Card.Suit suit) {
       int temp = 0;
       switch (suit) {
          case CLUBS: {
             temp = 0;
          }break;
          case DIAMONDS: {
             temp = 1;
          }break;
          case HEARTS: {
             temp = 2;
          }break;
          case SPADES: {
             temp = 3;
          }break;
       }
       // an idea for a helper method (do it differently if you wish)
       return temp;
    }

    static public Icon getIcon(Card card) {

       return iconCards[valueAsInt(card.getValue())][suitAsInt(card.getSuit())];

    }
    static public Icon getBackCardIcon() {

       return iconBack;

    }

 }