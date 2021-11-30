package blackJack.play;

public class PrintDeckState {
    private PlayerPot playerPot;
    public PrintDeckState(PlayerPot playerPot){
        this.playerPot = playerPot;
    }
    public void printHandEnding(boolean playerWon) {
        if (playerWon){
            System.out.printf("%n%nPlayer Wins!%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
        else{
            System.out.printf("%n%nTable Wins.%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
    }
}
