package services.validation;

import model.Card;

import java.util.List;

public class FlussValidator implements HandValidator {

    @Override
    public boolean isValid(List<Card> hand) {
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
}
