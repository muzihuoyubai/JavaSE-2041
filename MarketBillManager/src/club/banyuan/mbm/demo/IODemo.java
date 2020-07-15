package club.banyuan.mbm.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class IODemo {

  /**
   * 为什么带有Buffered效率更高
   * 内存 <= 数据（硬盘、网络）  100 = 10 * 10
   * buffered 内存 <= 数据  100 (10) (10) (10)
   * <p>
   * 内存 => 数据 (硬盘、网络) 100 = 10 * 10
   * buffered  (10 + 10 + 10) => 30
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      // abc
      String read = reader.readLine();
      if (read == null) {
        break;
      }
      stringBuilder.append(read);
      stringBuilder.append(System.lineSeparator());
    }
    System.out.println("read:" + stringBuilder.toString() + ":finish");

    // Reader reader1 = new InputStreamReader(System.in);
    //
    //
    // while (true) {
    //   // abc
    //   int read = reader1.read();
    //   if (read < 0) {
    //     break;
    //   }
    //   stringBuilder.append((char) read);
    // }
    // System.out.println("read1:" + stringBuilder.toString() + ":finish");
  }
}
