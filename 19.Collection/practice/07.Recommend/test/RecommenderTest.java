import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class RecommenderTest {

  @Test
  public void test() {
    Recommender recommender = new PersonalRecommender();
    recommender.add("张三", Arrays.asList("1", "2", "3"));
    recommender.add("李四", Arrays.asList("3", "4", "5"));
    recommender.likesBoth("张三", "1", "3");
    recommender.likesBoth("张三", "3", "4");
    Assert.assertTrue(recommender.likesBoth("张三", "1", "3"));
    Assert.assertFalse(recommender.likesBoth("张三", "3", "4"));
    try {
      recommender.recommendByPerson("3");
      Assert.fail();
    } catch (Exception e) {
    }
    List<String> list1 = recommender.recommendByPerson("张三");
    List<String> list = new LinkedList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list1.containsAll(list);
    Assert.assertTrue(list1.containsAll(list));
  }

}
