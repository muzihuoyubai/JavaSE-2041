public class HttpServer {

  static User user;


  public static void main(String[] args) {
    // TODO 读文件
    String line = "";
    if (line.contains("${name}")) {
      line.replace("${name}", user.getName());
    }

    if (line.contains("${pwd}")) {
      line.replace("${pwd}", user.getPwd());
    }

    // 写返回值
  }
}
