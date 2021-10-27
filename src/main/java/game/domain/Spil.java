package game.domain;

import java.io.FileNotFoundException;

public class Spil {
    private Spiller s1;
    private Spiller s2;
    private Spiller vinder;
    private Spiller tur_spiller;
    private Bræt spillebræt;

    public Spil(Spiller s1, Spiller s2) throws FileNotFoundException {
        this.s1 = s1;
        this.s2 = s2;
        vinder = null;
        tur_spiller = s1;
        spillebræt = new Bræt();
    }
    private boolean har_vinder(){
        vinder = s1.getKonto().getSaldo() >= 4000 ? s1 : null;
        vinder = s2.getKonto().getSaldo() >= 4000 ? s2 : null;
        return vinder != null;
    }
    public void tag_tur(Spiller s) throws Exception {
        if (s != tur_spiller)
            throw new Exception("spiller ud af tur");
        int øjne = s.rul_terninger();
        int virkning = spillebræt.getVirkning(øjne);
        s.getKonto().påvirkBalance(virkning);
        Felt felt = spillebræt.getFelt(øjne);
        s.setFelt(felt);
        if (har_vinder())
            return;
        if (felt.giverEkstraTur()){
            tag_tur(s);
        }
        else {
            tur_spiller = s == s1 ? s2 : s1;
        }
    }

}
