package club.banyuan.machine;

import club.banyuan.animal.Elephant;
import club.banyuan.exception.ElephantTooHeightException;
import club.banyuan.exception.FridgeGateStateIllegalException;
import club.banyuan.exception.GateBrokenException;
import java.io.Closeable;
import java.io.IOException;

public class Fridge implements Closeable {

  private Gate gate;
  private Elephant elephant;
  private int heightInCM;

  public Fridge(Gate gate) {
    this.gate = gate;
  }

  public Fridge(Gate gate, int heightInCM) {
    this.gate = gate;
    this.heightInCM = heightInCM;
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
    if (heightInCM < elephant.getHeightInCM()) {
      throw new ElephantTooHeightException("大象太高了");
    }
    this.elephant = elephant;
  }

  @Override
  public void close() throws IOException {
    if (gate.isOpen()) {
      try {
        gate.setOpen(false);
      } catch (GateBrokenException e) {
        throw new IOException(e);
      }
    }
  }
}
