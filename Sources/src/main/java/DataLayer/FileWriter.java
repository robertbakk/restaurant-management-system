package DataLayer;

import java.io.*;

public class FileWriter implements Serializable {
    public void createBill(String s, int i, int o) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("Bill table " + i +" for order " + o + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.write(s);
        pw.close();

    }
}
