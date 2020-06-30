package club.banyuan.machine;

import club.banyuan.animal.Elephant;

public class Fridge {

  private Gate gate;
  private Elephant elephant;

  public Fridge(Gate gate) {
    this.gate = gate;
  }

  public void openGate() throws GateBrokenException {
    gate.setOpen(true);
  }

  public void closeGate() throws GateBrokenException {
    gate.setOpen(false);
  }

  public boolean isGateOpen() {
    return gate.isOpen();
  }

  public Elephant getElephant() {
    if (!gate.isOpen()) {
      throw new FridgeGateStateIllegalException("冰箱门没有开");
    }
    return elephant;
  }

  public void setElephant(Elephant elephant) {
    if (!gate.isOpen()) {
      throw new FridgeGateStateIllegalException("冰箱门没有开");
    }
    this.elephant = elephant;
  }
}
