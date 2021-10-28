package game.domain;

import game.GUI.SpilGUI;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Spil spil = new Spil();
        SpilGUI gui = new SpilGUI(spil);
        gui.kørSpil();
    }
}
