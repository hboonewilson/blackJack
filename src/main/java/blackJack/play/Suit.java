package blackJack.play;

public enum Suit {
    HEART ("Heart"),
    DIAMOND ("Diamond"),
    CLUB ("Club"),
    SPADE ("Spade"),;
    private final String name;
    private Suit(String s){
        name = s;
    }

    public String toString() {
        return name;
    }
}
