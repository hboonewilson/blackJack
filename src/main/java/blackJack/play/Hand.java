package blackJack.play;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hand {

    private Integer handValue;
    private HashMap<Face, Integer> values = Values.createMap();
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public void setHandValue(){
        int sum = 0;
        for (Card card: cards){
            sum += values.get(card.getFace());
        }
        if (sum > 21){
            sum = reduceByAces(sum);
        }
        handValue = sum;

    }

    public int reduceByAces(int sum) {
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

    public Integer getHandValue() {
        return handValue;
    }

    public List<String> getCards() {
        List<String> strings = new ArrayList<>();
        for(Card card: cards){
            strings.add(String.format("%s", card));
        }
        return strings;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
