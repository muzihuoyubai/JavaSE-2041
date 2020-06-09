// TODO 自动将选中的学员名字加入到已选学员数组中
public class RandomStudents {

  public static final String[] studentNameArr = {
      "章添添", "冯晶晶", "贾旭辉", "袁林", "卞云鹏", "张旭东",
      "张巍岩", "万国榕", "李顽强", "杨坤", "张松怡", "孙明羽",
      "朱璋赟", "方启豪", "刘俊杰", "邵泽宇", "朱银生", "田文镐",
      "戴宇翔", "石欢程"
  };

  public static final String[] choosedNameArr = {};

  public static String[] generateUnchoosedNames() {
    String[] rlt = new String[studentNameArr.length - choosedNameArr.length];
    int index = 0;
    boolean isFind = false;
    for (int i = 0; i < studentNameArr.length; i++) {
      isFind = false;
      for (int j = 0; j < choosedNameArr.length; j++) {
        if (studentNameArr[i].equals(choosedNameArr[j])) {
          isFind = true;
          break;
        }
      }
      if (!isFind) {
        rlt[index++] = studentNameArr[i];
      }

    }
    return rlt;
  }

  public static void main(String[] args) {

    String[] unchosedStudentNames = generateUnchoosedNames();
    if (unchosedStudentNames.length == 0) {
      System.out.println("没有未被选择的学员，需要清空已选学员列表！");

    } else {
      int index = (int) (Math.random() * unchosedStudentNames.length);

      System.out.println("学生姓名:" + unchosedStudentNames[index]);
    }


  }


}