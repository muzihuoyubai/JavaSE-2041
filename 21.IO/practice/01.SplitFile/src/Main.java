import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {


  /**
   * @param sourceFile   目标文件
   * @param size         拆分文件大小 byte为单位
   * @param targetFolder 生成的拆分文件路径，如果传入的路径不存在，则创建这个路径
   *                     拆分文件的命名规则，原始文件名.编号。
   *                     例如 WIN.mp3 拆分后，变为 WIN.mp3.1  WIN.mp3.2 ....
   */
  void split(File sourceFile, int size, File targetFolder) {
    if (targetFolder == null) {
      throw new RuntimeException("目标路径不合法");
    }

    if (sourceFile == null) {
      throw new RuntimeException("源文件不合法");
    }

    if (!targetFolder.exists()) {
      targetFolder.mkdirs();
    }

    int splitNum = (int) Math.ceil(sourceFile.length() / (double) size);
    String name = sourceFile.getName();
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      fileInputStream = new FileInputStream(sourceFile);
      byte[] buf = new byte[1024];
      int count = 0;
      for (int i = 0; i < splitNum; i++) {
        File file = new File(targetFolder.getCanonicalPath(), name + "." + (i + 1));
        fileOutputStream = new FileOutputStream(file);
        int finish = 0;
        while ((count = fileInputStream.read(buf, 0, Math.min(buf.length, size - finish))) > 0) {
          fileOutputStream.write(buf, 0, count);
          finish += count;
        }

        fileOutputStream.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fileInputStream);
      closeStream(fileOutputStream);
    }
  }

  private void closeStream(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {

    System.out.println((int) (Math.ceil(100 / 9)));
  }

  /**
   * 将制定文件夹下的拆分文件合并为一个文件，将文件保存到指定的路径下
   *
   * @param sourceFolder 拆分文件所处的路径，其下的文件命名规则，同split拆分出来的文件名一致
   * @param targetFolder 合并之后的文件保存的路径，如果路径不存在，则创建这个目录
   */
  void combine(File sourceFolder, File targetFolder) {
    if (targetFolder == null) {
      System.out.println("目标文件夹不合法");
    }

    if (!targetFolder.exists() || !targetFolder.isDirectory()) {
      targetFolder.mkdirs();
    }

    File[] files = sourceFolder.listFiles();

    if (files == null || files.length == 0) {
      throw new RuntimeException("源文件夹不合法");
    }

    // WIN.mp3.1
    String name = files[0].getName();
    String targetFileName = name.substring(0, name.lastIndexOf("."));

    Arrays.sort(files, (o1, o2) -> {
      String o1Name = o1.getName();
      String o2Name = o2.getName();
      String o1Num = o1Name.substring(o1Name.lastIndexOf(".") + 1);
      String o2Num = o2Name.substring(o2Name.lastIndexOf(".") + 1);
      return Integer.parseInt(o1Num) - Integer.parseInt(o2Num);

      // 这样排序 会出现 .1 > .10 > .2
      // return o1Name.compareTo(o2Name);
    });
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      File targetFile = new File(targetFolder.getCanonicalPath(), targetFileName);
      fileOutputStream = new FileOutputStream(targetFile);
      byte[] buf = new byte[1024];
      int count;
      for (File file : files) {
        fileInputStream = new FileInputStream(file);
        while ((count = fileInputStream.read(buf)) > 0) {
          fileOutputStream.write(buf, 0, count);
        }
        fileInputStream.close();
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      closeStream(fileInputStream);
      closeStream(fileOutputStream);
    }

  }
}
