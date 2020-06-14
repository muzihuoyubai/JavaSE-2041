/**
 * 以TODO标识新增的代码
 */
class Cal {

  /*
  TODO
  菜单中增加一项取余操作，因为退出的数字和数组长度一致，因此要将退出的菜单放到最后面
   */
  static String[] ROOT_MENU = {"要进行哪种运算？\n", "1.加法\n", "2.减法\n", "3.乘法\n", "4.除法\n", "5.取余\n",
      "6.退出\n"};

  static int ROOT_MENU_LEN = ROOT_MENU.length;

  // 流程状态枚举
  enum FlowStatus {
    ROOT, QUIT, OPT_ONE_INPUT, OPT_TWO_INPUT
  }

  // TODO 增加REM取余
  enum CalculateType {
    ADD, SUB, MUL, DIV, REM, NONE
  }

  public static void main(String[] args) {
    // 记录第一个操作数
    int calNumOne = 0;
    // 记录第二个操作数
    int calNumTwo = 0;
    // 记录用户输入的菜单选项
    int userInput = 0;
    // 记录当前的流程状态，是显示菜单选项还是用户输入
    FlowStatus flowStatus = FlowStatus.ROOT;
    // 记录用户选择的计算类型
    CalculateType calType = CalculateType.NONE;

    while (flowStatus != FlowStatus.QUIT) {
      switch (flowStatus) {
        case ROOT:
          displayRootMenu();
          userInput = scanInt();
          // 用户输入不合法
          if (userInput <= 0 || userInput > ROOT_MENU_LEN) {
            printf("不存在的选项！\n");
            // 用户输入的退出项，退出项是菜单数组中的最后一项
          } else if (userInput == ROOT_MENU_LEN - 1) {
            flowStatus = FlowStatus.QUIT;
          } else {
            calType = getCalType(userInput);
            flowStatus = FlowStatus.OPT_ONE_INPUT;
          }
          break;
        case OPT_ONE_INPUT:
          printf("请输入第一个操作数:");
          calNumOne = scanInt();
          flowStatus = FlowStatus.OPT_TWO_INPUT;
          break;
        case OPT_TWO_INPUT:
          printf("请输入第二个操作数:");
          calNumTwo = scanInt();
          // TODO 除法并且第二个操作数为0，提示错误，然后直接break，
          // 因为没有修改流程的枚举值，还会经过循环进入到这个分支来
          if (calType == CalculateType.DIV && calNumTwo == 0) {
            printf("输入错误，不能使用0作为除数！\n");
            break;
          }
          calculate(calType, calNumOne, calNumTwo);
          flowStatus = FlowStatus.ROOT;
          break;
        case QUIT:
          return;
      }
    }
  }

  /**
   * 重新封装了读取用户输入的函数
   *
   * @return
   */
  static public int scanInt() {
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String input = sc.nextLine();
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      printf("输入不合法，请重新输入\n");
      return scanInt();
    }
  }

  /**
   * 重新封装了输出函数
   *
   * @param format
   * @param args
   */
  static public void printf(String format, Object... args) {
    System.out.printf(format, args);
  }

  static void displayRootMenu() {
    for (int i = 0; i < ROOT_MENU_LEN; i++) {
      printf("%s", ROOT_MENU[i]);
    }
    printf("请输入：");
  }

  /**
   * 输出计算结果
   *
   * @param calType
   * @param calNumOne
   * @param calNumTwo
   */
  static void calculate(CalculateType calType, int calNumOne, int calNumTwo) {
    switch (calType) {
      case ADD:
        printf("%d + %d = %d\n", calNumOne, calNumTwo, calNumOne + calNumTwo);
        break;
      case SUB:
        printf("%d - %d = %d\n", calNumOne, calNumTwo, calNumOne - calNumTwo);
        break;
      case MUL:
        printf("%d * %d = %d\n", calNumOne, calNumTwo, calNumOne * calNumTwo);
        break;
      case DIV:
        printf("%d / %d = %.2f\n", calNumOne, calNumTwo, (calNumOne * 1.0) / calNumTwo);
        break;
      case REM:
        // TODO 两个%来转义，表示一个%
        printf("%d %% %d = %d\n", calNumOne, calNumTwo, calNumOne % calNumTwo);
        break;
      default:
        break;
    }
  }

  /**
   * 根据用户输入返回计算的类型
   *
   * @param userInput
   * @return
   */
  static CalculateType getCalType(int userInput) {
    switch (userInput) {
      case 1:
        return CalculateType.ADD;
      case 2:
        return CalculateType.SUB;
      case 3:
        return CalculateType.MUL;
      case 4:
        return CalculateType.DIV;
      // TODO 增加返回取余的枚举类型
      case 5:
        return CalculateType.REM;
      default:
        return CalculateType.NONE;
    }
  }
}
