package services.validation;

import model.Ranks;
import model.Suits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class StraightValidatorTest extends HandValidationTest {

    private StraightValidator straightValidator = new StraightValidator();

    @Test
    public void isStraitReturnsTrueIfHandIsStrait() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.THREE).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.FOUR).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.FIVE).build());

        assertThat(straightValidator.isValid(hand), equalTo(true));
    }

    @Test
    public void isStraitReturnsFalseIfHandIsNotStrait() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.ACE).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TWO).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.FOUR).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.FIVE).build());


        assertThat(straightValidator.isValid(hand), equalTo(false));
    }

    @Test
    public void isStraitReturnsFalsefHandIsEmpty() {

        assertThat(straightValidator.isValid(hand), equalTo(false));
    }

    @Test
    public void isStraitReturnsTrueIfHandIsStraitWithAce() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.ACE).build());
        hand.add(cardBuilder.suit(Suits.CLUBS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.HEART).rank(Ranks.QUEEN).build());
        hand.add(cardBuilder.suit(Suits.SPADES).rank(Ranks.JACK).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());

        assertThat(straightValidator.isValid(hand), equalTo(true));
    }

}