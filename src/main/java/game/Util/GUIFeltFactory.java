package game.Util;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GUIFeltFactory {
    private Scanner input;
    public GUIFeltFactory() throws FileNotFoundException {
        resetInput();
    }

    private void resetInput() throws FileNotFoundException {
        input = FeltConfigLoader.getInstance().getFeltInput();
    }
    public HashMap<String,String> lavBeskeder() throws FileNotFoundException {
        resetInput();
        HashMap<String,String> beskeder = new HashMap<>();
        while (input.hasNext()) {
            String key = input.next();
            input.next();
            input.next();
            String value = input.next();
            beskeder.putIfAbsent(key, value);
        }
        return beskeder;
    }

    public GUI_Field[] loadFelter() throws FileNotFoundException {
        resetInput();
        ArrayList<GUI_Field> felter = new ArrayList<>();
        while(input.hasNext()){
            felter.add(new GUI_Street(input.next(), "Pris: " + input.next(),"", "", Color.blue, Color.black));
            input.next();
            input.next();
        }
        GUI_Field[] f2 = new GUI_Field[felter.size()];
        for(int i = 0; i < f2.length; i++)
            f2[i] = felter.get(i);
        return f2;
    }
}
