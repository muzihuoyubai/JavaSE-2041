package club.banyuan.team;

import org.junit.Assert;
import org.junit.Test;

public class TeamTest {

  @Test
  public void testAdd() {
    Team team = new Team();
    Player player = new Player("1", 1, "PG");
    team.add(player);
    Assert.assertEquals(1, team.getStarting().size());
    Assert.assertFalse(team.getStarting().isEmpty());
    Assert.assertTrue(team.getSubstitution().isEmpty());

    team.remove(player);
    Assert.assertTrue(team.getStarting().isEmpty());
    Assert.assertTrue(team.getSubstitution().isEmpty());
  }
}
