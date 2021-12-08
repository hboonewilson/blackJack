package blackJack.play.potClasses;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TablePotTest {
    TablePot tablePot;
    @Test
    void givenWipe_shouldRemoveFromPot(){
        tablePot = new TablePot(20);
        Assertions.assertEquals(20, tablePot.getAmount());
        tablePot.wipe();
        Assertions.assertEquals(0, tablePot.getAmount());
    }
    @Test
    void givenAddToAmount_shouldAddThatCorrectAmount(){
        tablePot = new TablePot();
        tablePot.addToAmount(20);
        Assertions.assertEquals(20, tablePot.getAmount());
    }
}