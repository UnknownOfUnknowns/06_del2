package game.GUI;

import com.sun.source.tree.UsesTree;
import game.Util.FeltConfigLoader;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SpilGUI {
    private static GUI_Player p1;
    private static GUI_Player p2;
    private static GUI gui;
    public static void main(String[] args) throws FileNotFoundException {
        setUp();
        spil();
    }

    private static void spil(){

    }

    private static void setUp() throws FileNotFoundException {
        p1 = new GUI_Player("Spiller 1", 1000);
        p2 = new GUI_Player("Spiller 2", 1000);
        gui = new GUI(loadFelter());
        gui.addPlayer(p1);
        gui.addPlayer(p2);
        gui.setDice(1,1);
    }

    private static GUI_Field[] loadFelter() throws FileNotFoundException {
        Scanner input = FeltConfigLoader.getInstance().getFeltInput();
        ArrayList<GUI_Field> felter = new ArrayList<>();
        while(input.hasNext()){
            felter.add(new GUI_Street(input.next(), "Pris: " + input.next(),"", "", Color.blue, Color.black));
        }
        GUI_Field[] f2 = new GUI_Field[felter.size()];
        for(int i = 0; i < f2.length; i++)
            f2[i] = felter.get(i);
        return f2;
    }
}
