package game.domain;

import game.Util.SpilData;

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
        if(s1.getKonto().getSaldo() >= SpilData.getInstance().getVINDERBALANCE()){
            vinder = s1;
        }else if(s2.getKonto().getSaldo() >= SpilData.getInstance().getVINDERBALANCE()){
            vinder = s2;
        }else{
            vinder = null;
        }
        return vinder != null;
    }
    public void tag_tur() {
        int øjne = tur_spiller.rul_terninger();
        int virkning = spillebræt.getVirkning(øjne);
        tur_spiller.getKonto().påvirkBalance(virkning);
        Felt felt = spillebræt.getFelt(øjne);
        tur_spiller.setFelt(felt);
        if (felt.giverEkstraTur())
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

    public Spiller getVinder() {
        return vinder;
    }
}

