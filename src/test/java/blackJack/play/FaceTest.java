package blackJack.play;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FaceTest {
    @Test
    void givenToString_shouldReturnProperName(){
        Assertions.assertEquals("Ace", Face.ACE.toString());
    }
}