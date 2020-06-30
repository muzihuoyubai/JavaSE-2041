package club.banyuan.machine;

import club.banyuan.exception.GateBrokenException;
import java.util.Random;

public class Gate {

  private boolean isOpen = false;
  private Random random = new Random();

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean open) throws GateBrokenException {
    if (open) {
      if (random.nextBoolean()) {
        throw new GateBrokenException("门坏掉了");
      }
    }
    isOpen = open;
    if (isOpen) {
      System.out.println("门被打开");
    } else {
      System.out.println("门被关闭");
    }
  }
}
