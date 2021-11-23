package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp(){
        deck = new Deck();
    }

    @Test
    void givenDrawIsCalledOnShuffledDeck_shouldReturnAceOfHearts(){
        Card card = deck.draw();
        Assertions.assertEquals("Ace of Hearts", card.toString());
    }
    @Test
    void givenSizeIsCalledThenDrawThenSizeAgian_shouldReturn52Then51(){
        Assertions.assertEquals(52,deck.getSize());
        deck.draw();
        Assertions.assertEquals(51, deck.getSize());
    }
    @Test
    void givenMultipleDecksToBeCreated_sizeShouldReturn52TimesTheSize(){
        Deck threeDecks = new Deck(3);
        Assertions.assertEquals(156, threeDecks.getSize());
    }

}