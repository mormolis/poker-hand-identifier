package services.validation;

import model.Card;

import java.util.List;
import java.util.stream.Collectors;

public class StraightValidator implements HandValidator {


    @Override
    public boolean isValid(List<Card> hand) {

        if (hand.isEmpty()) return false;

        return hand.stream().map(h -> h.getRank().getValue())
                .collect(Collectors.toSet()).size() == hand.size();
    }

    /*
    The above approach maps the hand to get just the rank numbers and collects it into a Set.
    Since Sets are sorted and don't allow duplication in java, a comparison against the initial size of the hand
    will tell if the hand is actually a Straight.
    */

}
