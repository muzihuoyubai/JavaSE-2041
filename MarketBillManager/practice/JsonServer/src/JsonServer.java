import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class JsonServer {

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(5000);
    while (true) {
      Socket accept = serverSocket.accept();
      BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
      String line = reader.readLine();
      if (line == null) {
        continue;
      }

      // POST /server/user/list HTTP/1.1
      String[] s = line.split(" ");
      String path = s[1];
      int contentLength = 0;
      while (line != null && line.length() != 0) {
        System.out.println(line);

        if (line.startsWith("Content-Length:")) {
          contentLength = Integer.parseInt(line.replace("Content-Length: ", ""));
        }
        line = reader.readLine();
      }

      if (contentLength > 0) {
        char[] chars = new char[contentLength];
        reader.read(chars);
        String userStr = new String(chars);

        String data = "";
        if (path.equals("/server/user/login")) {
          User user = JSONObject.parseObject(userStr, User.class);
          System.out.println(user);
          Response response = new Response();
          response.setMsg("成功");
          data = JSONObject.toJSONString(response);
        } else if (path.equals("/server/user/list")) {
          List<User> users = JSONObject.parseArray(userStr, User.class);
          System.out.println(users);
          List<Response> responses = new ArrayList<>();
          responses.add(new Response("加油"));
          responses.add(new Response("加油"));
          responses.add(new Response("加油"));
          data = JSONObject.toJSONString(responses);
        }

        DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());

        dataOutputStream.writeBytes("HTTP/1.1 200 OK");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Length: " + data.getBytes().length);
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Type: application/json;charset=utf-8;");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(data.getBytes());

      }

      accept.close();
    }
  }
}
