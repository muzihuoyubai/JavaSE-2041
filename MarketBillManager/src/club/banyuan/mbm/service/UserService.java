package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.User;
import club.banyuan.mbm.exception.FormPostException;
import club.banyuan.mbm.uti.PropUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  private static int userId;
  public static final String USER_STORE_PATH = "user.store.path";
  private static List<User> userList;

  static {
    load();
    userId = userList.size() + 1;
  }

  private static void load() {
    File file = new File(PropUtil.getProp(USER_STORE_PATH));
    if (file.exists()) {
      try (FileInputStream fileInputStream = new FileInputStream(file)) {
        byte[] bytes = fileInputStream.readAllBytes();
        userList = JSONObject.parseArray(new String(bytes), User.class);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.err.println("用户文件不存在");
      userList = new ArrayList<>();
    }
  }

  private static void save() {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        PropUtil.getProp(USER_STORE_PATH))) {
      // userList 对象转成 JSON格式的字符串
      // 如果是List对象，转换出来的格式 [{prop:value},{prop:value}]
      String jsonStr = JSONObject.toJSONString(userList);
      byte[] bytes = jsonStr.getBytes();
      fileOutputStream.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 在userlist中查找用户名和密码一致的user对象
   *
   * @param username
   * @param pwd
   * @return
   */
  public User login(String username, String pwd) {
    for (User user : userList) {
      if (user.getName().equals(username) && user.getPwd().equals(pwd)) {
        return user;
      }
    }

    return null;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    UserService.userList = userList;
  }

  public static void main(String[] args) {
    userList = new ArrayList<>();
    User u1 = new User();
    u1.setName("u1");
    u1.setPwd("123456");
    u1.setUserType(1);

    User u2 = new User();
    u2.setName("u2");
    u2.setPwd("123456");
    u2.setUserType(0);
    userList.add(u1);
    userList.add(u2);

    save();
  }

  public void addUser(User user) {
    validate(user);

    user.setId(userId++);
    userList.add(user);
    save();
  }

  private void validate(User user) {
    if (!user.getPwd().equals(user.getPwdConfirm())) {
      throw new FormPostException("密码不一致");
    }
  }
}
