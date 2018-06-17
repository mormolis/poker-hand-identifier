package services.validation;

import model.Ranks;
import model.Suits;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPairsValidatorTest extends HandValidationTest {

    private TwoPairsValidator twoPairsValidator = new TwoPairsValidator();

    @Test
    public void isTwoPairsReturnsFalseIfThereisTwoOfAKindOnlyOnHand() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.JACK).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.HEART).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());

        assertFalse(twoPairsValidator.isValid(hand));
    }

    @Test
    public void isTwoPairsReturnsTrueIfThereAreTwoPairsOnHand() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());

        assertTrue(twoPairsValidator.isValid(hand));
    }

    @Test
    public void isTwoPairsReturnsFalseIfEmptyHandIsGiven() {

        assertFalse(twoPairsValidator.isValid(hand));
    }


}