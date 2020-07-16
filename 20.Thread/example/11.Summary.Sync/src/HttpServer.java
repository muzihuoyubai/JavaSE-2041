import java.util.ArrayList;
import java.util.List;

public class HttpServer extends Thread {

  private UserService userService;

  public HttpServer(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    userService.addUser(new User("张三", "1234"));
  }

  static int count = 0;

  public void notSafe() {
    int temp = count;
    count = temp + 1;
  }

  public static void main(String[] args) {
    UserService userService = new UserService();

    List<HttpServer> httpServers = new ArrayList<>();
    int count = 100;
    for (int i = 0; i < count; i++) {
      HttpServer httpServer = new HttpServer(userService);
      httpServer.start();
      httpServers.add(httpServer);
    }

    // HttpServer s1 = new HttpServer(userService);
    // s1.start();
    //
    // HttpServer s2 = new HttpServer(userService);
    // s2.start();

    for (HttpServer httpServer : httpServers) {
      try {
        httpServer.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // try {
    //   s1.join();
    //   s2.join();
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }

    List<User> userList = userService.getUserList();
    System.out.println(userList);
    System.out.println(userList.size());


  }
}
