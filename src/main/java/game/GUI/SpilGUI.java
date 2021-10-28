package game.GUI;

import game.Util.DomainFeltFactory;
import game.Util.GUIFeltFactory;
import game.Util.SpilData;
import game.domain.Felt;
import game.domain.Spil;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SpilGUI {
    private GUI_Player p1;
    private GUI_Player p2;
    private GUI gui;
    private HashMap<String, String> feltBeskeder;
    private Spil spil;

    public SpilGUI(Spil s) throws FileNotFoundException {
        spil = s;
        GUIFeltFactory factory = new GUIFeltFactory();
        feltBeskeder = factory.lavBeskeder();
        GUI_Field[] f = factory.loadFelter();
        Felt[] felter = new DomainFeltFactory().loadFelter();
        new GUI_Car();
        GUI_Car c1 = new GUI_Car();
        c1.setPrimaryColor(Color.BLUE);
        GUI_Car c2 = new GUI_Car();
        c2.setPrimaryColor(Color.WHITE);
        p1 = new GUI_Player("Spiller 1", SpilData.getInstance().getSTARTBALANCE(),c1);
        p2 = new GUI_Player("Spiller 2", SpilData.getInstance().getSTARTBALANCE(), c2);
        gui = new GUI(factory.loadFelter());
        gui.addPlayer(p1);
        gui.addPlayer(p2);
        setBil(p1,"Monastery");
        setBil(p2, "Monastery");
        gui.setDice(1,1);
    }

    public void kørSpil(){
        spil();
        visVinder();
    }

    private void visVinder(){
        if(spil.getVinder() == spil.getS1()){
            gui.showMessage("Spiller 1 har vundet");
        }else{
            gui.showMessage("Spiller 2 har vundet");
        }
    }

    private void spil() {
        while(!spil.har_vinder()){
            gui.getUserSelection("Tag tur", "Tag tur");
            spil.tag_tur();
            flytBiler();
            setBil(p1, spil.getS1().getFelt().getNavn());
            setBil(p2, spil.getS2().getFelt().getNavn());
            if(spil.getTur_spiller() == spil.getS1()){
                int[] status = spil.getS2().getStatus();
                gui.setDice(status[0], status[1]);
                p2.setBalance(status[2]);
                gui.showMessage(feltBeskeder.get(spil.getS2().getFelt().getNavn()));
            }else{
                int[] status = spil.getS1().getStatus();
                gui.setDice(status[0], status[1]);
                p1.setBalance(status[2]);
                gui.showMessage(feltBeskeder.get(spil.getS1().getFelt().getNavn()));
            }
        }
    }

    private void flytBiler(){
        for(GUI_Field f : gui.getFields())
            f.removeAllCars();
    }

    private void setBil(GUI_Player spiller, String navn){
        for(int i = 0; i < gui.getFields().length; i++){
            String s = gui.getFields()[i].getTitle();
            if(gui.getFields()[i].getTitle().equals(navn)){
                gui.getFields()[i].setCar(spiller, true);
                return;
            }
        }

    }
}
