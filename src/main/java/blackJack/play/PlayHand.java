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
                playerHand.setHandValue();

                tableHand = new Hand();
                tableHand.addCard(theDeck.draw());
                tableHand.addCard(theDeck.draw());
                tableHand.setHandValue();

                PrintObject printObject = new PrintObject(playerHand, tableHand);
                printObject.printPlayerAndTableHandsAndInfo();

                Boolean hitMe = USER_INPUT.checkHitMe();
                while(hitMe){
                    playerHand.addCard(theDeck.draw());
                    if(playerHand.checkIfBust()){
                        return theDeck;
                    }
                    printObject.printPlayerAndTableHandsAndInfo();
                    hitMe = USER_INPUT.checkHitMe();
                }
                boolean tableBusted = tableHand.checkIfBust();
                boolean tableCloserTo21 = tableHand.checkIfCloser(playerHand.getHandValue());
                while(!tableBusted && !tableCloserTo21){
                    tableHand.addCard(theDeck.draw());
                    tableBusted = tableHand.checkIfBust();
                    tableCloserTo21 = tableHand.checkIfCloser(playerHand.getHandValue());
                }
                printObject.printPlayerAndTableHandsAndInfo();
        return theDeck;
    }

    public void determineWinner() {
        boolean playerWon = true;
        if(playerHand.checkIfBust()){
           System.out.println("player busted");
           playerWon = false;
       }
       else if (tableHand.checkIfBust()){
           System.out.println("table busted");
           playerWon = true;
       }
       else if (playerHand.checkIfCloser(tableHand.getHandValue())){
           System.out.println("player is closer to 21!");
           playerWon = true;
       }
       else if (tableHand.checkIfCloser(playerHand.getHandValue())){
           System.out.println("table is closer to 21!");
           playerWon = false;
       }



       if(playerWon){
           thePlayerPot.addToAmount(theTablePot.getAmount());
       }
        theTablePot.wipe();
        printDeckState.printHandEnding(playerWon);
    }
}
