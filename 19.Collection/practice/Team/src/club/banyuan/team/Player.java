package club.banyuan.team;

import java.util.Objects;

public class Player {

  private String name;
  private int num;
  private String position;
  private int positionIndex;

  public Player(String name, int num, String position) {
    this.name = name;
    this.num = num;
    this.position = position;
    switch (position) {
      case "SG":
        positionIndex = 2;
        break;
      case "PG":
        positionIndex = 1;
        break;
      case "SF":
        positionIndex = 3;
        break;
      case "PF":
        positionIndex = 4;
        break;
      case "C":
        positionIndex = 5;
        break;
      default:
        throw new RuntimeException("不支持的位置！");
    }
  }

  public int getPositionIndex() {
    return positionIndex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return num == player.num &&
        Objects.equals(name, player.name) &&
        Objects.equals(position, player.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, num, position);
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", num=" + num +
        ", position='" + position + '\'' +
        '}';
  }
}
