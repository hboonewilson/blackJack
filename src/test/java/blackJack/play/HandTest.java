package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class HandTest {
    Hand thirtyHand;
    Hand twentyHand;
    Hand nineteenHand;
    Hand tenHand;
    @BeforeEach
    void setUp(){
        List<Card> thirty = Arrays.asList(
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB));
        List<Card> twenty = Arrays.asList(
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB)
        );
        List<Card> nineteen = Arrays.asList(
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.FIVE, Suit.CLUB)
        );
        List<Card> ten = Arrays.asList(
                new Card(Face.TWO, Suit.CLUB),
                new Card(Face.EIGHT, Suit.CLUB)
        );
        thirtyHand = new Hand(thirty);
        twentyHand = new Hand(twenty);
        nineteenHand = new Hand(nineteen);
        tenHand = new Hand(ten);
    }

    @Test
    void givenSetHandValueHand_shouldReturnRightNumber(){
        Assertions.assertEquals(30, thirtyHand.getHandValue());
        Assertions.assertEquals(20, twentyHand.getHandValue());
    }
    @Test
    void givenSetHandValueHand_shouldReturnNineteen(){
        Assertions.assertEquals(19, nineteenHand.getHandValue());
    }
    @Test
    void givenCheckBust_shouldReturnTrueIfOverTwentyOne(){
        Assertions.assertTrue(thirtyHand.checkIfBust());
        Assertions.assertFalse(twentyHand.checkIfBust());
    }
    @Test
    void givenCheckIfOverSeventeen_shouldReturnTrueIfOverFalseIfUnder(){
        Assertions.assertFalse(tenHand.checkIfOverSeventeen());
        Assertions.assertTrue(twentyHand.checkIfOverSeventeen());
    }
    @Test
    void givenCheckIfCloser_shouldReturnTrueIfHandIsCloserFalseIfFurther(){
        Assertions.assertTrue(twentyHand.checkIfCloser(tenHand.getHandValue()));
        Assertions.assertFalse(tenHand.checkIfCloser(twentyHand.getHandValue()));
    }
    @Test
    void givenCheckTie_shouldReturnTrueIfTheyAreTheSame(){
        Hand twentyHandNew = twentyHand;
        Assertions.assertTrue(twentyHandNew.checkTie(twentyHand.getHandValue()));
    }
}