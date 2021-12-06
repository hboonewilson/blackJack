package blackJack.play;

public class PrintPotState {
    private PlayerPot playerPot;
    private TablePot tablePot;
    PrintPotState(PlayerPot playerPot, TablePot tablePot){
        this.playerPot = playerPot;
        this.tablePot = tablePot;
    }
    public void printWagerAndTablePot(Integer wager){
        System.out.println("Wage set: " + wager);
        System.out.println("In the pot: " + tablePot.getAmount()+"\n");
    }

    public void printDblDown(Integer wager) {
        System.out.printf("Doubling down! Wager: %d%n", wager);
        System.out.printf("The pot is doubled: %d%n", tablePot.getAmount());
    }
}
