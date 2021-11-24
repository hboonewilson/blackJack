package blackJack.play;

import java.util.Scanner;

public class PlayMain {

    public static void main(String[] args){
        int numberOfDecks;
        System.out.println("Starting game!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many decks?");
        numberOfDecks = scanner.nextInt();
        Deck theDeck = new Deck(numberOfDecks);
        System.out.printf("Initialized with %d cards.%n", theDeck.getSize());

        PlayerPot playerPot = new PlayerPot();

        String gameState = "p";
        while(gameState.toLowerCase().equals("p")){
            PlayHand hand = new PlayHand(theDeck, playerPot, numberOfDecks);
            gameState = "s";
        }
    }
}
