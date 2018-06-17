package services.validation;

import model.Card;

import java.util.List;

public class FlussRoyalValidator implements HandValidator {

    private FlussValidator flussValidator;
    private StraightValidator straightValidator;

    public FlussRoyalValidator(FlussValidator flussValidator, StraightValidator straightValidator) {
        this.flussValidator = flussValidator;
        this.straightValidator = straightValidator;
    }

    @Override
    public boolean isValid(List<Card> hand) {
        return straightValidator.isValid(hand) && flussValidator.isValid(hand);
    }
}
