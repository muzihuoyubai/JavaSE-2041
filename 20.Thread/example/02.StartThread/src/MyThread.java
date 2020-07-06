public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      System.out.println(getName() + i);
    }
  }

  public static void main(String[] args) {
    MyThread myThread = new MyThread("线程1");
    myThread.start();
    MyThread myThread2 = new MyThread("线程2");
    myThread2.start();
  }
}
