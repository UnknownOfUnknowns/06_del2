package game.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FeltConfigLoader {
    private static FeltConfigLoader instance;
    private final Scanner feltInput;

    private FeltConfigLoader() throws FileNotFoundException {
        String fil = "src/main/resources/FeltConfig";
        feltInput = new Scanner(new File(fil));
        feltInput.useDelimiter(";");
    }
    public static FeltConfigLoader getInstance() throws FileNotFoundException {
        if(instance == null){
            instance = new FeltConfigLoader();
        }
        return instance;
    }

    public Scanner getFeltInput() {
        return feltInput;
    }
}
