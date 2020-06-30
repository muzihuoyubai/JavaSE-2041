package club.banyuan.main;

import club.banyuan.animal.Elephant;
import club.banyuan.exception.ElephantTooHeightException;
import club.banyuan.machine.Fridge;
import club.banyuan.machine.Gate;
import club.banyuan.exception.GateBrokenException;

public class Main {

  public static void main(String[] args) throws GateBrokenException {
    Fridge fridge = new Fridge(new Gate(), 200);
    Elephant elephant = new Elephant(300);
    try {
      fridge.openGate();
      fridge.setElephant(elephant);
      System.out.println("把大象装进冰箱");
      // fridge.closeGate();
    } catch (GateBrokenException e) {
      System.out.println(e.getMessage());
      System.out.println("需要找人修理这个门");
    } catch (ElephantTooHeightException e) {
      System.out.println(e.getMessage());
      System.out.println("把大象放掉了");
    } finally {
      System.out.println("最终");
      if (fridge.isGateOpen()) {
        fridge.closeGate();
      }
    }

    System.out.println("代码结束");
  }
}
