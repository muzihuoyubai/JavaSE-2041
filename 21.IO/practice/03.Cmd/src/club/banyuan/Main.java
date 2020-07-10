package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    // ls
    // ls 路径
    // ls -l
    // ls 路径 -l
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
          cp(args);
          break;
        case "cat":
          cat(args);
          break;
        case "rm":
          rm(args);
          break;
        default:
          throw new RuntimeException("不认识的命令" + cmd);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  private static void cat(String[] args) {
    if (args.length != 2) {
      throw new RuntimeException("参数不合法");
    }

    File file = new File(args[1]);

    if (!file.isFile()) {
      throw new RuntimeException("不是文件");
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // cp /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/01.SplitFile/combine/WIN.mp3 /Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/01.SplitFile/combine/WIN123.mp3
  // 只复制文件
  private static void cp(String[] args) {
    if (args.length != 3) {
      throw new RuntimeException("参数不合法");
    }
    File source = new File(args[1]);
    File target = new File(args[2]);

    if (!source.isFile()) {
      throw new RuntimeException("不是文件");
    }

    try (FileOutputStream fileOutputStream = new FileOutputStream(target);
        FileInputStream fileInputStream = new FileInputStream(source)) {
      byte[] buf = new byte[1024];
      int count = fileInputStream.read(buf);
      while (count > 0) {
        fileOutputStream.write(buf, 0, count);
        count = fileInputStream.read(buf);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  // args[0] = rm
  // args[1] = 路径
  private static void rm(String[] args) {
    if (args.length == 2) {
      File file = new File(args[1]);
      if (!file.exists()) {
        throw new RuntimeException("文件不存在");
      }

      if (file.isDirectory()) {
        rmDir(file);
      } else {
        file.delete();
      }

    } else {
      throw new RuntimeException("参数不合法");
    }


  }

  private static void rmDir(File file) {
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      if (files == null) {
        return;
      }
      for (File subFile : files) {
        if (subFile.isDirectory()) {
          rmDir(subFile);
        } else {
          subFile.delete();
        }
      }
      file.delete();
    }
  }

  private static void ls(String[] args) {
    if (args.length == 1) {
      printDir(".");
    } else if (args.length == 2) {
      if ("-l".equals(args[1])) {
        printDirList(".");
      } else {
        printDir(args[1]);
      }
    } else if (args.length == 3) {
      if (!"-l".equals(args[2])) {
        throw new RuntimeException("参数不合法");
      } else {
        printDirList(args[1]);
      }
    } else {
      throw new RuntimeException("参数不合法");
    }
  }

  private static void printDir(String path) {
    File file = new File(path);
    if (!file.exists() || !file.isDirectory()) {
      throw new RuntimeException("路径不合法");
    }
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
      System.out.printf("%-25s", s.getName());
      newLine++;
    }
    System.out.println();
  }

  private static void printDirList(String path) {
    File file = new File(path);
    if (!file.exists() || !file.isDirectory()) {
      throw new RuntimeException("路径不合法");
    }
    printDirList(file);
  }

  private static void printDirList(File file) {
    File[] list = file.listFiles();
    if (list == null || list.length == 0) {
      return;
    }
    for (File one : list) {
      String dir = one.isDirectory() ? "d" : "-";
      Date date = new Date(one.lastModified());
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      System.out.printf("%1s%10d%20s\t\t%s\n", dir, one.length(), simpleDateFormat.format(date),
          one.getName());
    }
  }

}
