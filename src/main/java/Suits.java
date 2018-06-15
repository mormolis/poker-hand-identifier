public enum Suits {
    HEART("Hearts"), DIAMONDS("Diamonds"), SPADES("Spades"), CLUBS("Clubs");

    private String description;

    Suits(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
