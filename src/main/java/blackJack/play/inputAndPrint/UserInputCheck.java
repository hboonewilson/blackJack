package blackJack.play.inputAndPrint;

import blackJack.play.potClasses.PlayerPot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputCheck {
    private final List<String> POSITIVE = new ArrayList<String>();
    private final List<String> NEGATIVE = new ArrayList<String>();
    private final List<String> DOUBLE_DOWN = new ArrayList<>();
    private final Scanner SCANNER = new Scanner(System.in);


    public UserInputCheck(){

        POSITIVE.add("y");
        POSITIVE.add("yes");

        NEGATIVE.add("n");
        NEGATIVE.add("no");

        DOUBLE_DOWN.add("d");
        DOUBLE_DOWN.add("double");


    }
    public Boolean checkHitMe() {
        boolean resolved = false;
        while(!resolved){
            System.out.println("Would you like to hit?");
            String input = SCANNER.nextLine();
            if (POSITIVE.contains(input.toLowerCase())){
                return true;
            }
            else if (NEGATIVE.contains(input.toLowerCase())){
                return false;
            }
            else{
                System.out.println("Sorry I didn't understand that input.");
            }
        }
        return false;
    }
    public Boolean checkGameState(){
        boolean gameGoing = false;
        while(!gameGoing){
            System.out.println("Would you like to play another Hand?");
            String input = SCANNER.nextLine();
            if (POSITIVE.contains(input.toLowerCase())){
                return true;
            }
            else if (NEGATIVE.contains(input.toLowerCase())){
                return false;
            }
            else{
                System.out.println("Sorry I didn't understand that input.");
            }
        }
        return false;
    }
    public Integer deckNumber(){
        boolean decided = false;
        Integer integerInput = null;
        while(!decided){
            System.out.println("How many Decks?");
            String input = SCANNER.nextLine();
            try{
                integerInput = Integer.parseInt(input);
                decided = true;
            }
            catch (NumberFormatException nfe){
                decided = false;
            }
        }
        return integerInput;
    }
    public Boolean checkIfDoubleDown(){
        boolean decided = false;
        boolean dblDown = false;
        while (!decided){
            System.out.println("Double Down? (d/n)");
            String input = SCANNER.nextLine();
            if (DOUBLE_DOWN.contains(input.toLowerCase())){
                decided = true;
                dblDown = true;
            }
            else if (NEGATIVE.contains(input.toLowerCase())){
                decided = true;
                dblDown = false;
            }
            else{
                System.out.println("Sorry I didn't understand that input.");
            }
        }
        return dblDown;
    }
    public Integer setWage(PlayerPot playerPot){
        boolean wageSet = false;
        int wager = 0;
        while(!wageSet){
            Scanner scanner = new Scanner(System.in);
            System.out.printf("%nWager(You have %d left): ", playerPot.getAmount());
            wager = scanner.nextInt();
            wageSet = playerPot.wager(wager);
            if (!wageSet){
                System.out.printf("%nYou don't have enough money (You have %d left): ", playerPot.getAmount());
            }
        }
        return wager;
    }
}
