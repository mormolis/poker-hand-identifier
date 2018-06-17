package model;

public class Card {

    private Ranks rank;
    private Suits suit;

    private Card() { }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Card(Builder builder) {
        this.rank = builder.rank;
        this.suit = builder.suit;
    }

    public static class Builder {

        private Ranks rank;
        private Suits suit;

        public Builder rank(Ranks rank) {
            this.rank = rank;
            return this;
        }

        public Builder suit(Suits suit) {
            this.suit = suit;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}
