package services;

import model.Card;
import model.Hands;
import services.validation.HandValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static model.Hands.*;

public class PokerHandIdentifier {

    private Map<Hands, HandValidator> handValidators;

    public PokerHandIdentifier(Map<Hands, HandValidator> handValidators) {
        this.handValidators = handValidators;
    }

    public Hands identify(List<Card> hand) {
        return handValidators.entrySet().stream()
                .filter(entry -> entry.getValue().isValid(hand))
                .map(Map.Entry::getKey).findFirst().orElse(NOTHING);
    }

    /*
    I think if this is a hands identifier, it should return the name of the hand that it identified by asking the
    validators.

    //TODO add tests for this class
    */

}
