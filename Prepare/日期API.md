## Date Time API

| `System.currentTimeMillis()` | 一个静态方法，返回自1970年1月1日以来的当前日期和时间(以毫秒为单位) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `java.util.Date` | 表示日期和时间的类。该类中的大多数方法都已不赞成使用。 |
| `java.sql.Date` | 表示日期的类。不表示时、分、秒信息。这个date类用于操作数据库数据。 |
| `java.sql.Timestamp` |表示日期和时间的类。这个日期和时间类用于操作数据库数据。 |
| `java.util.Calendar` | 日历类的基类。具有执行日期和时间计算的方法，如将一天或一个月添加到另一个日期上。 |
| `java.util.TimeZone` | Java TimeZone类是一个表示时区的类，在跨时区进行日历计算时非常有用。 |
| `java.text.SimpleDateFormat` | 这个类可以帮助将字符串解析为日期，并将日期格式化为字符串。 |



So, which of all these classes should you use? Well, that depends on what you are trying to do.

If you need to do simple timing the `System.currentTimeMillis()` method will do just fine.

If you just need an object to hold a date, for instance as a property in a simple domain model object, you can use the `java.util.Date` class.

If you need to read and write the date and time to a database, use the `java.sql.Date` and `java.sql.Timestamp` classes.

If you need to do date calculations like adding days or months to another date, or check what weekday (monday, tuesday etc.) a given date is, or convert dates and times between time zones, use the `java.util.Calendar` and `java.util.GregorianCalendar` classes.

Here is a list of the texts in this Java date and time tutorial. This list also available in the upper right side of all pages, so you can easily navigate between them.



## Time Granularity

The granularity of the `System.currentTimeMillis()` method is larger than 1 millisecond. If you call this method repeatedly, you will see that you get the same value back for a while, then it all of a sudden jumps by 10-20-30 milliseconds or more. It is not the worlds most precise or fine grained timer.



# System.nanoTime与System.currentTimeMillis比较

- currentTimeMillis返回的是系统当前时间和1970-01-01之前间隔时间的毫秒数，如果系统时间固定则方法返回值也是一定的（这么说是为了强调和nanoTime的区别），精确度是毫秒级别的
- nanoTime的返回值本身则没有什么意义，因为它基于的时间点是随机的，甚至可能是一个未来的时间，所以返回值可能为负数。但是其精确度为纳秒，相对高了不少。
- currentTimeMillis不仅可以用来计算代码执行消耗的时间 ，也可以和Date类方便的转换。而nanoTime则不行
- 可以这么说吧，currentTimeMillis是一个时钟，而nanoTime是一个计时器，你可以用时钟来计算时间差，也可以用来单纯的看时间，但是作为计时器的nanoTime则只能用来计算时间差，好在优点是精确度高
- currentTimeMillis是基于系统时间的，也就是说如果你再程序执行期间更改了系统时间则结果就会出错，而nanoTime是基于CPU的时间片来计算时间的，无法人为干扰
- 前面说了nanoTime基于的时间点是随机的，但是对于同一个JVM里，不同地方使用到的基点时间是一样的





Measuring time in Java is easiest to do with the [`System.currentTimeMillis()`](http://tutorials.jenkov.com/java-date-time/system-currenttimemillis.html) method.

What you do is that you get the time before and after the operation you want to measure, and calculate the time difference. Here is an example:

```
long startTime = System.currentTimeMillis();

callOperationToTime();

long endTime   = System.currentTimeMillis();

long totalTime = endTime - startTime;
```

The variable `totalTime` will now contain the total time it took to execute the `callOperationToTime()` method.



## 时间量测

## Repeat the Operation

Because `System.currentTimeMillis()` does not return the time that accurately, it is a good idea to execute the operation to measure more than once. Perhaps 10, 100 or 1.000 times. Maybe even more. That way inaccuracy caused by large grained time values (values that does not change every millisecond) is leveled out.

Another good reason to repeat the operation to measure a lot of times is to allow the Java virtual machine to load the classes containing the code, JIT-compile it, and perhaps even optimize it.



## A Timer class

The calculations listed earlier in this text are rather trivial yet tedious to do, and could be encapsulated in a `Timer` class. Here is a sketch:

```
public class Timer {

  private long startTime = 0;
  private long endTime   = 0;

  public void start(){
    this.startTime = System.currentTimeMillis();
  }

  public void end() {
    this.endTime   = System.currentTimeMillis();  
  }

  public long getStartTime() {
    return this.startTime;
  }

  public long getEndTime() {
    return this.endTime;
  }

  public long getTotalTime() {
    return this.endTime - this.startTime;
  }
}
```

Here is an example of how to use it:

```
Timer timer = new Timer();

timer.start();

callOperationToTime();

timer.end();

long totalTime = timer.getTotalTime();
```



Java's `java.util.Date` class was one of Java's first date classes. Today most of the methods in the class are deprecated in favor of the [`java.util.Calendar`](http://tutorials.jenkov.com/java-date-time/java-util-calendar.html) class. You can still use the `java.util.Date` class to represent a date though.

Here is how to instantiate a `java.util.Date` instance:

```
java.util.Date date = new java.util.Date();
```

This `Date` instance contains the current time as its date and time.

You can access the date and time contained in a `java.util.Date` instance using the `getTime()` method, like this:

```
java.util.Date date = new java.util.Date();

long time = date.getTime();
```

You can also create a `java.util.Date` from a time in milliseconds, like this:

```
long now = System.currentTimeMillis();

java.util.Date date = new java.util.Date(now);
```



## Comparing Dates

You can compare `java.util.Date` instance because the class implements the `java.lang.Comparable` interface. Here is how:

```
java.util.Date date1 = new java.util.Date();
java.util.Date date2 = new java.util.Date();

int comparison = date1.compareTo(date2);
```

The comparison follows the rules for the `Comparable` interface, meaning the `compareTo()` method returns:

- An int larger than 0 if the date the method is called on is later than the date given as parameter.
- An int value of 0 if the dates are equal.
- An int value less than 0 if the date the method is called on is earlier than the date given as parameter.

`java.util.Date` also has two shortcut methods to do comparisons. These are `before()` and `after()` methods. Here are two examples of how to use them:

```
java.util.Date date1 = new java.util.Date();
java.util.Date date2 = new java.util.Date();

boolean isBefore = date1.before(date2);
boolean isAfter  = date1.after (date2);
```



## Getting the Year, Month, Day of Month, Hour etc.

The methods to get the year, month, day of month, hour etc. are deprecated. Apparently the algorithms used internally were not entirely correct.

If you need to get or set the year, month, day of month etc. use a [`java.util.Calendar`](http://tutorials.jenkov.com/java-date-time/calendar.html) instead.





## 操作数据库的时间类

Java's `java.sql.Date` class is used in the JDBC API. If you need to set a date on a `java.sql.PreparedStatement` or get a date from a `java.sql.ResultSet`, you will interact with `java.sql.Date`.

Actually, `java.sql.Date` extends [`java.util.Date`](http://tutorials.jenkov.com/java-date-time/java-util-date.html), so anything you can do with a `java.util.Date` you can also do with a `java.sql.Date`. Check out [`java.util.Date`](http://tutorials.jenkov.com/java-date-time/java-util-date.html) for more details.

Here is how to instantiate a `java.sql.Date`

```
long time = System.currentTimeMillis();
java.sql.Date date = new java.sql.Date(time);
```

The biggest difference between `java.sql.Date` and `java.util.Date` is that the `java.sql.Date` only keeps the date, not the time, of the date it represents. So, for instance, if you create a `java.sql.Date` using the date and time `2009-12-24 23:20`, then the time (`23:20`) would be cut off. If you need to keep the time, use a [`java.sql.Timestamp`](http://tutorials.jenkov.com/java-date-time/java-sql-timestamp.html) instead.



Java's `java.sql.Timestamp` class is used in the JDBC API. If you need to set a date + time on a `java.sql.PreparedStatement` or get a date + time from a `java.sql.ResultSet`, you will interact with `java.sql.Timestamp`.

Actually, `java.sql.Timestamp` extends [`java.util.Date`](http://tutorials.jenkov.com/java-date-time/java-util-date.html), so anything you can do with a `java.util.Date` you can also do with a `java.sql.Timestamp`. Check out [`java.util.Date`](http://tutorials.jenkov.com/java-date-time/java-util-date.html) for more details.

The biggest difference between `java.sql.Date` and `java.sql.Timestamp` is that the `java.sql.Date` only keeps the date, not the time, of the date it represents. So, for instance, if you create a `java.sql.Date` using the date and time `2009-12-24 23:20`, then the time (`23:20`) would be cut off. If you use a `java.sql.Timestamp` then the time is kept.

## Nanoseconds

One difference in the `java.sql.Timestamp` from its superclass `java.util.Date` is its ability to hold the nanoseconds of a date too. You can get and set the nanoseconds using the `getNanos()` and `setNanos()`. Here is how:

```
long time = System.currentTimeMillis();
java.sql.Timestamp timestamp = new java.sql.Timestamp(time);

timestamp.setNanos(123456);
int nanos = timestamp.getNanos(); // nanos = 123456
```



# Calendar

Java's `java.util.Calendar` class is used to do date and time arithmetic. Whenever you have something slightly more advanced than just representing a date and time, this is the class to use.

The `java.util.Calendar` class is abstract, meaning you cannot instantiate it. The reason is that there are more than one calendar in the world. For instance, the Arab calendar uses a different year as year 0 than the Gregorian calendar used by most western countries.



## Instantiating a GregorianCalendar

Java only comes with a Gregorian calendar implementation, the `java.util.GregorianCalendar` class. Here is how you instantiate a `GregorianCalendar`:

```
Calendar calendar = new GregorianCalendar();
```

A new `GregorianCalendar` has the date and time set to "now", meaning the date and time it was created.



## Accessing Year, Month, Day etc.

The `Calendar` class has a couple of methods you can use to access the year, month, day, hour, minutes, seconds, milliseconds and time zone of a given date. Here are a few examples showing how that is done:

```
Calendar calendar = new GregorianCalendar();

int year       = calendar.get(Calendar.YEAR);
int month      = calendar.get(Calendar.MONTH); 
int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
int minute     = calendar.get(Calendar.MINUTE);
int second     = calendar.get(Calendar.SECOND);
int millisecond= calendar.get(Calendar.MILLISECOND);
```

There are a few more fields that you can access, like `DAY_OF_WEEK_IN_MONTH` and `AM_PM` which are not used so often. Check out the official JavaDoc to learn more about those fields.

The `Calendar` class has a corresponding `set()` method so you can set these fields too. Here is how that looks:

```
Calendar calendar = new GregorianCalendar();

calendar.set(Calendar.YEAR, 2009);
calendar.set(Calendar.MONTH, 11); // 11 = december
calendar.set(Calendar.DAY_OF_MONTH, 24); // christmas eve

etc.
```



## Adding and Subtracting to Year, Month, Day etc.

You can also add to these fields and have the `Calendar` instance update itself correctly. Look at this example:

```
Calendar calendar = new GregorianCalendar();

//set date to last day of 2009
calendar.set(Calendar.YEAR, 2009);
calendar.set(Calendar.MONTH, 11); // 11 = december
calendar.set(Calendar.DAY_OF_MONTH, 31); // new years eve

//add one day
calendar.add(Calendar.DAY_OF_MONTH, 1);

//date is now jan. 1st 2010
int year       = calendar.get(Calendar.YEAR);  // now 2010
int month      = calendar.get(Calendar.MONTH); // now 0 (Jan = 0)
int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // now 1
```

The `add()` method is really handy when doing date arithmetics like adding or subtracting years, months, days, hours etc. from a given date.

To subtract from the fields call the `add()` method with negative values, like this:

```
calendar.add(Calendar.DAY_OF_MONTH, -1);
```



## Traps and Pitfalls

There are a few minor traps in the `Calendar` class that you should be aware of to avoid unnecessary headaches. I'll cover those in the following sections.



### The Month Trap

The `MONTH` field of the `Calendar` class does not go from 1 to 12 like they do when we write dates otherwise. Instead the months run from 0 to 11, where 0 is January and 11 is December. This can cause a bit of errors and subsequent debugging if you are not aware of this.



### The Day of Week Trap

The day of week runs from 1 to 7 as you might expect, but sunday, not monday is the first day of the week. That means that 1 = sunday, 2 = monday, ..., 7 = saturday. This has also caused me minor annoyances from time to time.



## More Detail in the JavaDoc

If you need to do heavy or complex date and time calculations it is a good idea to read the class documentation for `java.util.Calendar` in the official JavaDoc's. The class documentation contains more detail about the specific behaviour of the class. For instance if you set the date to Jan. 34th 2009, what will the real date be?



# TimeZone

The Java TimeZone class is a class that represents time zones, and is helpful when doing calendar arithmetics across time zones. The `java.util.TimeZone` class is used in conjunction with the [`java.util.Calendar`](http://tutorials.jenkov.com/java-date-time/java-util-calendar.html) class.

Note: In the Java 8 date time API the time zones are represented by the `java.time.ZoneId` class. But you only need to use the `ZoneId` class if you are using the Java 8 date time classes (like the [`ZonedDateTime` class](http://tutorials.jenkov.com/java-date-time/zoneddatetime.html)). If you use a `Calendar` (from the Java 7 and earlier date time API) you can still use the `java.util.TimeZone` class.



## Obtaining a TimeZone from a Calendar

Here is a simple example of how you can get the `TimeZone` from a `Calendar`:

```
Calendar calendar = new GregorianCalendar();
TimeZone timeZone = calendar.getTimeZone();
```

And here is how you can set it:

```
calendar.setTimeZone(timeZone);
```



## Creating a TimeZone Instance

There are two ways to obtain a `TimeZone` instance:

```
TimeZone timeZone = TimeZone.getDefault();

TimeZone timeZone = TimeZone.getTimeZone("Europe/Copenhagen");
```

The first method (`TimeZone.getDefault()`) returns the default time zone for the system (computer) this program is running on.

The second method (`TimeZone.getTimeZone("Europe/Copenhagen")`) returns the `TimeZone` corresponding to the given time zone ID (in this example "Europe/Copenhagen"). There is a list of available time zone ID's at the end of this text.



## Time Zone Names, ID's and Offsets

You can see the display name, ID and time offset of a given time zone like this:

```
timeZone.getDisplayName();
timeZone.getID();
timeZone.getOffset( System.currentTimeMillis() );
```

The `getOffset()` method returns the offset in milliseconds for the given time zone to UTC, at the given time. For instance, the "Europe/Copenhagen" time zone may have one hour offset during the winter, and two hours during the summer time due to daylight savings.



## Converting Between Time Zones

You can covert the date and time in a `Calendar` between different time zones. Here is an example of how to do this:

```
TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");
TimeZone timeZone2 = TimeZone.getTimeZone("Europe/Copenhagen");

Calendar calendar = new GregorianCalendar();

long timeCPH = calendar.getTimeInMillis();
System.out.println("timeCPH  = " + timeCPH);
System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));

calendar.setTimeZone(timeZone1);

long timeLA = calendar.getTimeInMillis();
System.out.println("timeLA   = " + timeLA);
System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));
```

This example prints out this:

```
timeHere = 1264881305341
hour     = 20
timeLA   = 1264881305341
hour     = 11
```

Notice how the time in milliseconds is the same with both time zones, but that the hour of day has changed from 20 to 11. There is a 9 hour time difference between Copenhagen and LA. Copenhagen is 9 hours ahead of LA. The `Calendar` class is capable of converting the date and time between time zones.



## Available Time Zones

Here is a list of the available time zone ids in the `TimeZone` class, printed as returned by `TimeZone.getAvailableIDs()`.



It is possible to both parse dates from strings, and format dates to strings, using Java's `java.text.SimpleDateFormat` class. I have covered `SimpleDateFormat` in more detail in my [Java Internationalization](http://tutorials.jenkov.com/java-internationalization/index.html) tutorial, in the text [SimpleDateFormat](http://tutorials.jenkov.com/java-internationalization/simpledateformat.html).

It is also possible to parse and format dates using the newer [Java DateTimeFormatter](http://tutorials.jenkov.com/java-date-time/datetimeformatter.html) which is able to parse and format dates from and to the newer date time classes added in Java 8.

Even though both classes for parsing and formatting dates are covered in more detail in their own texts, I will show you a few examples of how to use them below.



## SimpleDateFormat Example

Here is an example of how to format and parse a date using the `SimpleDateFormat` class. The `SimpleDateFormat` class works on `java.util.Date` instances. Here are two simple examples:

```
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

String dateString = format.format( new Date()   );
Date   date       = format.parse ( "2009-12-31" );    
```

The string passed as parameter to the `SimpleDateFormat` class is a pattern that tells how the instance is to parse and format dates. In the example above I used the pattern "yyyy-MM-dd" which means 4 digits for the year (yyyy), two digits for month (MM) and two digits for day(dd). The digit groups are separated by dashes (-) because I specified that in the pattern too, between the digit groups.

Below is a list of the most common pattern letters you can use. For a full list, see the official JavaDoc for the `SimpleDateFormat` class.

```
y   = year   (yy or yyyy)
M   = month  (MM)
d   = day in month (dd)
h   = hour (0-12)  (hh)
H   = hour (0-23)  (HH)
m   = minute in hour (mm)
s   = seconds (ss)
S   = milliseconds (SSS)
z   = time zone  text        (e.g. Pacific Standard Time...)
Z   = time zone, time offset (e.g. -0800)
```

Here are a few pattern examples, with examples of how each pattern would format or expect to parse a date:

```
yyyy-MM-dd           (2009-12-31)

dd-MM-YYYY           (31-12-2009)
    
yyyy-MM-dd HH:mm:ss  (2009-12-31 23:59:59)

HH:mm:ss.SSS         (23:59.59.999)

yyyy-MM-dd HH:mm:ss.SSS   (2009-12-31 23:59:59.999)

yyyy-MM-dd HH:mm:ss.SSS Z   (2009-12-31 23:59:59.999 +0100)        
```



## DateTimeFormatter Example

Another way to format dates is to use the `DateTimeFormatter` which works with the newer date time classes added in Java 8. Here is a `DateTimeFormatter` example of formatting a date as a string:

```
DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

String formattedDate = formatter.format(LocalDate.now());
System.out.println(formattedDate);
```

As you can see, the `DateTimeFormatter` has a few predefined instances you can use. In the example above we use the `DateTimeFormatter.BASIC_ISO_DATE` instance which is configured to parse and format dates using the ISO date time format.