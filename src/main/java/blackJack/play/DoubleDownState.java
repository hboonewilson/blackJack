package blackJack.play;

public class DoubleDownState {
    private Deck theDeck;
    private PlayerPot playerPot;
    private TablePot tablePot;

    private Hand playerHand;

    DoubleDownState(PlayerPot playerPot, TablePot tablePot, Hand playerHand, Deck deck){
        this.theDeck = deck;
        this.playerHand = playerHand;
        this.tablePot = tablePot;
        this.playerPot = playerPot;
    }
    public boolean doublingDown(Integer wager) {
        if (playerPot.wager(wager)){
            tablePot.addToAmount(wager*2);
            return true;
        }
        else{
            return false;
        }
    }

    public void draw() {
        playerHand.addCard(theDeck.draw());
    }
}
