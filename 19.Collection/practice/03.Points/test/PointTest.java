import club.banyuan.Point;
import club.banyuan.PointUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

  @Test
  public void test() {
    List<Point> points = new LinkedList<>();
    points.add(new Point(1, 1));
    points.add(new Point(1, 3));
    points.add(new Point(3, 1));
    points.add(new Point(3, 3));

    /* 应该是Point [x = 3，y = 3]或Point [x = 1，y = 3] */
    System.out.println(PointUtils.highestPoint(points));
    // 结果是[x = 3，y = 3] 或  [x = 1，y = 3]中的一个
    List<Point> rls = new ArrayList<>();
    rls.add(new Point(3, 3));
    rls.add(new Point(1, 3));
    Assert.assertTrue(rls.contains(PointUtils.highestPoint(points)));

    // 应该是Point[x=2,y=2]
    System.out.println(PointUtils.centroid(points));
    Assert.assertEquals(new Point(2, 2), PointUtils.centroid(points));

    points = new LinkedList<Point>();
    points.add(new Point(1, 1));
    points.add(new Point(1, -1));
    points.add(new Point(-1, 1));
    points.add(new Point(-1, -1));

    /* 应该是Point[x=1,y=1] 或[x=-1,y=1] */
    System.out.println(PointUtils.highestPoint(points));

    rls.clear();
    rls.add(new Point(1, 1));
    rls.add(new Point(-1, 1));
    Assert.assertTrue(rls.contains(PointUtils.highestPoint(points)));

    // 应该是[x=0,y=0]
    System.out.println(PointUtils.centroid(points));
    Assert.assertEquals(new Point(0, 0), PointUtils.centroid(points));

  }
}
