import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo {

  public static void main(String[] args) throws ParseException {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    // String => Date
    // 年-月-日
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date parse = simpleDateFormat.parse(input);
    System.out.println(parse);
    Calendar instance = Calendar.getInstance();
    instance.setTime(parse);
    instance.add(Calendar.DAY_OF_MONTH, 10);
    Date newDate = instance.getTime();
    System.out.println(newDate);
    System.out.println(parse.compareTo(newDate));
  }
}
