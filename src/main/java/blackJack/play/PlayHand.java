package blackJack.play;
import java.util.Scanner;

public class PlayHand {
    private final int NUM_DECKS;
    private final UserInput USER_INPUT;
    private int wager;
    private PlayerPot thePlayerPot;
    private Deck theDeck;
    private TablePot theTablePot;
    private Hand playerHand;
    private Hand tableHand;
    private PrintDeckState printDeckState;

    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        NUM_DECKS = numOfDecks;
        USER_INPUT = new UserInput();
        theDeck = deck;
        theDeck.shuffle();
        thePlayerPot = playerPot;
        theTablePot = new TablePot();
        printDeckState = new PrintDeckState(thePlayerPot);

    }

    public void setWager() {
        boolean wageSet = false;
        int number = 0;
        while(!wageSet){
            Scanner scanner = new Scanner(System.in);
            System.out.printf("%nWager(You have %d left): ", thePlayerPot.getAmount());
            wager = scanner.nextInt();
            wageSet = thePlayerPot.wager(wager);
        }
        theTablePot.addToAmount(wager*2);
        System.out.println("Wage set: " + wager);
        System.out.println("In the pot: " + theTablePot.getAmount()+"\n");
    }
    public Deck play(){
            if(theDeck.getSize() < 4){
                theDeck = new Deck(NUM_DECKS);
                theDeck.shuffle();
            }
                playerHand = new Hand();
                playerHand.addCard(theDeck.draw());
                playerHand.addCard(theDeck.draw());


                tableHand = new Hand();
                tableHand.addCard(theDeck.draw());
                tableHand.addCard(theDeck.draw());


                PrintObject printObject = new PrintObject(playerHand, tableHand);
                printObject.printPlayerAndSomeTableHand();

                Boolean hitMe = USER_INPUT.checkHitMe();
                while(hitMe){
                    playerHand.addCard(theDeck.draw());
                    if(playerHand.checkIfBust()){
                        return theDeck;
                    }
                    printObject.printPlayerAndSomeTableHand();
                    hitMe = USER_INPUT.checkHitMe();
                }
                Boolean overSeventeen = tableHand.checkIfOverSeventeen();
                while(!overSeventeen){
                    tableHand.addCard(theDeck.draw());
                    overSeventeen = tableHand.checkIfOverSeventeen();
                }
                printObject.printPlayerAndTableHandsAndInfo();
        return theDeck;
    }

    public void determineWinner() {
        boolean tableWon = false;
        boolean playerWon = true;
        if(playerHand.checkIfBust()){
           System.out.println("player busted");
           playerWon = false;
           tableWon = true;
       }
       else if (tableHand.checkIfBust()){
           System.out.println("table busted");
           playerWon = true;
           tableWon = false;
       }
       else if (playerHand.checkIfCloser(tableHand.getHandValue())){
           System.out.println("player is closer to 21!");
           playerWon = true;
           tableWon = false;
       }
       else if (tableHand.checkIfCloser(playerHand.getHandValue())){
           System.out.println("table is closer to 21!");
           playerWon = false;
           tableWon = true;
       }
       else if (tableHand.checkTie(playerHand.getHandValue())){
           System.out.println("Push!");
           tableWon = true;
           playerWon = true;
        }



       if(tableWon && playerWon){
           thePlayerPot.addToAmount(wager);
       }
       else if (playerWon){
           thePlayerPot.addToAmount(thePlayerPot.getAmount());
       }
       printDeckState.printHandEnding(playerWon, tableWon);
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public void setTableHand(Hand tableHand) {
        this.tableHand = tableHand;
    }
}
