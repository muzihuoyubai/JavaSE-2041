import club.banyuan.ObjectPairDriver;
import club.banyuan.Pair;
import club.banyuan.PairDriver;
import club.banyuan.Pairs;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PairDriverTest {

  /**
   * 创建几个体育场对，然后打印容量最大的体育场名称。
   */
  @Test
  public void test() {

    Pair<String, Integer>[] stadiums = new Pair[3];
    stadiums[0] = new Pair<>("五棵松", 25000);
    stadiums[1] = new Pair<>("鸟巢", 109901);
    stadiums[2] = new Pair<>("奥体中心", 66233);

    System.out.println(stadiums[0]);
    String s = PairDriver.largestStadium(stadiums);
    Assert.assertEquals("鸟巢", s);
  }

  @Test
  public void testIterator() {
    Pairs<String, Integer> pairs = new Pairs<>();
    for (int i = 0; i < 15; i++) {
      pairs.addPair("A" + i, i);
    }

    /* 遍历并打印 */
    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    Assert.assertEquals(15, pairs.getPairs().size());
    Assert.assertEquals(new Pair<>("A14", 14), pairs.getPairs().get(14));

    Iterator<Pair<String, Integer>> iterator = pairs.iterator();
    while (iterator.hasNext()) {
      Pair<String, Integer> pair = iterator.next();
      /* 删除偶数位置的内容 */
      if ((pair.getSecond() % 2) == 0) {
        iterator.remove();
      }
    }

    for (Pair<String, Integer> pair : pairs.getPairs()) {
      Assert.assertTrue(pair.getSecond() % 2 != 0);
    }

    /* 再次迭代并打印剩余的 */
    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    /* 现在重新添加一些内容并确认已添加 */
    pairs.addPair("B", 10);

    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    List<Pair<String, Integer>> pairs1 = pairs.getPairs();
    Assert.assertEquals(new Pair<>("B", 10), pairs1.get(pairs1.size() - 1));
  }
}