package blackJack.play;

import blackJack.play.cardClasses.Card;
import blackJack.play.cardClasses.Face;
import blackJack.play.cardClasses.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {
    Card card = new Card(Face.ACE, Suit.CLUB);
    @Test
    void givenCardCreated_shouldPrintCorrectly(){
        Assertions.assertEquals("Ace of Clubs", card.toString());
    }
    @Test
    void givenGetFace_shouldReturnCorrectFace(){
        Assertions.assertEquals(Face.ACE, card.getFace());
    }


}