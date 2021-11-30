package blackJack.play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hand {
    private final HashMap<Face, Integer> VALUES = Values.createMap();

    private  List<Card> cards = new ArrayList<>();
    private Integer handValue;

    public Hand(){}

    public Hand(List<Card> card){
        this.cards = card;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public List<String> getCards() {
        List<String> strings = new ArrayList<>();
        for(Card card: cards){
            strings.add(String.format("%s", card));
        }
        return strings;
    }
    public Integer getHandValue() {
        setHandValue();
        return handValue;
    }
    public Boolean checkIfOverSeventeen(){
        setHandValue();
        return handValue > 17;
    }
    public Boolean checkIfBust(){
        setHandValue();
        return handValue > 21;
    }
    public Boolean checkIfCloser(Integer opposingNum){
        setHandValue();
        return opposingNum < handValue;
    }
    private void setHandValue(){
        int sum = 0;
        for (Card card: cards){
            sum += VALUES.get(card.getFace());
        }
        if (sum > 21){
            sum = reduceByAces(sum);
        }
        handValue = sum;
    }
    private int reduceByAces(int sum) {
        int summary = sum;
        int aceCount = 0;
        for(Card card : cards){
            if(card.getFace() == Face.ACE){
                aceCount += 1;
            }
        }
        while(aceCount > 0){
            summary -= 10;
            aceCount--;
            if(summary < 21){
                break;
            }
        }
        return summary;
    }


    public boolean checkTie(Integer opposingNum) {
        setHandValue();
        return (opposingNum == handValue);
    }
}
