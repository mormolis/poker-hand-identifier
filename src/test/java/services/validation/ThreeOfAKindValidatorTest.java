package services.validation;

import model.Ranks;
import model.Suits;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ThreeOfAKindValidatorTest extends HandValidationTest {

    private ThreeOfAKindValidator threeOfAKindValidator = new ThreeOfAKindValidator();

    @Test
    public void isThreeOfAKindReturnsTrueIf3CardsOfTheSameKindAreInTheHand() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());

        assertThat(threeOfAKindValidator.isValid(hand), equalTo(true));
    }

    @Test
    public void isThreeOfAKindReturnsFalseIf3CardsOfTheSameKindAreInTheHand() {

        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.QUEEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.QUEEN).build());

        assertThat(threeOfAKindValidator.isValid(hand), equalTo(false));
    }

    @Test
    public void isThreeOfAKindReturnsFalseIfHandIsEmpty() {

        assertThat(threeOfAKindValidator.isValid(hand), equalTo(false));

    }


}