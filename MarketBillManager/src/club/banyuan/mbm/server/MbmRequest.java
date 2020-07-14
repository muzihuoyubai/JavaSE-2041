package club.banyuan.mbm.server;

public class MbmRequest {

  private String method;
  private String path;
  private String host;

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
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
}
