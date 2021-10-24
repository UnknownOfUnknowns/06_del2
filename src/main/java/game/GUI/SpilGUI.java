package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.domain.Felt;
import gui_fields.*;
import gui_main.GUI;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SpilGUI {
    private static GUI_Player p1;
    private static GUI_Player p2;
    private static GUI gui;
    private static HashMap<String, String> feltBeskeder;
    public static void main(String[] args) throws FileNotFoundException {
        setUp();
        spil();
    }

    private static void spil(){

    }

    private static void setUp() throws FileNotFoundException {
        GUIFeltFactory factory = new GUIFeltFactory();
        feltBeskeder = factory.lavBeskeder();
        p1 = new GUI_Player("Spiller 1", 1000);
        p2 = new GUI_Player("Spiller 2", 1000);
        gui = new GUI(factory.loadFelter());
        gui.addPlayer(p1);
        gui.addPlayer(p2);
        gui.setDice(1,1);
    }


}
