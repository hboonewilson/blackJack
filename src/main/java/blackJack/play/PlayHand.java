package blackJack.play;
import java.util.Scanner;

public class PlayHand {
    private final int NUM_DECKS;
    private final UserInput USER_INPUT;
    private final PlayerPot THE_PLAYER_POT;
    private final TablePot THE_TABLE_POT;
    private final PrintDeckState PRINT_DECK_STATE;
    private final Hand PLAYER_HAND;
    private final Hand TABLE_HAND;


    private int wager;
    private Deck theDeck;


    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        NUM_DECKS = numOfDecks;
        USER_INPUT = new UserInput();
        THE_PLAYER_POT = playerPot;
        THE_TABLE_POT = new TablePot();
        PRINT_DECK_STATE = new PrintDeckState(THE_PLAYER_POT);
        TABLE_HAND = new Hand();
        PLAYER_HAND = new Hand();

        theDeck = deck;
        theDeck.shuffle();

    }

    public void setWager() {
        boolean wageSet = false;
        while(!wageSet){
            Scanner scanner = new Scanner(System.in);
            System.out.printf("%nWager(You have %d left): ", THE_PLAYER_POT.getAmount());
            wager = scanner.nextInt();
            wageSet = THE_PLAYER_POT.wager(wager);
        }
        THE_TABLE_POT.addToAmount(wager*2);
        System.out.println("Wage set: " + wager);
        System.out.println("In the pot: " + THE_TABLE_POT.getAmount()+"\n");
    }
    public Deck play(){
            if(theDeck.getSize() < 10){
                theDeck = new Deck(NUM_DECKS);
                theDeck.shuffle();
            }
                PLAYER_HAND.addCard(theDeck.draw());
                PLAYER_HAND.addCard(theDeck.draw());


                TABLE_HAND.addCard(theDeck.draw());
                TABLE_HAND.addCard(theDeck.draw());


                PrintObject printObject = new PrintObject(PLAYER_HAND, TABLE_HAND);
                printObject.printPlayerAndSomeTableHand();
                dblDown(USER_INPUT.checkIfDoubleDown());
                Boolean hitMe = USER_INPUT.checkHitMe();
                while(hitMe){
                    PLAYER_HAND.addCard(theDeck.draw());
                    if(PLAYER_HAND.checkIfBust()){
                        return theDeck;
                    }
                    printObject.printPlayerAndSomeTableHand();
                    hitMe = USER_INPUT.checkHitMe();
                }
                Boolean overSeventeen = TABLE_HAND.checkIfOverSeventeen();
                while(!overSeventeen){
                    TABLE_HAND.addCard(theDeck.draw());
                    overSeventeen = TABLE_HAND.checkIfOverSeventeen();
                }
                printObject.printPlayerAndTableHandsAndInfo();
        return theDeck;
    }

    public void determineWinner() {
        boolean tableWon = false;
        boolean playerWon = true;
        if(PLAYER_HAND.checkIfBust()){
           System.out.println("player busted");
           playerWon = false;
           tableWon = true;
       }
       else if (TABLE_HAND.checkIfBust()){
           System.out.println("table busted");
           playerWon = true;
           tableWon = false;
       }
       else if (PLAYER_HAND.checkIfCloser(TABLE_HAND.getHandValue())){
           System.out.println("player is closer to 21!");
           playerWon = true;
           tableWon = false;
       }
       else if (TABLE_HAND.checkIfCloser(PLAYER_HAND.getHandValue())){
           System.out.println("table is closer to 21!");
           playerWon = false;
           tableWon = true;
       }
       else if (TABLE_HAND.checkTie(PLAYER_HAND.getHandValue())){
           System.out.println("Push!");
           tableWon = true;
           playerWon = true;
        }


       if(tableWon && playerWon){
           THE_PLAYER_POT.addToAmount(wager);
       }
       else if (playerWon){
           THE_PLAYER_POT.addToAmount(THE_TABLE_POT.getAmount());
       }
       PRINT_DECK_STATE.printHandEnding(playerWon, tableWon);
    }

    private void dblDown(Boolean checkIfDoubleDown) {
        if (checkIfDoubleDown){
            if(THE_PLAYER_POT.wager(wager)){
                System.out.println("Doubling Down!");
                THE_TABLE_POT.addToAmount(wager*2);
                System.out.println("Wage set: " + wager);
                System.out.println("In the pot: " + THE_TABLE_POT.getAmount()+"\n");
            }
            else{
                System.out.println("Not enough to double down.");
                System.out.println("Money left: " + THE_PLAYER_POT.getAmount());
            }
        }
    }
}
