package club.banyuan;

import java.util.Scanner;

public class GuessNumber {

  public static void fillAnswer(int[] answer) {
    if (answer.length > 10) {
      return;
    }
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    for (int i = 0; i < answer.length; i++) {
      int index = (int) (Math.random() * (numbers.length - i));
      answer[i] = numbers[index];
      numbers[index] = numbers[numbers.length - i - 1];
    }
  }

  public static void main(String[] args) {
    int[] answer = new int[4];
    int[] userInput = new int[4];
    fillAnswer(answer);
    System.out.println("猜一猜4个不重复的数字，请输入4个数字：  ");
    while (true) {
      fillUserInput(userInput);
      boolean isSuccess = checkUserInput(userInput, answer);
      if (isSuccess) {
        System.out.println("回答正确");
        break;
      } else {
        System.out.println("请输入4个数字：");
      }
    }


  }

  public static boolean checkUserInput(int[] userInput, int[] answer) {
    if (userInput.length != answer.length) {
      return false;
    }
    int posCorrect = 0;
    int valueCorrect = 0;

    for (int i = 0; i < answer.length; i++) {
      if (answer[i] == userInput[i]) {
        posCorrect++;
        valueCorrect++;
      } else {
        if (toString(userInput).contains(answer[i] + "")) {
          valueCorrect++;
        }
      }
    }

    if (answer.length == posCorrect) {
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

  public static String toString(int[] target) {
    String rlt = "";
    for (int i : target) {
      rlt += i;
    }
    return rlt;
  }

  public static void fillUserInput(int[] userInput) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    char[] chars = s.toCharArray();
    if (chars.length != userInput.length) {
      System.out.println("输入不合法！");
      fillUserInput(userInput);
    } else {
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] >= '0' && chars[i] <= '9') {
          userInput[i] = chars[i] - '0';
        } else {
          System.out.println("输入不合法！");
          fillUserInput(userInput);
          break;
        }
      }
    }
  }


}
