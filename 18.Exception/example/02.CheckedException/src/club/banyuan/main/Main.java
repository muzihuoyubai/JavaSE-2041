package club.banyuan.main;

import club.banyuan.animal.Elephant;
import club.banyuan.machine.Fridge;
import club.banyuan.machine.Gate;
import club.banyuan.machine.GateBrokenException;

public class Main {

  public static void main(String[] args) throws GateBrokenException {
    Fridge fridge = new Fridge(new Gate());
    Elephant elephant = new Elephant();
    try {
      fridge.openGate();
      fridge.setElephant(elephant);
      System.out.println("把大象装进冰箱");
      fridge.closeGate();
    } catch (GateBrokenException e) {
      System.out.println(e.getMessage());
      if (!fridge.isGateOpen()) {
        fridge.openGate();
        fridge.setElephant(elephant);
        System.out.println("再次把大象装进冰箱");
      }
      fridge.closeGate();
    }
  }
}
