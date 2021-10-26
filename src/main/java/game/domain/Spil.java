package game.domain;

public class Spil {
    private Spiller s1;
    private Spiller s2;
    private Spiller vinder;
    private Spiller tur_spiller;

    public Spil(Spiller s1, Spiller s2){
        this.s1 = s1;
        this.s2 = s2;
        vinder = null;
        tur_spiller = s1;
    }
    private boolean har_vinder(){
        return vinder != null;
    }

}
