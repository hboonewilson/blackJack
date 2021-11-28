package blackJack.play;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void givenCheckHitMe_shouldReturnCorrectValue(){
        UserInput userInput = new UserInput();
        Boolean returned = userInput.checkHitMe();
        System.out.println(returned);
    }

}