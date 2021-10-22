package game.domain;

public class Felt {
    private int likviditetsvikrning;
    private String navn;

    public Felt(int likviditetsvirkning, String navn){
        this.likviditetsvikrning = likviditetsvirkning;
        this.navn = navn;
    }

    public int getLikviditetsvikrning() {
        return likviditetsvikrning;
    }
}
