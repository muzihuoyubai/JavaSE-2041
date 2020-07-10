import java.util.Scanner;

class VideoStoreLauncher {

  private static final Scanner scanner = new Scanner(System.in);
  private static final VideoStore vs = new VideoStore();

  public static void main(String[] args) {

    vs.load();

    while (true) {
      System.out.println("1. 添加电影");
      System.out.println("2. 出租电影");
      System.out.println("3. 归还电影");
      System.out.println("4. 查询电影");
      System.out.println("0. 退出");

      String input = scanner.nextLine();
      switch (input) {
        case "1":
          addMovie();
          break;
        case "2":

          break;
        case "3":
          break;
        case "4":
          printInfo();
          break;
        case "0":
          System.out.println("谢谢使用！");
          return;
      }


    }
  }

  private static void printInfo() {
    vs.listInventory();
  }

  private static void addMovie() {
    System.out.println("请输入电影名字：");
    String name = scanner.nextLine();
    // Video video = new Video("name");
    Video video = vs.addVideo(name);
    System.out.println(video);
  }
}