package blackJack.play;

public class Card {
    Face face;
    Suit suit;
    Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;
    }

    public String toString() {
        return String.format("%s of %ss", face.toString(), suit.toString());
    }
}
