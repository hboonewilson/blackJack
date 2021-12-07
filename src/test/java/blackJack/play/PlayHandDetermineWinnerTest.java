package blackJack.play;



import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayHandDetermineWinnerTest {
    Deck theDeck;
    PlayerPot playerPot;
    PlayHand playHand;
    int numDecks;
    static Hand bustHand;
    static Hand twentyOneHand;
    static Hand tenHand;

    @Mock
    UserInputCheck mockUserInput;


    @BeforeAll
    static void config(){
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card(Face.KING, Suit.CLUB));
        playerCards.add(new Card(Face.KING, Suit.CLUB));
        playerCards.add(new Card(Face.KING, Suit.CLUB));
        bustHand = new Hand(playerCards);

        playerCards = new ArrayList<>();
        playerCards.add(new Card(Face.KING, Suit.CLUB));
        playerCards.add(new Card(Face.ACE, Suit.CLUB));
        twentyOneHand = new Hand(playerCards);

        playerCards = new ArrayList<>();
        playerCards.add(new Card(Face.EIGHT, Suit.CLUB));
        playerCards.add(new Card(Face.TWO, Suit.CLUB));
        tenHand = new Hand(playerCards);

    }
    @BeforeEach
    void setUp(){
        numDecks = 1;
        theDeck = new Deck();
        playerPot  = new PlayerPot(200);
        playHand = new PlayHand(theDeck, playerPot, numDecks);

    }
    @Test
    void givenSetWager_shouldSetTheTablePotCorrectly(){
        playHand.setUserInput(mockUserInput);
        when(mockUserInput.setWage(any())).thenReturn(20);
        playHand.setWager();
        Assertions.assertEquals(40, playHand.getTHE_TABLE_POT().getAmount());
    }

    @Test
    void givenDetermineWinner_whenPlayerBust_shouldNotAddToPlayerPot(){


        playHand.setPlayerHand(bustHand);


        playHand.setTheTablePot(new TablePot(20));

        playHand.determineWinner();

        Assertions.assertEquals(200, playerPot.getAmount());
    }
    @Test
    void givenDetermineWinner_whenTableBust_shouldAddToPlayerPot(){

        playHand.setTableHand(bustHand);


        playHand.setTheTablePot(new TablePot(20));

        playHand.determineWinner();

        Assertions.assertEquals(220, playerPot.getAmount());
    }
    @Test
    void givenDetermineWinner_whenTableCloser_shouldNotAddToPlayerPot(){

        playHand.setTableHand(twentyOneHand);
        playHand.setPlayerHand(tenHand);


        playHand.setTheTablePot(new TablePot(20));

        playHand.determineWinner();

        Assertions.assertEquals(200, playerPot.getAmount());
    }
    @Test
    void givenDetermineWinner_whenPlayerCloser_shouldAddToPlayerPot(){
        playHand.setPlayerHand(twentyOneHand);
        playHand.setTableHand(tenHand);


        playHand.setTheTablePot(new TablePot(20));

        playHand.determineWinner();

        Assertions.assertEquals(220, playerPot.getAmount());
    }
}