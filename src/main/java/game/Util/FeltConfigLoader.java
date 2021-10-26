package game.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FeltConfigLoader {
    private static FeltConfigLoader instance;
    private Scanner feltInput;
    private static String fil = "src/main/resources/FeltConfig";

    private FeltConfigLoader() throws FileNotFoundException {
        feltInput = new Scanner(new File(fil));
        feltInput.useDelimiter(";");
    }
    public static FeltConfigLoader getInstance() throws FileNotFoundException {
        if(instance == null){
            instance = new FeltConfigLoader();
        }
        return instance;
    }

    public Scanner getFeltInput() throws FileNotFoundException {
        feltInput.close();
        feltInput = new Scanner(new File(fil));
        feltInput.useDelimiter(";");
        return feltInput;
    }
}
