package club.banyuan;

public class ReverseHelloMultithreaded extends Thread {

  private int num;

  public ReverseHelloMultithreaded(int num) {
    this.num = num;
  }


  public ReverseHelloMultithreaded(String name) {
    super(name);
  }

  public static void doReverseHello() {
    ReverseHelloMultithreaded thread = new ReverseHelloMultithreaded(1);
    thread.start();
  }

  @Override
  public void run() {
    if (num < 50) {
      ReverseHelloMultithreaded thread = new ReverseHelloMultithreaded(
          num + 1);
      thread.start();
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Hello from thread " + num);
  }

  // @Override
  // public void run() {
  //   if (Integer.parseInt(getName()) < 50) {
  //     ReverseHelloMultithreaded thread = new ReverseHelloMultithreaded(
  //         Integer.parseInt(getName()) + 1 + "");
  //     thread.start();
  //     try {
  //       thread.join();
  //     } catch (InterruptedException e) {
  //       e.printStackTrace();
  //     }
  //   }
  //   System.out.println("Hello from Thread " + getName());
  // }

  public static void main(String[] args) {
    ReverseHelloMultithreaded.doReverseHello();
  }
}
