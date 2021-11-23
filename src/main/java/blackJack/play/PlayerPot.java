package blackJack.play;

class PlayerPot implements Pot{
    private Integer amount;

    public PlayerPot(Integer amount){
        this.amount = amount;
    }
    public PlayerPot(){
        this.amount = 25;
    }
    public Integer getAmount(){
        return this.amount;
    }
    public void addToAmount(Integer amountToAdd) {
        this.amount += amountToAdd;
    }
    public Integer removeFromAmount(Integer amountToRemove) {
        this.amount -= amountToRemove;
        return this.amount;
    }

}
