package blackJack.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ValuesTest {

    @Test
    void givenValuesStaticMethod_shouldReturnThirteenMappings(){
        HashMap<Face, Integer> values = Values.createMap();
        Assertions.assertEquals(13, values.size());
    }
}