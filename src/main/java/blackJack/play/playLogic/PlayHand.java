package blackJack.play.playLogic;

import blackJack.play.Deck;
import blackJack.play.inputAndPrint.PrintObject;
import blackJack.play.inputAndPrint.UserInputCheck;
import blackJack.play.potClasses.PlayerPot;
import blackJack.play.potClasses.TablePot;

public class PlayHand {
    private final int NUM_DECKS;
    private UserInputCheck userInput;
    private PrintObject printObject;
    private DoubleDownState doubleDownState;
    private PlayerPot thePlayerPot;
    private TablePot theTablePot;
    private Hand playerHand;
    private Hand tableHand;
    private int wager;
    private Deck theDeck;

    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        NUM_DECKS = numOfDecks;
        thePlayerPot = playerPot;
        theTablePot = new TablePot();

        printObject = new PrintObject();
        tableHand = new Hand();
        playerHand = new Hand();
        userInput = new UserInputCheck();
        theDeck = deck;
        theDeck.shuffle();

    }

    public void setWager() {
        wager = userInput.setWage(thePlayerPot);
        theTablePot.addToAmount(wager*2);
        printObject.printWagerAndTablePot(wager, theTablePot);
    }
    public Deck play(){
            if(theDeck.getSize() < 10){
                theDeck = new Deck(NUM_DECKS);
                theDeck.shuffle();
            }
                playerHand.addCard(theDeck.draw());
                playerHand.addCard(theDeck.draw());


                tableHand.addCard(theDeck.draw());
                tableHand.addCard(theDeck.draw());


                PrintObject printObject = new PrintObject();
                printObject.printPlayerAndSomeTableHand(playerHand, tableHand);
                boolean dblDown = false;
                if (userInput.checkIfDoubleDown()){
                     doubleDownState = new DoubleDownState(thePlayerPot, theTablePot, playerHand, theDeck
                    );
                    dblDown =  doubleDownState.doublingDown(wager);
                    if (dblDown){
                        printObject.printDblDown(wager, theTablePot);
                        doubleDownState.draw();
                    }
                }
                if(!dblDown) {
                    Boolean hitMe = userInput.checkHitMe();
                    while (hitMe) {
                        playerHand.addCard(theDeck.draw());
                        if (playerHand.checkIfBust()) {
                            return theDeck;
                        }
                        printObject.printPlayerAndSomeTableHand(playerHand, tableHand);
                        hitMe = userInput.checkHitMe();
                    }
                }
                Boolean overSeventeen = tableHand.checkIfOverSeventeen();
                while(!overSeventeen){
                    tableHand.addCard(theDeck.draw());
                    overSeventeen = tableHand.checkIfOverSeventeen();
                }
                printObject.printPlayerAndTableHandsAndInfo(playerHand, tableHand);
        return theDeck;
    }

    public void determineWinner() {
        boolean tableWon = false;
        boolean playerWon = false;
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
           thePlayerPot.addToAmount(theTablePot.getAmount());
       }
       printObject.printHandEnding(playerWon, tableWon, thePlayerPot);
    }

    private void dblDown(Boolean checkIfDoubleDown) {
        if (checkIfDoubleDown){
            if(thePlayerPot.wager(wager)){
                System.out.println("Doubling Down!");
                theTablePot.addToAmount(wager*2);
                System.out.println("Wage set: " + wager);
                System.out.println("In the pot: " + theTablePot.getAmount()+"\n");
            }
            else{
                System.out.println("Not enough to double down.");
                System.out.println("Money left: " + thePlayerPot.getAmount());
            }
        }
    }

    public TablePot getTHE_TABLE_POT() {
        return theTablePot;
    }
    public void setUserInput(UserInputCheck user_input){
        this.userInput = user_input;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public void setTableHand(Hand tableHand) {
        this.tableHand = tableHand;
    }


    public void setThePlayerPot(PlayerPot thePlayerPot) {
        this.thePlayerPot = thePlayerPot;
    }

    public void setTheTablePot(TablePot theTablePot) {
        this.theTablePot = theTablePot;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }
}
