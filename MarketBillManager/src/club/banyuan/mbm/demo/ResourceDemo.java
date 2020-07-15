package club.banyuan.mbm.demo;

import club.banyuan.mbm.server.HttpServer;
import java.io.IOException;

public class ResourceDemo {

  public static void main(String[] args) throws IOException {
    // 返回程序启动的类路径
    System.out.println(HttpServer.class.getClassLoader()
        .getResource("").getPath());
    // 返回class所在的路径，类路径加上包路径
    System.out.println(HttpServer.class.getResource("").getPath());

    // getResource返回null
    // System.out.println(HttpServer.class.getClassLoader()
    //     .getResource("/").getPath());
    // 返回class所在的路径，类路径加上包路径
    System.out.println("绝对路径");
    System.out.println(HttpServer.class.getResource("/").getPath());

    // 获取类路径下的资源的两种方式
    System.out.println(HttpServer.class.getResource("/pages/login.html").getPath());
    System.out.println(HttpServer.class.getClassLoader().getResource("pages/login.html").getPath());

    // 获取到资源路径下的文件夹的名字
    System.out.println(new String(HttpServer.class.getClassLoader()
        .getResourceAsStream("").readAllBytes()));


  }
}
