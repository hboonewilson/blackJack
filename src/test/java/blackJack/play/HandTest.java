package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    @Disabled
    void givenReduceByAces_shouldReturnJustUnder21(){
        Hand hand = new Hand();
        List<Card> list = new ArrayList<>();

        Card cardOne = new Card(Face.ACE, Suit.CLUB);
        Card cardTwo = new Card(Face.JACK, Suit.CLUB);
        Card cardThree = new Card(Face.JACK, Suit.CLUB);

        list.add(cardOne);
        list.add(cardTwo);
        list.add(cardThree);

        hand.setCards(list);

        hand.setHandValue();
        Integer sum = hand.getHandValue();

        Assertions.assertEquals(21, hand.reduceByAces(sum));
    }
    @Test
    void givenSetHandValueHand_shouldReturnRightNumber(){
        Hand hand = new Hand();
        List<Card> list = new ArrayList<>();

        Card cardOne = new Card(Face.ACE, Suit.CLUB);
        Card cardTwo = new Card(Face.ACE, Suit.CLUB);
        Card cardThree = new Card(Face.FIVE, Suit.CLUB);

        list.add(cardOne);
        list.add(cardTwo);
        list.add(cardThree);

        hand.setCards(list);

        hand.setHandValue();

        Assertions.assertEquals(17, hand.getHandValue());
    }

}