import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 16.06.2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        float[] rates = new float[5];
        try {
            String currLine;
            BufferedReader myfile = new BufferedReader(new FileReader("N:\\JavaProgs\\ATMProject\\src\\rates"));
            int i = 0;
            while ((currLine = myfile.readLine()) != null) {
                rates[i] = Float.parseFloat(currLine.substring(currLine.indexOf(' ')));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rates.length; i++){
            System.out.println(rates[i]);
        }
    }
}

