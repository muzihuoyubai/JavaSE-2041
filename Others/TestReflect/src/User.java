import java.lang.reflect.Field;

public class User {

  private int id;
  @MyValidation(sameFiledWith = "pwdConfirm", regex = "test")
  private String name;
  private String pwd;
  private String pwdConfirm;
  private int userType;
  // 如果userType = 0，str = 普通用户
  // 如果userType = 1，str = 经理
  private String userTypeStr;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getPwdConfirm() {
    return pwdConfirm;
  }

  public void setPwdConfirm(String pwdConfirm) {
    this.pwdConfirm = pwdConfirm;
  }

  public int getUserType() {
    return userType;
  }

  public void setUserType(int userType) {
    this.userType = userType;
    if (userType == 0) {
      userTypeStr = "普通用户";
    } else if (userType == 1) {
      userTypeStr = "经理";
    }
  }

  public String getUserTypeStr() {
    return userTypeStr;
  }

  public void setUserTypeStr(String userTypeStr) {
    this.userTypeStr = userTypeStr;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", pwd='" + pwd + '\'' +
        ", pwdConfirm='" + pwdConfirm + '\'' +
        ", userType=" + userType +
        ", userTypeStr='" + userTypeStr + '\'' +
        '}';
  }

  public static void main(String[] args) {
    User user = new User();
    user.setId(1);
    user.setName("name");
    user.setPwd("pwd");
    user.setUserType(1);

    Class<? extends User> aClass = user.getClass();
    // 获取public的字段，包括父类继承到的public字段
    // Field[] fields = aClass.getFields();
    // 当前类所有的字段，包括private、protected的
    Field[] fields = aClass.getDeclaredFields();
    for (Field field : fields) {
      System.out.println("===========");
      // field.setAccessible(true);
      System.out.println(field.getName());
      System.out.println(field.getDeclaringClass());
      System.out.println(field.getType());
      System.out.println(field.getType() == int.class);
      System.out.println(field.getGenericType());
    }
  }
}
