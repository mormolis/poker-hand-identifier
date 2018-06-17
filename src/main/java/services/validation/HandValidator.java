package services.validation;

import model.Card;

import java.util.List;

public interface HandValidator {

    public boolean isValid(List<Card> hand);
}
