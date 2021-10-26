package game.domain;

import game.Util.DomainFeltFactory;

import java.io.FileNotFoundException;

public class Bræt {
    Felt[] felter;
    public Bræt () throws FileNotFoundException {
        DomainFeltFactory factory = new DomainFeltFactory();
        felter = factory.loadFelter();
    }
    public Felt getFelt (int Øjne){
        return felter[Øjne-2];
    }
    public int getVirkning (int Øjne){
        return getFelt(Øjne).getLikviditetsvikrning();
    }

}
