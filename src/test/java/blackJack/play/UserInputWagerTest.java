package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputWagerTest {
    UserInputWager userInputWager;
    PlayerPot playerPot;
    @BeforeEach
    void setUp(){
        playerPot = new PlayerPot();
        userInputWager = new UserInputWager(playerPot);
    }
    @ParameterizedTest
    @ValueSource(strings = {"10","20"})
    void givenInputShouldReturnWagerCorrectly(String input){
        int parseInt = Integer.parseInt(input);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(parseInt, userInputWager.setWage());
        Assertions.assertEquals(200-parseInt, playerPot.getAmount());
    }

}