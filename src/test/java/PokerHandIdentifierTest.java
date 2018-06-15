import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PokerHandIdentifierTest {

    @Mock
    private Card cardMock;
    @Mock
    private Card cardMock1;
    @Mock
    private Card cardMock2;
    @Mock
    private Card cardMock3;
    @Mock
    private Card cardMock4;

    List<Card> handGlobal;

    private PokerHandIdentifier pokerHandIdentifier;

    @Before
    public void setUp(){
        pokerHandIdentifier = new PokerHandIdentifier();
        handGlobal = new ArrayList<>();
        handGlobal.add(cardMock);
        handGlobal.add(cardMock1);
        handGlobal.add(cardMock2);
        handGlobal.add(cardMock3);
        handGlobal.add(cardMock4);
    }

    @Test
    public void isFlussReturnsTrueWhenAllTheCardsInHandShareTheSameSuit(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getSuit()).thenReturn(Suits.DIAMONDS);
        assertThat(pokerHandIdentifier.isFluss(hand), equalTo(true));
        verify(cardMock, times(10)).getSuit();
        verifyNoMoreInteractions(cardMock);
    }

    @Test
    public void isFlussReturnsFalseIfAnEmptyHandIsPassed(){
        List<Card> emptyHand = new ArrayList<>();
        assertThat(pokerHandIdentifier.isFluss(emptyHand), equalTo(false));
    }

    @Test
    public void isFlussReturnsFalseIfAnAtLeastOneCardHasDifferentSuit(){
        List<Card> hand = new ArrayList<>();
        when(cardMock.getSuit()).thenReturn(Suits.DIAMONDS).thenReturn(Suits.CLUBS);

        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }

        assertThat(pokerHandIdentifier.isFluss(hand), equalTo(false));
        verify(cardMock, times(2)).getSuit();
        verifyNoMoreInteractions(cardMock);
    }

    @Test
    public void isStraitReturnsTrueIfHandIsStrait(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getRank()).thenReturn(Ranks.ACE)
                .thenReturn(Ranks.TWO)
                .thenReturn(Ranks.THREE)
                .thenReturn(Ranks.FOUR)
                .thenReturn(Ranks.FIVE);

        assertThat(pokerHandIdentifier.isStrait(hand), equalTo(true));
    }

    @Test
    public void isStraitReturnsFalseIfHandIsNotStrait(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getRank()).thenReturn(Ranks.ACE)
                .thenReturn(Ranks.TWO)
                .thenReturn(Ranks.TWO)
                .thenReturn(Ranks.FOUR)
                .thenReturn(Ranks.FIVE);

        assertThat(pokerHandIdentifier.isStrait(hand), equalTo(false));
    }

    @Test
    public void isStraitReturnsFalsefHandIsEmpty(){
        List<Card> emptyHand = new ArrayList<>();
        assertThat(pokerHandIdentifier.isStrait(emptyHand), equalTo(false));
    }

    @Test
    public void isStraitReturnsTrueIfHandIsStraitWithAce(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getRank()).thenReturn(Ranks.ACE)
                .thenReturn(Ranks.KING)
                .thenReturn(Ranks.QUEEN)
                .thenReturn(Ranks.JACK)
                .thenReturn(Ranks.TEN);

        assertThat(pokerHandIdentifier.isStrait(hand), equalTo(true));
    }


    @Test
    public void isFlossRoyalReturnsTrueIfStraitWithTheSameColour(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getRank()).thenReturn(Ranks.ACE)
                .thenReturn(Ranks.KING)
                .thenReturn(Ranks.QUEEN)
                .thenReturn(Ranks.JACK)
                .thenReturn(Ranks.TEN);

        when(cardMock.getSuit()).thenReturn(Suits.DIAMONDS);

        assertThat(pokerHandIdentifier.isFlussRoyal(hand), equalTo(true));
    }

    @Test
    public void isFlossRoyalReturnsFalseIfHandIsEmpty(){
        List<Card> emptyHand = new ArrayList<>();
        assertThat(pokerHandIdentifier.isFlussRoyal(emptyHand), equalTo(false));
    }

    @Test
    public void isFourOfAKindReturnsTrueIf4CardsOfTheSameRankAreInHand(){
        List<Card> hand = new ArrayList<>();
        for(int i=0; i<5; i++){
            hand.add(cardMock);
        }
        when(cardMock.getRank()).thenReturn(Ranks.ACE)
                        .thenReturn(Ranks.KING);

        assertThat(pokerHandIdentifier.isFourOfAKind(hand),equalTo(true));
    }

    @Test
    public void isThreeOfAKindReturnsTrueIf3CardsOfTheSameKindAreInTheHand(){
            when(cardMock.getRank()).thenReturn(Ranks.KING);
            when(cardMock1.getRank()).thenReturn(Ranks.QUEEN);
            when(cardMock2.getRank()).thenReturn(Ranks.QUEEN);
            when(cardMock3.getRank()).thenReturn(Ranks.QUEEN);
            when(cardMock4.getRank()).thenReturn(Ranks.ACE);

            assertThat(pokerHandIdentifier.isThreeOfAKind(handGlobal), equalTo(true));
    }

    @Test
    public void isThreeOfAKindReturnsFalseIf3CardsOfTheSameKindAreInTheHand(){
        when(cardMock.getRank()).thenReturn(Ranks.KING);
        when(cardMock1.getRank()).thenReturn(Ranks.QUEEN);
        when(cardMock2.getRank()).thenReturn(Ranks.QUEEN);
        when(cardMock3.getRank()).thenReturn(Ranks.QUEEN);
        when(cardMock4.getRank()).thenReturn(Ranks.KING);

        assertThat(pokerHandIdentifier.isThreeOfAKind(handGlobal), equalTo(false));
    }

    @Test
    public void isThreeOfAKindReturnsFalseIfHandIsEmpty(){
        List<Card> emptyHand = new ArrayList<>();
        assertThat(pokerHandIdentifier.isThreeOfAKind(emptyHand), equalTo(false));

    }

    @Test
    public void isTwoOfAKindReturnsTrueIfThereAreTwoSimilarCardsOnHand(){
        when(cardMock.getRank()).thenReturn(Ranks.KING);
        when(cardMock1.getRank()).thenReturn(Ranks.KING);
        when(cardMock2.getRank()).thenReturn(Ranks.ACE);
        when(cardMock3.getRank()).thenReturn(Ranks.TEN);
        when(cardMock4.getRank()).thenReturn(Ranks.TWO);
        assertTrue(pokerHandIdentifier.isTwoOfAKind(handGlobal));

    }

    @Test
    public void isTwoOfAKindReturnsFalseIfThereAreTwoSimilarCardsOnHandTwice(){
        when(cardMock.getRank()).thenReturn(Ranks.KING);
        when(cardMock1.getRank()).thenReturn(Ranks.KING);
        when(cardMock2.getRank()).thenReturn(Ranks.TEN);
        when(cardMock3.getRank()).thenReturn(Ranks.TEN);
        when(cardMock4.getRank()).thenReturn(Ranks.TWO);
        assertFalse(pokerHandIdentifier.isTwoOfAKind(handGlobal));

    }

    @Test
    public void isTwoPairsReturnsTrueIfThereAreTwoPairsOnHand(){
        when(cardMock.getRank()).thenReturn(Ranks.KING);
        when(cardMock1.getRank()).thenReturn(Ranks.KING);
        when(cardMock2.getRank()).thenReturn(Ranks.TEN);
        when(cardMock3.getRank()).thenReturn(Ranks.TEN);
        when(cardMock4.getRank()).thenReturn(Ranks.TWO);
        assertTrue(pokerHandIdentifier.isTwoPair(handGlobal));
    }

    @Test
    public void isTwoPairsReturnsFalseIfThereisTwoOfAKindOnlyOnHand(){
        when(cardMock.getRank()).thenReturn(Ranks.KING);
        when(cardMock1.getRank()).thenReturn(Ranks.JACK);
        when(cardMock2.getRank()).thenReturn(Ranks.TEN);
        when(cardMock3.getRank()).thenReturn(Ranks.TEN);
        when(cardMock4.getRank()).thenReturn(Ranks.TWO);
        assertFalse(pokerHandIdentifier.isTwoPair(handGlobal));
    }

    @Test
    public void isTwoPairsReturnsFalseIfEmptyHandIsGiven(){
        List<Card> emptyHand = new ArrayList<>();
        assertFalse(pokerHandIdentifier.isTwoPair(emptyHand));

    }
}
