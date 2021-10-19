package game.GUI;

import game.Util.FeltConfigLoader;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Empty;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpilGUI {

    public static void main(String[] args) throws FileNotFoundException {
        GUI gui = new GUI(loadFelter());
    }


    private static GUI_Field[] loadFelter() throws FileNotFoundException {
        Scanner input = FeltConfigLoader.getInstance().getFeltInput();
        ArrayList<GUI_Field> felter = new ArrayList<GUI_Field>();
        while(input.hasNext()){
            felter.add(new GUI_Street(input.next(), "Pris: " + input.next(),"", "", Color.blue, Color.black));
        }
        GUI_Field[] f2 = new GUI_Field[felter.size()];
        for(int i = 0; i < f2.length; i++)
            f2[i] = felter.get(i);
        return f2;
    }
}
