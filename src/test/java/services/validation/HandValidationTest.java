package services.validation;

import model.Card;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class HandValidationTest {

    protected Card.Builder cardBuilder;
    protected List<Card> hand;

    @Before
    public void setUp() {
        cardBuilder = new Card.Builder();
        hand = new ArrayList<>();
    }

}
