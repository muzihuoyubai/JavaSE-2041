package club.banyuan.mbm.server;

import club.banyuan.mbm.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MbmRequest {

  private String method;
  private String path;
  private String host;
  private int contentLength;
  private String payload;

  static MbmRequest parse(BufferedReader bufferedReader) throws IOException {
    String line = bufferedReader.readLine();
    if (line == null) {
      return null;
    }

    StringTokenizer tokenizer = new StringTokenizer(line);
    MbmRequest mbmRequest = new MbmRequest();
    mbmRequest.setMethod(tokenizer.nextToken());
    mbmRequest.setPath(tokenizer.nextToken());

    while (line != null && line.length() != 0) {

      if (line.startsWith("Content-Length:")) {
        mbmRequest.setContentLength(Integer.parseInt(line.replace("Content-Length: ", "")));
      } else if (line.startsWith("Host:")) {
        mbmRequest.setHost(line.replace("Host: ", ""));
      }
      line = bufferedReader.readLine();
    }

    if (mbmRequest.getContentLength() > 0) {
      char[] buf = new char[mbmRequest.getContentLength()];
      bufferedReader.read(buf, 0, buf.length);
      mbmRequest.setPayload(new String(buf));
    }

    return mbmRequest;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public int getContentLength() {
    return contentLength;
  }

  public void setContentLength(int contentLength) {
    this.contentLength = contentLength;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPath() {
    return path;
  }

  // 处理get请求的路径，将路径后面的信息，保存到payload里面，将路径?后面的内容全部截取掉
  // path.html?name=1&pwd=2
  public void setPath(String path) {
    if (method.equals("GET") && path.contains("?")) {
      String[] split = path.split("\\?");
      this.path = split[0];
      payload = split[1];
    } else {
      this.path = path;
    }
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  @Override
  public String toString() {
    return "MbmRequest{" +
        "method='" + method + '\'' +
        ", path='" + path + '\'' +
        ", host='" + host + '\'' +
        '}';
  }

  // payload = name=123&pwd=123
  // name  123   pwd  123
  public Map<String, String> getFormData() {
    StringTokenizer stringTokenizer = new StringTokenizer(payload, "&|=");
    Map<String, String> rlt = new HashMap<>();
    while (stringTokenizer.hasMoreTokens()) {
      rlt.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }
    return rlt;
  }

  // public <T> T getFormData(Class<T> cls) {
  //
  // }
}
