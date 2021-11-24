package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class HandTest {

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
    @Test
    void givenSetHandValueHand_shouldReturnNineteen(){
        Hand hand = new Hand();
        List<Card> list = new ArrayList<>();

        Card cardOne = new Card(Face.ACE, Suit.CLUB);
        Card cardTwo = new Card(Face.ACE, Suit.CLUB);
        Card cardThree = new Card(Face.ACE, Suit.CLUB);
        Card cardFour = new Card(Face.ACE, Suit.CLUB);
        Card cardFive = new Card(Face.FIVE, Suit.CLUB);

        list.add(cardOne);
        list.add(cardTwo);
        list.add(cardThree);
        list.add(cardFour);
        list.add(cardFive);

        hand.setCards(list);

        hand.setHandValue();

        Assertions.assertEquals(19, hand.getHandValue());
    }

}