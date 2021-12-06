package blackJack.play;

import java.util.Scanner;

public class UserInputWager {
    PlayerPot playerPot;

    UserInputWager(PlayerPot playerPot){
        this.playerPot = playerPot;
    }
    public Integer setWage(){
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
