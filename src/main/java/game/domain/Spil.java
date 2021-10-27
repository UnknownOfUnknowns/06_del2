package game.domain;

import java.io.FileNotFoundException;

public class Spil {
    private Spiller s1;
    private Spiller s2;
    private Spiller vinder;
    private Spiller tur_spiller;
    private Bræt spillebræt;

    public Spil() throws FileNotFoundException {
        spillebræt = new Bræt();
        s1 = new Spiller(spillebræt.getFelt(7));
        s2 = new Spiller(spillebræt.getFelt(7));
        vinder = null;
        tur_spiller = s1;
    }
    public boolean har_vinder(){
        vinder = s1.getKonto().getSaldo() >= 3000 ? s1 : null;
        vinder = s2.getKonto().getSaldo() >= 3000 ? s2 : null;
        return vinder != null;
    }
    public void tag_tur() {
        int øjne = tur_spiller.rul_terninger();
        int virkning = spillebræt.getVirkning(øjne);
        tur_spiller.getKonto().påvirkBalance(virkning);
        Felt felt = spillebræt.getFelt(øjne);
        tur_spiller.setFelt(felt);
        if (har_vinder() || felt.giverEkstraTur())
            return;
        tur_spiller = tur_spiller == s1 ? s2 : s1;

    }

    public Spiller getS1() {
        return s1;
    }

    public Spiller getS2() {
        return s2;
    }

    public Spiller getTur_spiller() {
        return tur_spiller;
    }
}
