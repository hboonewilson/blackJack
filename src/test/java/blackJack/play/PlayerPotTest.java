package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerPotTest {
    PlayerPot playerPot;
    PlayerPot playerPotOut;

    @BeforeEach
    void setUp(){
        playerPot = new PlayerPot();
        playerPotOut = new PlayerPot(0);
    }
    @Test
    void givenWagerReturnsTheCorrectBool(){
        Assertions.assertFalse(playerPot.wager(400));
        Assertions.assertEquals(200, playerPot.getAmount());

        Assertions.assertTrue(playerPot.wager(10));
        Assertions.assertEquals(190, playerPot.getAmount());
    }
    @Test
    void givenCheckIfOutOfMoney_shouldReturnTrueIfZeroAndFalseIfOverZero(){
        Assertions.assertTrue(playerPotOut.checkIfOutOfMoney());
        Assertions.assertFalse(playerPot.checkIfOutOfMoney());
    }
    @Test
    void givenAddToAmount_shouldAddThatAmountToPot(){
        playerPotOut.addToAmount(10);
        Assertions.assertEquals(10, playerPotOut.getAmount());
    }
}