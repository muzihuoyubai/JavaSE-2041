import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;
import org.junit.Test;

public class SplitTest {

  @Test
  public void splitTest() {
    Main main = new Main();
    File sourceFile = new File("/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/doc/WIN.mp3");
    File targetFolder = new File(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/01.SplitFile/target");
    main.split(sourceFile, 10240,
        targetFolder);

    Assert.assertTrue(targetFolder.exists());
    Assert.assertTrue(targetFolder.isDirectory());

    File[] files = targetFolder.listFiles();
    Assert.assertEquals(9, files.length);
    long totalSize = 0;
    for (int i = 0; i < files.length; i++) {
      totalSize += files[i].length();
    }

    for (File file : files) {
      System.out.println(file.getName());
    }

    Arrays.sort(files, new Comparator<File>() {
      @Override
      public int compare(File o1, File o2) {
        String o1Name = o1.getName();
        String o2Name = o2.getName();
        String o1Num = o1Name.substring(o1Name.lastIndexOf(".") + 1);
        String o2Num = o2Name.substring(o2Name.lastIndexOf(".") + 1);
        return Integer.parseInt(o1Num) - Integer.parseInt(o2Num);

        // 这样排序 会出现 .1 > .10 > .2
        // return o1Name.compareTo(o2Name);
      }
    });

    for (File file : files) {
      System.out.println(file.getName());
    }
    Assert.assertEquals(sourceFile.length(), totalSize);
  }

  @Test
  public void combineTest() {
    Main main = new Main();
    File sourceFolder = new File(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/01.SplitFile/target");
    File targetFolder = new File(
        "/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/practice/01.SplitFile/combine");
    main.combine(sourceFolder, targetFolder);

    Assert.assertTrue(targetFolder.exists());
    File[] files = targetFolder.listFiles();
    Assert.assertEquals(1, files.length);
    File file = files[0];
    File expectFile = new File("/Users/liyi/works/repos/banyuan/JavaSE-2041/21.IO/doc/WIN.mp3");
    Assert.assertEquals(expectFile.getName(), file.getName());
    Assert.assertEquals(expectFile.length(), file.length());

    try {
      FileInputStream expectStream = new FileInputStream(expectFile);
      FileInputStream actualStream = new FileInputStream(file);
      byte[] buf = new byte[1024];
      byte[] actualBuf = new byte[1024];
      int count;
      // Assert.assertArrayEquals();
      while ((count = expectStream.read(buf)) > 0) {
        int read = actualStream.read(actualBuf);
        Assert.assertEquals(read, count);
        Assert.assertArrayEquals(buf, actualBuf);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
