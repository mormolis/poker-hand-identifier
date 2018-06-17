package services.validation;

import model.Card;
import model.Ranks;
import model.Suits;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FlussRoyalValidatorTest {

    private Card.Builder cardBuilder;
    private List<Card> hand;
    private FlussValidator flussValidator = Mockito.mock(FlussValidator.class);
    private StraightValidator straitValidator = Mockito.mock(StraightValidator.class);

    private FlussRoyalValidator flussRoyalValidator = new FlussRoyalValidator(flussValidator, straitValidator);

    @Before
    public void setUp() throws Exception {
        hand = new ArrayList<>();
        cardBuilder = new Card.Builder();
    }

    @Test
    public void isFlussRoyalReturnsTrueIfStraitWithTheSameSuit() {
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.ACE).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.KING).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.QUEEN).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.JACK).build());
        hand.add(cardBuilder.suit(Suits.DIAMONDS).rank(Ranks.TEN).build());

        Mockito.when(flussValidator.isValid(hand)).thenReturn(true);
        Mockito.when(straitValidator.isValid(hand)).thenReturn(true);

        assertThat(flussRoyalValidator.isValid(hand), equalTo(true));
    }

    @Test
    public void isFlussRoyalReturnsFalseIfHandIsEmpty() {

        assertThat(flussRoyalValidator.isValid(hand), equalTo(false));
    }

}