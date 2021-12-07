package blackJack.play;

import blackJack.play.cardClasses.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuitTest {
    @Test
    void givenUseEnumToString_shouldReturnString(){
       Suit club =  Suit.CLUB;
        Assertions.assertEquals("Club", club.toString());
    }
}