package blackJack.play;

public class Card {
    private final Face face;
    private final Suit suit;

    Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;
    }
    public Face getFace() {
        return face;
    }

    public String toString() {
        return String.format("%s of %ss", face.toString(), suit.toString());
    }
}
