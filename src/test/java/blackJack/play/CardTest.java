package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void givenCardCreated_shouldPrintCorrectly(){
        Card card = new Card(Face.ACE, Suit.CLUB);
        Assertions.assertEquals("Ace of Clubs", card.toString());
    }


}