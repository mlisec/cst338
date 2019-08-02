import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ViewCardGame {
    
 // Human play Card
    playedCardLabels[1] = new JLabel(guiCard.getIcon(highCardGame.getHand
       (1).inspectCard(cardIndex)), JLabel
       .CENTER);

    // Computer play card
    playedCardLabels[0] = new JLabel(guiCard.getIcon(highCardGame.getHand
       (0).inspectCard(cardIndex)), JLabel
       .CENTER);

}
