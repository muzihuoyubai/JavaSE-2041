import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CellularPhone extends Thread {

  private volatile boolean callInProgress = false;
  private volatile boolean keepGoing = true;
  private Lock lock = new ReentrantLock();
  // Set<String> set = new CopyOnWriteArraySet<>();
  private Queue<String> queue = new LinkedList<>();

  public CellularPhone(String name) {
    super(name);
  }

  /**
   * 假设控制台是手机的窗口。
   *
   * @param message 要显示的消息
   */
  void display(String message) {
    System.out.println(message);
  }

  /**
   * 接听电话。在终端显示消息。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 呼叫正在进行时显示的消息
   * @returns 如果调用被接受，则为true
   */
  public boolean startCall(String name, String callDisplayMessage) {
    // if(callInProgress){
    //   return false;
    // }
    // boolean b = false;
    // try {
    //   b = lock.tryLock(200, TimeUnit.MILLISECONDS);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // if (!b) {
    //   return false;
    // }
    if (!lock.tryLock()) {
      return false;
    }
    callInProgress = true;
    display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
    return true;
  }

  /**
   * 挂断电话。在此方法完成后，电话能够接听其他电话。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 要显示的消息
   */
  public void endCall(String name, String callDisplayMessage) {
    display("   <" + name + ">: Call (" + callDisplayMessage + ") ends");
    callInProgress = false;
    lock.unlock();
  }

  /**
   * 显示手机正在等待做某事
   */
  private void displayWaiting() {
    display("<" + this.getName() + ">: Waiting...");
  }

  /**
   * 停止电话接听程序
   */
  public void stopPhone() {
    displayMessage();
    keepGoing = false;
  }

  /**
   * 运行模拟器
   */
  public void run() {
    // 循环直到stopPhone被调用
    while (keepGoing) {
      if (lock.tryLock()) {
        displayWaiting();
        displayMessage();
        lock.unlock();
      }
      // 假装手机在做别的事情
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  synchronized private void displayMessage() {
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }

  }

  synchronized public void addMessage(String s) {
    queue.offer(s);
  }
}
