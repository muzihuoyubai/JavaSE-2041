package club.banyuan.mbm.uti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

  private static Properties properties = new Properties();

  // 静态代码块在被加载的时候执行
  static {

    // 获取到app.properties文件的流
    InputStream resourceAsStream = PropUtil.class.getClassLoader()
        .getResourceAsStream("app.properties");

    // 这种方式路径写死在程序中，无法兼容其他计算机的路径
    // InputStream resourceAsStream = null;
    // try {
    //   resourceAsStream = new FileInputStream(
    //       "/Users/liyi/works/repos/banyuan/JavaSE-2041/MarketBillManager/resources/app.properties");
    // } catch (FileNotFoundException e) {
    //   e.printStackTrace();
    // }
    try {
      // 读取配置文件中所有的key value数据
      properties.load(resourceAsStream);
    } catch (IOException e) {
      System.err.println("加载配置文件失败");
      System.exit(0);
    }
  }

  public static String getProp(String key) {
    return properties.getProperty(key);
  }

}
