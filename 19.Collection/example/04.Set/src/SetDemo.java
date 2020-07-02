import club.banyuan.team.Player;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("123");
    set.add("321");
    System.out.println(set.size());
    set.add(null);
    System.out.println(set.size());
    set.add(null);
    System.out.println(set.size());
    set.add("123");
    System.out.println(set.size());
    System.out.println(set);
    System.out.println("============");
    List<String> list = new ArrayList<>();
    list.add("123");
    list.add("321");
    System.out.println(list.size());
    list.add(null);
    System.out.println(list.size());
    list.add(null);
    System.out.println(list.size());
    list.add("123");
    System.out.println(list.size());
    System.out.println(list);

    // 去重
    Set<String> set1 = new HashSet<>(list);
    System.out.println(set1);

    List<Player> players = new ArrayList<>();
    players.add(new Player("1",1,"PG"));
    players.add(new Player("1",1,"PG"));
    players.add(new Player("2",2,"SG"));
    players.add(new Player("1",1,"PG"));
    players.add(new Player("3",3,"SF"));
    players.add(new Player("1",3,"SF"));
    System.out.println(players);
    System.out.println(players.size());
    Set<Player> players1 = new HashSet<>(players);
    System.out.println(players1);
  }
}
