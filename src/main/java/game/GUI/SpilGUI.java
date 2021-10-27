package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.domain.Felt;
import game.domain.Spil;
import gui_fields.*;
import gui_main.GUI;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SpilGUI {
    private static GUI_Player p1;
    private static GUI_Player p2;
    private static GUI gui;
    private static HashMap<String, String> feltBeskeder;
    private static Spil spil;
    public static void main(String[] args) throws FileNotFoundException {
        setUp();
        spil();
    }

    private static void spil(){
        while(!spil.har_vinder()){
            gui.getUserSelection("Tag tur", "Tag tur");
            spil.tag_tur();
            if(spil.getTur_spiller() == spil.getS1()){
                int[] status = spil.getS2().getStatus();
                gui.setDice(status[0], status[1]);
                p2.setBalance(status[2]);
            }else{
                int[] status = spil.getS1().getStatus();
                gui.setDice(status[0], status[1]);
                p1.setBalance(status[2]);
            }
            flytBiler();
            setBil(p1, spil.getS1().getFelt().getNavn());
            setBil(p2, spil.getS2().getFelt().getNavn());
        }
    }

    private static void flytBiler(){
        for(GUI_Field f : gui.getFields())
            f.removeAllCars();
    }

    private static void setBil(GUI_Player spiller, String navn){
        for(int i = 0; i < gui.getFields().length; i++){
            String s = gui.getFields()[i].getTitle();
            if(gui.getFields()[i].getTitle().equals(navn)){
                gui.getFields()[i].setCar(spiller, true);
                return;
            }
        }

    }

    private static void setUp() throws FileNotFoundException {
        GUIFeltFactory factory = new GUIFeltFactory();

        spil = new Spil();
        Felt[] felter = new DomainFeltFactory().loadFelter();
        feltBeskeder = factory.lavBeskeder();
        GUI_Field[] f = factory.loadFelter();
        p1 = new GUI_Player("Spiller 1", 1000);
        p2 = new GUI_Player("Spiller 2", 1000);
        gui = new GUI(factory.loadFelter());
        gui.addPlayer(p1);
        gui.addPlayer(p2);
        setBil(p1,"Monastery");
        setBil(p2, "Monastery");
        gui.setDice(1,1);
    }

}
