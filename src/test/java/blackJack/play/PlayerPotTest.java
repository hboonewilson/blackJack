package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerPotTest {
    @Test
    void givenWagerReturnsTheCorrectBool(){
        PlayerPot playerPot = new PlayerPot();
        Assertions.assertFalse(playerPot.wager(400));
        Assertions.assertTrue(playerPot.wager(10));
    }

}