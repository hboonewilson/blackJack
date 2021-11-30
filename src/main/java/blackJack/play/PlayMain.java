package blackJack.play;

import java.util.Scanner;

public class PlayMain {

    public static void main(String[] args){
        UserInput userInput = new UserInput();
        System.out.println("Starting game!");

        Integer numberOfDecks = userInput.deckNumber();
        Deck theDeck = new Deck(numberOfDecks);
        System.out.printf("Initialized with %d cards.%n", theDeck.getSize());

        PlayerPot playerPot = new PlayerPot();
        Boolean playing = userInput.checkGameState();
        while(playing){
            PlayHand hand = new PlayHand(theDeck, playerPot, numberOfDecks);
            hand.setWager();
            hand.play();
            hand.determineWinner();
            System.out.printf("Player");
            playing = userInput.checkGameState();
        }
        System.out.println("Goodbye!");
    }
}
