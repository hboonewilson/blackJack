package blackJack.play.inputAndPrint;

import blackJack.play.playLogic.Hand;
import blackJack.play.potClasses.PlayerPot;
import blackJack.play.potClasses.TablePot;

import java.util.List;

public class PrintObject {

    public PrintObject(){}
    public void printPlayerAndSomeTableHand(Hand playerHand, Hand tableHand){

        List<String> playerList = playerHand.getCards();
        List<String> tableList = tableHand.getCards();

        System.out.printf("Player Hand (%d): %n", playerHand.getHandValue());
        for (String card : playerList){
            System.out.println(card);
        }
        System.out.println("\nTable Hand:");
        System.out.println(tableList.get(0));
        System.out.println("Second card unknown");
    }

    public void printPlayerAndTableHandsAndInfo(Hand playerHand, Hand tableHand){
        List<String> playerList = playerHand.getCards();
        List<String> tableList = tableHand.getCards();
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
    public void printWagerAndTablePot(Integer wager, TablePot tablePot){
        System.out.println("Wage set: " + wager);
        System.out.println("In the pot: " + tablePot.getAmount()+"\n");
    }

    public void printDblDown(Integer wager, TablePot tablePot) {
        System.out.printf("Doubling down! Wager: %d%n", wager);
        System.out.printf("The pot is doubled: %d%n", tablePot.getAmount());
    }
    public void printHandEnding(boolean playerWon, boolean tableWon, PlayerPot playerPot) {
        if (playerWon && tableWon){
            System.out.printf("%n%nPush.%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
        else if (!playerWon && tableWon){
            System.out.printf("%n%nTable Wins.%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
        else if (playerWon){
            System.out.printf("%n%nPlayer Wins!%nPlayer Pot:%d%n%n", playerPot.getAmount());
        }
    }

}
