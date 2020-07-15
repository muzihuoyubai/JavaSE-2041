package club.banyuan.mbm.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlDecode {

  public static void main(String[] args) throws UnsupportedEncodingException {
    String s = "abcde1234";
    System.out.println(URLEncoder.encode(s,"utf-8"));

    String a = "阿道夫";
    String utfEncode = URLEncoder.encode(a, "utf-8");
    System.out.println(utfEncode);
    String gbk = URLEncoder.encode(a, "gbk");
    System.out.println(gbk);
    System.out.println(a);

    System.out.println(URLDecoder.decode(utfEncode,"gbk"));
    System.out.println(URLDecoder.decode(utfEncode,"utf-8"));


  }
}
