package club.banyuan.syncmethod;

public class T1 extends Thread {

  ShareResource shareResource;

  public T1(ShareResource shareResource) {
    this.shareResource = shareResource;
  }

  @Override
  public void run() {
    System.out.println("T1 call methodA");
    shareResource.methodA();
    System.out.println("call methodA finish");
  }

  public static void main(String[] args) {
    ShareResource shareResource = new ShareResource();
    T1 t1 = new T1(shareResource);
    T2 t2 = new T2(shareResource);
    t1.start();
    t2.start();
  }

}
