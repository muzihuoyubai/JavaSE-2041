public class Consumer extends Thread {

  private CommonResource commonResource;

  public Consumer(CommonResource commonResource) {
    this.commonResource = commonResource;
  }

  @Override
  public void run() {
    commonResource.setCount(commonResource.getCount() + 1);
  }


  public static void main(String[] args) {
    // CommonResource是共享资源，两个线程同时持有一个commonResource对象的引用
    CommonResource commonResource = new CommonResource();
    Consumer c1 = new Consumer(commonResource);
    c1.start();
    Consumer c2 = new Consumer(commonResource);
    c2.start();

    // 两个线程持有不同的commonResource的对象
    // Consumer c1 = new Consumer(new CommonResource());
    // c1.start();
    // Consumer c2 = new Consumer(new CommonResource());
    // c2.start();

  }
}
