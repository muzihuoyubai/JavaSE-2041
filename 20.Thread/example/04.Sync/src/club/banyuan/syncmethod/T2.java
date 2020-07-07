package club.banyuan.syncmethod;

public class T2 extends Thread {

  ShareResource shareResource;

  public T2(ShareResource shareResource) {
    this.shareResource = shareResource;
  }

  @Override
  public void run() {
    System.out.println("T2 call methodB");
    shareResource.methodB();
    System.out.println("call methodB finish");
  }
}
