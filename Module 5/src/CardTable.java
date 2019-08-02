import javax.swing.*;
import java.awt.*;

class CardTable extends JFrame {

    static int MAX_CARDS_PER_HAND = 56;
    static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games

    private int numCardsPerHand;
    private int numPlayers;

    public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

    CardTable(String title, int numCardsPerHand, int numPlayers) {

       setTitle(title);

       if (numCardsPerHand > MAX_CARDS_PER_HAND || numPlayers > MAX_PLAYERS) {
          return;
       }

       this.numPlayers = numPlayers;
       this.numCardsPerHand = numCardsPerHand;

       new JPanel(new BorderLayout(3, 3));

       pnlComputerHand = new JPanel();
       pnlComputerHand.setPreferredSize(new Dimension(800, 150));
       pnlComputerHand.setBorder(BorderFactory.createTitledBorder(BorderFactory
          .createEtchedBorder(), "Computer Hand"));

       pnlHumanHand = new JPanel();
       pnlHumanHand.setPreferredSize(new Dimension(800, 150));
       pnlHumanHand.setBorder(BorderFactory.createTitledBorder(BorderFactory
          .createEtchedBorder(), "Your Hand"));

       pnlPlayArea = new JPanel();
       pnlPlayArea.setPreferredSize(new Dimension(800, 300));
       pnlPlayArea.setBorder(BorderFactory.createTitledBorder(BorderFactory
          .createEtchedBorder(), "Play Area"));

    }

    public int getNumCardsPerHand() {
       return numCardsPerHand;
    }
    public int getNumPlayers() {
       return numPlayers;
    }


 }

