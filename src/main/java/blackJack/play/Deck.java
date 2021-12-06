package blackJack.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> CARDS = new ArrayList<>();

    public Deck(){

        for(Face face: Face.values()) {

            for(Suit suit: Suit.values()){
                CARDS.add(new Card(face,suit));
            }
        }
    }
    public Deck(int num){
        for(int i=0; i<num;i++){
            for(Face face: Face.values()) {

                for(Suit suit: Suit.values()){
                    CARDS.add(new Card(face,suit));
                }
            }
        }
    }

    public List<Card> getDeck(){
        return CARDS;
    }

    public void shuffle(){
        Collections.shuffle(CARDS);
    }
    public Card draw(){
       return CARDS.remove(0);
    }
    public int getSize(){
        return CARDS.size();
    }
}
