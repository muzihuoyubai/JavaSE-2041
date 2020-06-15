package club.banyuan;

public class SystemExitDemo {

  public static void main(String[] args) {
    // 如果程序启动的时候没有传入其他参数，则异常退出
    if (args.length == 0) {
      System.exit(1);
    }
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      System.out.println(arg);
    }
  }
}
