package club.banyuan.team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Team {

  private List<Player> starting = new ArrayList<>();

  private List<Player> substitution = new ArrayList<>();

  public List<Player> getStarting() {
    return starting;
  }

  public void setStarting(List<Player> starting) {
    this.starting = starting;
  }

  public List<Player> getSubstitution() {
    return substitution;
  }

  public void setSubstitution(List<Player> substitution) {
    this.substitution = substitution;
  }

  public void add(Player player) {
    if (!starting.contains(player) && starting.size() < 5) {
      starting.add(player);
    } else {
      substitution.add(player);
    }
  }

  /**
   * 返回第一个查到找到该位置的球员
   *
   * @param players
   */
  private Player getByPosition(List<Player> players, String position) {
    for (Player player : players) {
      if (position.equals(player.getPosition())) {
        return player;
      }
    }
    throw new RuntimeException("没有找到该位置的球员");
  }

  public void replace(Player player) {
    Player startPlayer = getByPosition(starting, player.getPosition());
    starting.remove(startPlayer);
    substitution.remove(player);
    starting.add(player);
    substitution.add(startPlayer);
    starting.sort(Comparator.comparingInt(Player::getPositionIndex));
    substitution.sort(Comparator.comparingInt(Player::getPositionIndex));
  }

  public void remove(Player player) {
    if (starting.remove(player)) {
      Player byPosition = null;
      try {
        byPosition = getByPosition(substitution, player.getPosition());
        starting.add(byPosition);
        substitution.remove(byPosition);
        starting.sort(Comparator.comparingInt(Player::getPositionIndex));
      } catch (RuntimeException e) {
        System.err.println("没有相同位置的替补");
      }
    } else {
      substitution.remove(player);
    }
  }

  public void replace(List<Player> players) {
    List<Player> all = new ArrayList<>(starting);
    all.addAll(substitution);

    starting.clear();
    if (players.size() > 5) {
      throw new RuntimeException("人数不合法");
    }
    starting.addAll(players);
    List<String> positions = new ArrayList<>();
    for (Player player : starting) {
      if (positions.contains(player.getPosition())) {
        throw new RuntimeException("位置重复了");
      }
      positions.add(player.getPosition());
    }

    Iterator<Player> iterator = all.iterator();
    while (iterator.hasNext()) {
      Player next = iterator.next();
      if (!positions.contains(next.getPosition())) {
        starting.add(next);
        positions.add(next.getPosition());
        iterator.remove();
      }
    }

    if (starting.size() < 5) {
      throw new RuntimeException("人数不够了");
    }
    starting.sort(Comparator.comparingInt(Player::getPositionIndex));
    substitution = all;
    substitution.removeAll(starting);
    substitution.sort(Comparator.comparingInt(Player::getPositionIndex));

  }


  public void print() {
    System.out.println("====首发====");
    System.out.println(starting);
    System.out.println("====替补====");
    System.out.println(substitution);
  }
}
