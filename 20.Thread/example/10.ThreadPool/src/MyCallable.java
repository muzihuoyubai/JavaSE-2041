import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

  @Override
  public String call() throws Exception {
    System.out.println("执行线程");
    Thread.sleep(5000);
    throw new RuntimeException();
    // return "返回线程结果";
  }
}
