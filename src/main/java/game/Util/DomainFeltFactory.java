package game.Util;

import game.domain.Felt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class DomainFeltFactory extends FeltFactory {

    public DomainFeltFactory() throws FileNotFoundException {
        super();
    }

    public Felt[] loadFelter() throws FileNotFoundException {
        resetInput();
        ArrayList<Felt> felter = new ArrayList<>();
        while(input.hasNext()){
            String navn = input.next();
            int likviditetsvirkning = Integer.parseInt(input.next());
            boolean ekstraTur = Boolean.parseBoolean(input.next());
            felter.add(new Felt(likviditetsvirkning, navn, ekstraTur));
            input.next();
        }
        return felter.toArray(new Felt[0]);
    }
}
