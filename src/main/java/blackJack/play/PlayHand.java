package blackJack.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayHand {

    int wager;
    PlayerPot thePlayerPot;
    int numberOfDecks;
    Deck theDeck;
    TablePot theTablePot;
    Hand playerHand;
    Hand tableHand;
    UserInput userInput;
    PrintObject printObject;

    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        theDeck = deck;
        numberOfDecks = numOfDecks;
        thePlayerPot = playerPot;
        theTablePot = new TablePot();
        userInput = new UserInput();
        setwager();
    }

    private void setwager() {
        boolean wageSet = false;
        int number = 0;
        while(!wageSet){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Wager: ");
            wager = scanner.nextInt();
            wageSet = thePlayerPot.wager(number);
        }
        theTablePot.addToAmount(wager*2);
        System.out.println("Wage set: " + wager);
        System.out.println("In the pot: " + theTablePot.getAmount());
    }
    public Deck play(){
        boolean gameState = true;
        while(gameState){
            if(theDeck.getSize() < 4){
                theDeck = new Deck(numberOfDecks);
            }
            else{
                playerHand = new Hand();
                playerHand.addCard(theDeck.draw());
                playerHand.addCard(theDeck.draw());

                tableHand = new Hand();
                tableHand.addCard(theDeck.draw());
                tableHand.addCard(theDeck.draw());

                PrintObject printObject = new PrintObject(playerHand, tableHand);
                printObject.printPlayerAndTableHandsAndInfo();

                Boolean hitMe = userInput.checkHitMe();
                while(hitMe){
                    playerHand.addCard(theDeck.draw());
                    printObject.printPlayerAndTableHandsAndInfo();
                    hitMe = userInput.checkHitMe();
                }
                while(!tableHand.checkIfBust() && playerHand.checkIfCloser(tableHand.getHandValue())){
                    playerHand.addCard(theDeck.draw());
                }
                printObject.printPlayerAndTableHandsAndInfo();
            }
        }
        return theDeck;
    }
}
