import java.util.Objects;

public class Card {
    private Ranks rank;
    private Suits suit;

    public Card(Ranks rank, Suits suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getRank() == card.getRank() &&
                getSuit() == card.getSuit();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRank(), getSuit());
    }
}
