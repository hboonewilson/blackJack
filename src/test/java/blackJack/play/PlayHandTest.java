package blackJack.play;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayHandTest {
    @Test
    void givenDetermineWinner_shouldAddWagerToCorrectPots(){
        int numOfDecks = 1;

        Deck deck = new Deck(numOfDecks);
        PlayerPot playerPot = new PlayerPot(25);

        PlayHand playHand = new PlayHand(deck,playerPot,numOfDecks);

        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card(Face.KING, Suit.CLUB));
        playerCards.add(new Card(Face.ACE, Suit.CLUB));

        List<Card> tableCards = new ArrayList<>();
        tableCards.add(new Card(Face.EIGHT, Suit.CLUB));
        tableCards.add(new Card(Face.TWO, Suit.CLUB));

        Hand playerHand = new Hand(playerCards);
        Hand tableHand = new Hand(tableCards);

        playHand.setPlayerHand(playerHand);
        playHand.setTableHand(tableHand);

        playHand.determineWinner();

    }

}