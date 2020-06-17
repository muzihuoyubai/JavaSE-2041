package club.banyuan;

public class GuessNumberTest {

  public static void main(String[] args) {
    // int[] answer = new int[4];
    // GuessNumber.fillAnswer(answer);
    //
    // for (int i : answer) {
    //   System.out.println(i);
    // }

    // int[] userInput = new int[4];
    // GuessNumber.fillUserInput(userInput);
    // for (int i : userInput) {
    //   System.out.println(i);
    // }

    int[] userInput = {1,1,4,1};
    int[] answer = {2,1,3,4};
    GuessNumber.checkUserInput(userInput,answer);
  }
}
