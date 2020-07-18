package club.banyuan;

import java.util.Scanner;

public class Number {

  private static final int SIZE = 4;
  private char[] value = new char[SIZE];

  public char[] getValue() {
    return value;
  }

  public void setValue(char[] value) {
    this.value = value;
  }

  public void fillAnswer() {
    char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    for (int i = 0; i < SIZE; i++) {
      int index = (int) (Math.random() * (numbers.length - i));
      value[i] = numbers[index];
      numbers[index] = numbers[numbers.length - i - 1];
    }
  }

  public void fillUserInput() {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    char[] chars = s.toCharArray();
    if (chars.length != SIZE) {
      System.out.println("输入不合法！");
      fillUserInput();
    } else {
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] >= '0' && chars[i] <= '9') {
          value[i] = chars[i];
        } else {
          System.out.println("输入不合法！");
          fillUserInput();
          break;
        }
      }
    }
  }

  private boolean isContains(char target) {
    return new String(value).contains(target + "");
  }

  public boolean checkUserInput(Number userInput) {
    int posCorrect = 0;
    int valueCorrect = 0;

    for (int i = 0; i < SIZE; i++) {
      if (value[i] == userInput.getValue()[i]) {
        posCorrect++;
        valueCorrect++;
      } else {
        if (userInput.isContains(value[i])) {
          valueCorrect++;
        }
      }
    }

    if (SIZE == posCorrect) {
      return true;
    }

    if (posCorrect == 0 && valueCorrect == 0) {
      System.out.println("没有数字正确");
    } else if (posCorrect == 0) {
      // 包含了1个正确的数字
      // 但是这些数字位置错误
      System.out.println("包含了" + valueCorrect + "个正确的数字");
      System.out.println("但是这些数字位置错误");
    } else {
      // 包含了1个正确的数字
      // 1个数字的位置正确
      System.out.println("包含了" + valueCorrect + "个正确的数字");
      System.out.println(posCorrect + "个数字的位置正确");
    }

    return false;
  }
}
