package services.validation;

import model.Ranks;
import model.Suits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FlussValidatorTest extends HandValidationTest {
    
    private FlussValidator flussValidator = new FlussValidator();

    @Test
    public void isFlussReturnsTrueWhenAllTheCardsInHandShareTheSameSuit() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.QUEEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.ACE).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.FOUR).build());

        assertThat(flussValidator.isValid(hand), equalTo(true));
    }

    @Test
    public void isFlussReturnsFalseIfAnEmptyHandIsPassed() {

        assertThat(flussValidator.isValid(hand), equalTo(false));
    }

    @Test
    public void isFlussReturnsFalseIfAnAtLeastOneCardHasDifferentSuit() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.QUEEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.ACE).build());
        hand.add(cardBuilder.suit(Suits.HEART).rank(Ranks.FOUR).build());

        assertThat(flussValidator.isValid(hand), equalTo(false));
    }

}