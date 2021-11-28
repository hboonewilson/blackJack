package blackJack.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private List<String> positive = new ArrayList<String>();
    private List<String> negative = new ArrayList<String>();
    private Scanner scanner = new Scanner(System.in);
    UserInput(){

        positive.add("y");
        positive.add("yes");

        negative.add("n");
        negative.add("no");
    }
    public Boolean checkHitMe() {
        Boolean resolved = false;
        while(!resolved){
            System.out.println("Would you like to hit?");
            String input = scanner.nextLine();
            if (positive.contains(input.toLowerCase())){
                return true;
            }
            else if (negative.contains(input.toLowerCase())){
                return false;
            }
            else{
                System.out.println("Sorry I didn't understand that input.");
            }
        }
        return false;
    }
    public static void main(String[] args){
        UserInput userInput = new UserInput();
        System.out.println(userInput.checkHitMe());
    }
}
