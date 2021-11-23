package blackJack.play;

public interface Pot {

    public Integer getAmount();

    public void addToAmount(Integer amountToAdd);

    public Integer removeFromAmount(Integer amountToRemove);

}
