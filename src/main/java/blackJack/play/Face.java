package blackJack.play;

public enum Face {
    ACE("Ace"),
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),;

    private final String NAME;

    Face(String s){
        NAME = s;
    }

    public String toString() {
        return NAME;
    }
}
