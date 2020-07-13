import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Demo {

  // String => 时间对象 方法
  // 时间对象 => String

  // 时区   0~24

  // UTC 1970-1-1 00:00:00
  // 2010-10-15 12:24:00 =>

  public static void main(String[] args) throws ParseException {
    // Date date = new Date();
    // date.getTime();
    // System.out.println(date);

    String str = "2020-7-32";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date parse = simpleDateFormat.parse(str);
    System.out.println(parse);
    System.out.println(parse.getTime());

    String str2 = "2020-7-2";
    Date parse1 = simpleDateFormat.parse(str2);
    // 比较两个日期的先后
    System.out.println(parse1.after(parse));
    System.out.println(parse1.before(parse));
    System.out.println(parse1.compareTo(parse));

    Calendar instance = Calendar.getInstance();
    Date time = instance.getTime();
    System.out.println(time);

    instance.setTime(parse1);
    System.out.println(instance.getTime());

    instance.add(Calendar.DAY_OF_MONTH, 1);
    System.out.println(instance.getTime());

    instance.add(Calendar.HOUR_OF_DAY, 1);
    System.out.println(instance.getTime());

    System.out.println(instance.get(Calendar.MONTH));
    System.out.println(instance.get(Calendar.YEAR));

    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");
    String format = simpleDateFormat1.format(instance.getTime());
    System.out.println(format);

    // SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA);
    // // Date parse1 = simpleDateFormat1.parse(str);
    // // System.out.println(parse1);
    // // System.out.println(parse1.getTime());
    //
    // // simpleDateFormat1.getCalendar().setTimeZone(TimeZone.getTimeZone());
    //
    // System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
    //
    Calendar africa1 = Calendar.getInstance(TimeZone.getTimeZone("Africa/Abidjan"));
    System.out.println(africa1);
    // System.out.println(africa1.getTimeZone());
    // Date africa = africa1.getTime();
    Calendar shanghai = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
    System.out.println(shanghai);
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    System.out.println(africa1);
    System.out.println(shanghai.getTime());
    // System.out.println(africa.getTime());
    // System.out.println(shanghai.getTime());
    //
    // System.out.println(TimeZone.getTimeZone("Africa/Abidjan"));

  }


}
