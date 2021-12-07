package blackJack.play;


import blackJack.play.inputAndPrint.UserInputCheck;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Disabled
@ExtendWith(MockitoExtension.class)
class UserInputCheckTest {
    UserInputCheck userInput = new UserInputCheck();

    @ParameterizedTest
    @ValueSource(strings = {"y", "Y","yes", "YES"})
    void givenCheckHitMe_whenInputIsYes_shouldReturnTrue(){
        String input = "YES";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertTrue(userInput.checkHitMe());
    }
    @ParameterizedTest
    @ValueSource(strings = {"n", "N","no", "NO"})
    void givenCheckHitMe_whenInputIsNo_shouldReturnFalse(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertFalse(userInput.checkHitMe());
    }
    @ParameterizedTest
    @ValueSource(strings = {"y", "Y","yes", "YES"})
    void givenCheckGameState_whenInputIsYes_shouldReturnTrue(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertTrue(userInput.checkGameState());
    }
    @ParameterizedTest
    @ValueSource(strings = {"n", "N","no", "NO"})
    void givenCheckGameState_whenInputIsNo_shouldReturnFalse(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertFalse(userInput.checkGameState());
    }
    @ParameterizedTest
    @ValueSource(strings = {"d", "D","double", "DOUBLE"})
    void givenCheckIfDoubleDown_whenInputIsYes_shouldReturnTrue(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertTrue(userInput.checkIfDoubleDown());
    }
    @ParameterizedTest
    @ValueSource(strings = {"n", "N","no", "NO"})
    void givenCheckIfDoubleDown_whenInputIsNo_shouldReturnFalse(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertFalse(userInput.checkIfDoubleDown());
    }
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void givenDeckNumber_whenInputIsNumber_shouldReturnThatNumber(String input){
        int parseInt = Integer.parseInt(input);

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(parseInt, userInput.deckNumber());
    }
}