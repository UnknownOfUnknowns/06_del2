package game.Util;

public class SpilData {
    private static SpilData instance;
    private final int TERNINGSIDER = 6;

    private SpilData(){

    }

    public static SpilData getInstance() {
        if(instance == null){
            instance = new SpilData();
        }
        return instance;
    }

    public int getTERNINGSIDER() {
        return TERNINGSIDER;
    }
}
