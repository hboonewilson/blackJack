package blackJack.play;

import java.util.List;

public class PrintObject {
    private final Hand playerHand;
    private final Hand tableHand;

    public PrintObject(Hand playerHand, Hand tableHand){
        this.playerHand = playerHand;
        this.tableHand = tableHand;
    }

    public void printPlayerAndTableHandsAndInfo(){
        List<String> player = playerHand.getCards();
        List<String> table = tableHand.getCards();
        System.out.printf("Player Hand (%d): %n", playerHand.getHandValue());
        for (String card : player){
            System.out.println(card);
        }
        System.out.printf("Table Hand (%d): %n", tableHand.getHandValue());
        for (String card : table){
            System.out.println(card);
        }

    }

}
