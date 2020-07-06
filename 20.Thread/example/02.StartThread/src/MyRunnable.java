public class MyRunnable implements Runnable {

  private String name;

  public MyRunnable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      System.out.println(getName() + i);
    }
  }

  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable("线程1");
    new Thread(myRunnable).start();
    MyRunnable myRunnable2 = new MyRunnable("线程2");
    new Thread(myRunnable2).start();
  }
}
