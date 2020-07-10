import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BufferedWriteDemo {

  public static void main(String[] args) throws IOException {
    // File file = new File(
    //     "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/example/03.Buffered/file");

    // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
    //
    // bufferedWriter.write("12345678");
    //
    // bufferedWriter.newLine();
    //
    // // 使用flush清空缓冲区
    // bufferedWriter.flush();
    //
    // bufferedWriter.close();

    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    bufferedWriter.write("12345678");
    bufferedWriter.flush();

    // Scanner scanner = new Scanner(System.in);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(bufferedReader.readLine());

  }
}
