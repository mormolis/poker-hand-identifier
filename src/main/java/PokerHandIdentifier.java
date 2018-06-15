import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHandIdentifier {

    public boolean isFluss(List<Card> hand){
        if (hand.isEmpty()){
            return false;
        }
        for(Card card : hand){
           if(!card.getSuit().equals(hand.get(0).getSuit())){
               return false;
           }
        }
        return true;
    }

    public boolean isStrait(List<Card> hand) {
        if (hand.isEmpty()) return false;
        List<Integer> ranks = new ArrayList<>();
        hand.stream().forEach(card -> {ranks.add(card.getRank().getValue());});
        Collections.sort(ranks);

        if (ranks.get(0) == 1 && ranks.get(1) == 10) {
                ranks.remove(0);
        }

        for (int i=0; i<ranks.size() - 1; i++){
            if(ranks.get(i) != ranks.get(i+1)-1){
                return false;
            }
        }
        return true;
    }

    public boolean isThreeOfAKind(List<Card> hand) {
        return isXofAKind(hand, 3) && !isXofAKind(hand, 2);
    }

    public boolean isFlussRoyal(List<Card> hand) {
        return isStrait(hand) && isFluss(hand);
    }

    public boolean isFourOfAKind(List<Card> hand){
        return isXofAKind(hand, 4);
    }

    public boolean isTwoOfAKind(List<Card> hand) {
        int counter;
        boolean coupleFound = false;
        List<Card> toBeRemoved = new ArrayList<>();
        for(Card card : hand){
            counter = 0;
            for(Card card1 : hand){
                if(card1.getRank().equals(card.getRank())){
                    counter++;
                    if (counter == 2){
                        toBeRemoved.add(card1);
                    }
                }
            }
            if(counter == 2){
                coupleFound = true;
                break;
            }
        }
        if(coupleFound){
            hand.removeAll(toBeRemoved);
            return coupleFound && !isXofAKind(hand,2);
        }
        return false;
    }

    public boolean isTwoPair(List<Card> hand) {
        int counter;
        boolean coupleFound = false;
        List<Card> toBeRemoved = new ArrayList<>();
        for(Card card : hand){
            counter = 0;
            for(Card card1 : hand){
                if(card1.getRank().equals(card.getRank())){
                    counter++;
                    if (counter == 2){
                        toBeRemoved.add(card1);
                    }
                }
            }
            if(counter == 2){
                coupleFound = true;
                break;
            }
        }
        if(coupleFound){
            hand.removeAll(toBeRemoved);
            return coupleFound && isXofAKind(hand,2);
        }
        return false;
    }

    private boolean isXofAKind(List<Card> hand, int numberOfSimilarCards) {
        int counter;
        for(Card card : hand){
            counter = 0;
            for(Card card1 : hand){
                if(card1.getRank().equals(card.getRank())){
                    counter++;
                }
            }
            if(counter == numberOfSimilarCards){
                return true;
            }
        }
        return false;
    }
}
