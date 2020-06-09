/**
 * 数据运算演示
 *
 * @author www.banyuan.club
 */
public class RelationDemo {

  public static void main(String[] args) {

    // 关系运算符最后返回一个boolean类型
    System.out.println(5 >= 6); // false
    System.out.println(7 <= 8.3); // true
    System.out.println(3 != 4); // true
    System.out.println(true == false); // false
    System.out.println(1 == 1.1); // false
    System.out.println(3 == 3.0); // true

    // 引用数据类型进行比较
    String[] arr = new String[3];
    System.out.println(arr[0] == arr[1]); // null == null 返回结果为true
    // System.out.println(arr == arr[0]); // 编译报错，参与比较的引用数据类型必须一致
    System.out.println(arr[0]);
    System.out.println(arr[1]);

    String[][] arr1 = new String[3][3];
    System.out.println(arr1[0] == arr1[1]); // 两个对象地址比较，返回结果为false
    System.out.println(arr1[0]);
    System.out.println(arr1[1]);

    String[][] arr2 = arr1;
    System.out.println(arr2[0] == arr1[0]); // 返回结果为true
    System.out.println(arr1[0]);
    System.out.println(arr1[1]);

    // 逻辑运算符，参与的两个操作数是boolean类型，返回一个boolean类型
    System.out.println(true || false); // true
    System.out.println(true && false); // false
    System.out.println(!true); // false
    System.out.println(true ^ false); // true

    // 短路
    int a = 1;
    // 可以直接通过 && 左侧的false判断结果是false，右侧表达式不会进行计算
    boolean and = false && (++a > 1);
    System.out.println(and); // false
    System.out.println(a); // 1

    a = 1;
    // 不会出现短路的情况
    and = false & (++a > 1);
    System.out.println(and); // false
    System.out.println(a); // 2
  }
}
