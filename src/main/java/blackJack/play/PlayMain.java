package blackJack.play;

public class PlayMain {

    public static void main(String[] args){
        UserInput userInput = new UserInput();
        System.out.println("Starting game!");

        Integer numberOfDecks = userInput.deckNumber();
        Deck theDeck = new Deck(numberOfDecks);
        System.out.printf("Initialized with %d cards.%n%n", theDeck.getSize());

        PlayerPot playerPot = new PlayerPot();
        Boolean playing = true;
        while(playing){
            PlayHand hand = new PlayHand(theDeck, playerPot, numberOfDecks);
            hand.setWager();
            hand.play();
            hand.determineWinner();
            if(playerPot.checkIfOutOfMoney()){
                System.out.println("You're out of Money. GameOver.");
                playing = false;
            }
            else{
            playing = userInput.checkGameState();
            }
        }
        System.out.println("Goodbye!");
    }
}
