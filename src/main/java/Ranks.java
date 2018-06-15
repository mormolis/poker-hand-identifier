public enum Ranks {
    ACE("Ace", 1), TWO("Two",2), THREE("Three", 3), FOUR("Four", 4), FIVE("Five",5), SIX("Six",6),
    SEVEN("Seven", 7), EIGHT("Eight", 8), NINE("Nine", 9 ), TEN("Ten", 10), JACK("Jack", 11),
    QUEEN("Queen", 12), KING("King", 13);

    private String description;
    private int value;
    Ranks(String description, int value){
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
}
