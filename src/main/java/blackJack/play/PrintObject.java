package blackJack.play;

import java.util.List;

public class PrintObject {
    private final Hand playerHand;
    private final Hand tableHand;

    private  List<String> playerList;
    private  List<String> tableList;

    public PrintObject(Hand playerHand, Hand tableHand){
        this.playerHand = playerHand;
        this.tableHand = tableHand;

        this.playerList = playerHand.getCards();
        this.tableList = tableHand.getCards();
    }
    public void printPlayerAndSomeTableHand(){
        //This is the first  to be used when hiding the tables' second card
        setLists();
        System.out.printf("Player Hand (%d): %n", playerHand.getHandValue());
        for (String card : playerList){
            System.out.println(card);
        }
        System.out.println("\nTable Hand:");
        System.out.println(tableList.get(0));
        System.out.println("Second card unknown");
    }

    public void printPlayerAndTableHandsAndInfo(){
        setLists();
        System.out.printf("Player Hand (%d): %n", playerHand.getHandValue());
        for (String card : playerList){
            System.out.println(card);
        }
        System.out.println();
        System.out.printf("%nTable Hand (%d): %n", tableHand.getHandValue());
        for (String card : tableList){
            System.out.println(card);
        }
        System.out.println();
    }
    private void setLists(){
        playerList = playerHand.getCards();
        tableList = tableHand.getCards();
    }

}
