package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class HandTest {

    @Test
    void givenSetHandValueHand_shouldReturnRightNumber(){
        Hand hand = new Hand();

        Card cardOne = new Card(Face.ACE, Suit.CLUB);
        Card cardTwo = new Card(Face.ACE, Suit.CLUB);
        Card cardThree = new Card(Face.FIVE, Suit.CLUB);

        hand.addCard(cardOne);
        hand.addCard(cardTwo);
        hand.addCard(cardThree);


        hand.setHandValue();

        Assertions.assertEquals(17, hand.getHandValue());
    }
    @Test
    void givenSetHandValueHand_shouldReturnNineteen(){
        Hand hand = new Hand();

        Card cardOne = new Card(Face.ACE, Suit.CLUB);
        Card cardTwo = new Card(Face.ACE, Suit.CLUB);
        Card cardThree = new Card(Face.ACE, Suit.CLUB);
        Card cardFour = new Card(Face.ACE, Suit.CLUB);
        Card cardFive = new Card(Face.FIVE, Suit.CLUB);

        hand.addCard(cardOne);
        hand.addCard(cardTwo);
        hand.addCard(cardThree);
        hand.addCard(cardFour);
        hand.addCard(cardFive);

        hand.setHandValue();

        Assertions.assertEquals(19, hand.getHandValue());
    }
    @Test
    void givenCheckBust_shouldReturnTrueIfOverTwentyOne(){
        Hand hand = new Hand();
        hand.addCard(new Card(Face.KING, Suit.CLUB));
        hand.addCard(new Card(Face.KING, Suit.CLUB));
        hand.addCard(new Card(Face.KING, Suit.CLUB));

        Hand twoHand = new Hand();
        twoHand.addCard(new Card(Face.KING, Suit.CLUB));
        twoHand.addCard(new Card(Face.KING, Suit.CLUB));

        Assertions.assertTrue(hand.checkIfBust());
        Assertions.assertFalse(twoHand.checkIfBust());
    }

}