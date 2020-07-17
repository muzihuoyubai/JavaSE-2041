public class User {

  private int id;
  @Validation(regex = "[^!@#$%^&*()]{3,10}")
  private String name;

  private int userType;
  private String pwd;
  private String pwdConfirm;
  // 如果userType = 0，str = 普通用户
  // 如果userType = 1，str = 经理
  private String userTypeStr;

  // public User(String test) {
    // this.id = id;
    // this.name = name;
    // this.userType = userType;
  // }

  // public User(String userTypeStr) {
  //   this.userTypeStr = userTypeStr;
  // }

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
        ", userType=" + userType +
        ", pwd='" + pwd + '\'' +
        ", pwdConfirm='" + pwdConfirm + '\'' +
        ", userTypeStr='" + userTypeStr + '\'' +
        '}';
  }
}
