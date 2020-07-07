package club.banyuan.syncmethod;

public class ShareResource {

  synchronized public void methodA() {
    System.out.println("methodA");
    try {
      methodB();
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized public void methodB() {
    System.out.println("methodB");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
