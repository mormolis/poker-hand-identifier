package services.validation;

import model.Ranks;
import model.Suits;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoOfAKindValidatorTest extends HandValidationTest {

    private TwoOfAKindValidator twoOfAKindValidator = new TwoOfAKindValidator();

    @Test
    public void shouldValidateIfThereAreTwoOfAKind() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());

        assertTrue(twoOfAKindValidator.isValid(hand));

    }

    @Test
    public void shouldNotValidateIfThereAreMultiplePairs() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());

        assertFalse(twoOfAKindValidator.isValid(hand));

    }

}