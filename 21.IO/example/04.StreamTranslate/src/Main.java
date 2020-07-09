import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  // OutputStream -> Writer
  // Writer = new Writer(new OutputStreamWriter(OutputStream))
  public static void main(String[] args) throws FileNotFoundException {

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("")));
  }
}
