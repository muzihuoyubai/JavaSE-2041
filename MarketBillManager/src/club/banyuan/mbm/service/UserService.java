package club.banyuan.mbm.service;

import club.banyuan.mbm.entity.User;
import club.banyuan.mbm.exception.BadRequestException;
import club.banyuan.mbm.exception.FormPostException;
import club.banyuan.mbm.uti.PropUtil;
import club.banyuan.mbm.uti.ValidationUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

  // 用户密码，6-15位，数字字母下划线
  // 用户名，不能包含特殊字符 !@#$%^&*()
  // userType 必须是 0 或1
  private void validate(User user) {
    if (!user.getPwd().equals(user.getPwdConfirm())) {
      throw new FormPostException("密码不一致");
    }
    try {
      ValidationUtil.validate(user);
    } catch (Exception e) {
      throw new FormPostException(e.getMessage());
    }
    //
    // boolean matches = user.getPwd().matches("\\w{6,15}");
    // if (!matches) {
    //   throw new FormPostException("密码不规范");
    // }
    // boolean matches1 = user.getName().matches("[^!@#$%^&*()]");
    // if (!matches1) {
    //   throw new FormPostException("用户名不规范");
    // }
  }


  public User getUserById(String id) {
    for (User user : userList) {
      if (Integer.parseInt(id) == user.getId()) {
        return user;
      }
    }
    return null;
  }

  public User getUserById(int id) {
    for (User user : userList) {
      if (id == user.getId()) {
        return user;
      }
    }
    throw new BadRequestException("用户id" + id + "不存在");
  }

  // userList = {user1=1,user2=2,user3=3}
  public User getUserByIdRefine(String id) {

    // 将list中的数据查找，id匹配的数据
    List<User> collect = userList.stream().filter(new Predicate<User>() {

      @Override
      public boolean test(User user) { // user对象是在userList中的对象，userList中所有的对象依次被传入到此方法中
        // 返回true，保留该对象，返回false，过滤掉该对象
        return user.getId() == Integer.parseInt(id);
      }
      // 将过滤结果转换为一个新的list
    }).collect(Collectors.toList());

    List<User> collect1 = userList.stream().filter(user -> {
      return user.getId() == Integer.parseInt(id);
    }).collect(Collectors.toList());

    List<User> collect2 = userList.stream().filter(user -> user.getId() == Integer.parseInt(id))
        .collect(Collectors.toList());

    Optional<User> first = userList.stream().filter(user -> user.getId() == Integer.parseInt(id))
        .findFirst();

    // return first.orElse(null);

    if (first.isPresent()) {
      return first.get();
    }
    return null;

    // return collect.get(0);
  }

  public void updateUser(User user) {
    User userById = getUserById(user.getId());
    userById.setUserType(user.getUserType());
    userById.setName(user.getName());
    userById.setPwd(user.getPwd());
    userById.setPwdConfirm(user.getPwdConfirm());
  }
}
