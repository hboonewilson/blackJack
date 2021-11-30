package blackJack.play;

public class PrintDeckState {
    private PlayerPot playerPot;
    public PrintDeckState(PlayerPot playerPot){
        this.playerPot = playerPot;
    }
    public void printHandEnding(boolean playerWon, boolean tableWon) {
        if (playerWon && tableWon){
            System.out.printf("%n%nPush.%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
        else if (!playerWon && tableWon){
            System.out.printf("%n%nTable Wins.%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
        else if (playerWon && !tableWon){
            System.out.printf("%n%nPlayer Wins!%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
    }
}
