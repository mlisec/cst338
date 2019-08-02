import javax.swing.*;
import java.awt.*;

public class Assig5 {
   // static for the 57 icons and their corresponding labels
   // normally we would not have a separate label for each card, but
   // if we want to display all at once using labels, we need to.

   static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
   static ImageIcon[] icon = new ImageIcon[NUM_CARD_IMAGES];

   static void loadCardIcons()
   {
      // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
      // in a SHORT loop.  For each file name, read it in and use it to
      // instantiate each of the 57 Icons in the icon[] array.
      // Loop 0-13
      int i = 0;
      for (int j = 0; j < 4; j++) {
         // Loop 0-3
         String cardSuite = turnIntIntoCardSuit(j);
         for (int k = 0; k < 14; k ++) {
            String cardValue = turnIntIntoCardValue(k);
            icon[i] = new ImageIcon(Assig5.class.getResource
               ("/resources/images/" + cardValue + cardSuite + ".gif"));
            i++;

         }
      }

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

   // a simple main to throw all the JLabels out there for the world to see
   public static void main(String[] args)
   {
      int k;

      // prepare the image icon array
      loadCardIcons();

      // establish main frame in which program will run
      JFrame frmMyWindow = new JFrame("Card Room");
      frmMyWindow.setSize(1150, 650);
      frmMyWindow.setLocationRelativeTo(null);
      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // set up layout which will control placement of buttons, etc.
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
      frmMyWindow.setLayout(layout);

      // prepare the image label array
      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         labels[k] = new JLabel(icon[k]);


      // place your 3 controls into frame
      for (k = 0; k < NUM_CARD_IMAGES; k++)
         frmMyWindow.add(labels[k]);

      // show everything to the user
      frmMyWindow.setVisible(true);
   }
}