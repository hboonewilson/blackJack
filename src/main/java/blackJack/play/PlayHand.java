package blackJack.play;

import java.util.Scanner;

public class PlayHand {

    int wager;
    PlayerPot thePlayerPot;
    int numberOfDecks;
    Deck theDeck;
    TablePot theTablePot;

    public PlayHand(Deck deck, PlayerPot playerPot, int numOfDecks){
        theDeck = deck;
        numberOfDecks = numOfDecks;
        thePlayerPot = playerPot;
        theTablePot = new TablePot();
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


            }
        }
        return theDeck;
    }
}
