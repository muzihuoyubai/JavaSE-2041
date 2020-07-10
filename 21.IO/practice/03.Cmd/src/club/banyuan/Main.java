package club.banyuan;

import java.io.File;

public class Main {

  public static void main(String[] args) {

    // ls
    // ls 路径
    // ls 路径 -l
    // ls -l
    // cp 路径1 路径2
    // rm 路径
    // cat 文件路径

    try {
      if (args.length < 1) {
        throw new RuntimeException("参数不合法");
      }

      String cmd = args[0];
      switch (cmd) {
        case "ls":
          ls(args);
          break;
        case "cp":
          break;
        case "cat":
          break;
        case "rm":
          break;
        default:
          throw new RuntimeException("不认识的命令" + cmd);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private static void ls(String[] args) {
    if (args.length == 1) {
      File file = new File(".");
      File[] list = file.listFiles();
      if (list == null || list.length == 0) {
        return;
      }
      int newLine = 1;
      for (File s : list) {
        if (newLine % 5 == 0) {
          System.out.println();
          newLine = 1;
        }
        System.out.print(s.getName() + "\t\t");
        newLine++;
      }
    }
  }

}
