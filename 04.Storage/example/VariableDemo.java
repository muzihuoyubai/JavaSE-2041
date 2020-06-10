/**
 * 变量的演示
 *
 * @author www.banyuan.club
 */
public class VariableDemo {

  public static void main(String[] args) {

    /*
     * 命名规范
     */
    // 可以使用部分unicode码作为变量名，建议还是使用英文字符和数字
    int 变量名可以是中文 = 123;
    System.out.println(变量名可以是中文);

    // 变量开头不能使用数字
    // int 2a; // 编译报错

    // 建议使用驼峰命名法命名变量，使用名词来命名变量
    String variableName = "驼峰命名的变量";

    /*
     * 变量使用之前需要初始化
     */
    /*
    // 编译报错，变量未经初始化即使用
    char c;
    System.out.println(c); // 编译报错
    */

    /*
    // 编译器没有办法做出正确的判断，判断foo变量是否被初始化，必须在所有分支中对变量进行赋值
    int foo;
    boolean condition = true;
    if (condition) {
      foo = 12;
    }
    System.out.println(foo); // 编译报错 Variable 'foo' might not have been initialized
    */

    /*
     * 常量
     */
    // 使用final修饰，标识定义一个常量，一旦被赋值之后，其内容就不能被修改
    final int finalInt = 12;
    // finalInt = 3; // 编译报错，不能够修改final的变量值

    // 可以先定义final变量，之后再赋值
    final int finalInt2;
    finalInt2 = 10;  // 编译通过
    // finalInt2 = 12;  // 再次赋值，编译报错
  }
}
