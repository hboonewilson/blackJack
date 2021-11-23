package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SuitTest {
    @Test
    void givenUseEnumToString_shouldReturnString(){
       Suit club =  Suit.CLUB;
        Assertions.assertEquals("Club", club.toString());
    }
}