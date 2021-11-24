package blackJack.play;

import java.util.HashMap;

public final class Values {
     public static HashMap<Face, Integer> createMap(){
         HashMap<Face, Integer> mapToReturn = new HashMap<>();
         mapToReturn.put(Face.ACE, 11);
         mapToReturn.put(Face.TWO, 2);
         mapToReturn.put(Face.THREE, 3);
         mapToReturn.put(Face.FOUR, 4);
         mapToReturn.put(Face.FIVE, 5);
         mapToReturn.put(Face.SIX, 6);
         mapToReturn.put(Face.SEVEN, 7);
         mapToReturn.put(Face.EIGHT, 8);
         mapToReturn.put(Face.NINE, 9);
         mapToReturn.put(Face.TEN, 10);
         mapToReturn.put(Face.JACK, 10);
         mapToReturn.put(Face.QUEEN, 10);
         mapToReturn.put(Face.KING, 10);
         return mapToReturn;
     }
}
