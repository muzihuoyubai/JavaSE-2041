import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ClassRoomTest {

  @Test
  public void test() {
    ClassRoom cr = new ClassRoom();
    Student lowestId = new Student(1, "张三", 18);
    Student highestId = new Student(5, "田七", 19);
    cr.addStd(lowestId);
    cr.addStd(new Student(2, "李四", 20));
    cr.addStd(new Student(3, "王五", 22));
    cr.addStd(new Student(4, "赵六", 17));
    cr.addStd(highestId);
    cr.addStd(new Student(2, "刘八", 16));

    cr.print();

    List<Student> list = cr.sortById();
    Assert.assertEquals(lowestId, list.get(0));
    Assert.assertEquals(highestId, cr.sortById(false).get(0));
  }
}
