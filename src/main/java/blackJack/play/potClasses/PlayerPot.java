package blackJack.play.potClasses;

import blackJack.play.potClasses.Pot;

public class PlayerPot implements Pot {
    private Integer amount;

    public PlayerPot(Integer amount){
        this.amount = amount;
    }

    public PlayerPot(){
        this.amount = 200;
    }

    public Integer getAmount(){
        return this.amount;
    }

    public void addToAmount(Integer amountToAdd) {

        this.amount += amountToAdd;
    }

    public Boolean wager(Integer amountToRemove) {
        if (amountToRemove > amount){
            return false;
        }
        else{
            this.amount -= amountToRemove;
            return true;
        }

    }

    public boolean checkIfOutOfMoney() {
        return this.amount <= 0;
    }
}
