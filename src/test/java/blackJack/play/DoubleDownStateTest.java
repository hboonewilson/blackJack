package blackJack.play;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoubleDownStateTest {
    PlayerPot playerPot;
    DoubleDownState doubleDownState;
    TablePot tablePot;
    Hand playerHand;
    Deck theDeck;

    @Mock
    PlayerPot playerPotMock;
    @BeforeEach
    void setUp(){

         playerPot = new PlayerPot(200);
         tablePot = new TablePot(20);
         playerHand = new Hand();
         theDeck = new Deck(3);

         doubleDownState = new DoubleDownState(playerPotMock, tablePot, playerHand, theDeck);
    }
    @Test
    void givenDoublingDown_whenNotEnoughMoney_shouldReturnFalse(){
        when(playerPotMock.wager(anyInt())).thenReturn(false);

        Assertions.assertFalse(doubleDownState.doublingDown(20));
    }
    @Test
    void givenDoublingDown_whenEnoughMoney_shouldReturnTrue(){
        when(playerPotMock.wager(anyInt())).thenReturn(true);

        Assertions.assertTrue(doubleDownState.doublingDown(20));
    }
    @Test
    void givenDoublingDown_whenEnoughMoney_shouldSetTablePotCorrectly(){
        int wager = 10;

        when(playerPotMock.wager(anyInt())).thenReturn(true);
        doubleDownState.doublingDown(wager);
        Assertions.assertEquals(40, tablePot.getAmount());
    }
}