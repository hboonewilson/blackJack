package blackJack.play;

public class TablePot implements Pot{

    private Integer amount = 0;

    public TablePot(){}

    public void wipe(){
        amount = 0;
    }
    public Integer getAmount() {
        return amount;
    }

    public void addToAmount(Integer amountToAdd) {
        amount += amountToAdd;
    }

    public Integer removeFromAmount(Integer amountToRemove) {
        amount -= amountToRemove;
        return amount;
    }
}
