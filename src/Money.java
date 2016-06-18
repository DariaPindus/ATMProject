import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Money {
    //можно ли тут использовать статик??
    private static float[] rates;
    private float amountInUH;
    private BufferedReader myfile;

    public Money() throws IOException {
        rates = new float[2];
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
    }

    public static float CalculateInUSD(float amount) {
        return amount*rates[0];
    }

    public static float CalculateInEuro(float amount){
        return amount*rates[2];
    }
}
