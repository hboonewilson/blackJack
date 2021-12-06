package blackJack.play;

public class PlayHand {
    private final int NUM_DECKS;
    private final UserInputCheck USER_INPUT;
    private final PrintDeckState PRINT_DECK_STATE;
    private final PrintPotState PRINT_POT_STATE;

    private DoubleDownState doubleDownState;
    private  PlayerPot thePlayerPot;
    private  TablePot theTablePot;
    private Hand playerHand;
    private Hand tableHand;
    private UserInputWager userInputWager;
    private int wager;
    private Deck theDeck;

    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        NUM_DECKS = numOfDecks;
        thePlayerPot = playerPot;
        theTablePot = new TablePot();

        PRINT_DECK_STATE = new PrintDeckState(thePlayerPot);
        PRINT_POT_STATE = new PrintPotState(thePlayerPot, theTablePot);

        tableHand = new Hand();
        playerHand = new Hand();
        USER_INPUT = new UserInputCheck();
        userInputWager = new UserInputWager(thePlayerPot);
        theDeck = deck;
        theDeck.shuffle();

    }

    public void setWager() {
        wager = userInputWager.setWage();
        theTablePot.addToAmount(wager*2);
        PRINT_POT_STATE.printWagerAndTablePot(wager);
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


                PrintObject printObject = new PrintObject(playerHand, tableHand);
                printObject.printPlayerAndSomeTableHand();
                boolean dblDown = false;
                if (USER_INPUT.checkIfDoubleDown()){
                     doubleDownState = new DoubleDownState(thePlayerPot, theTablePot, playerHand, theDeck
                    );
                    dblDown =  doubleDownState.doublingDown(wager);
                    if (dblDown){
                        PRINT_POT_STATE.printDblDown(wager);
                        doubleDownState.draw();
                    }
                }
                if(!dblDown) {
                    Boolean hitMe = USER_INPUT.checkHitMe();
                    while (hitMe) {
                        playerHand.addCard(theDeck.draw());
                        if (playerHand.checkIfBust()) {
                            return theDeck;
                        }
                        printObject.printPlayerAndSomeTableHand();
                        hitMe = USER_INPUT.checkHitMe();
                    }
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
       PRINT_DECK_STATE.printHandEnding(playerWon, tableWon);
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

    public void setUserInputWager(UserInputWager userInputWager) {
        this.userInputWager = userInputWager;
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
