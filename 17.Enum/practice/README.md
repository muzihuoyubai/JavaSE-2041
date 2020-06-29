#### 1.
使用MONDAY，TUESDAY ...直到星期日的常量创建一个公共枚举类Weekday。
枚举应具有实例方法boolean isWeekDay（）和实例方法boolean isHoliday（）。 
isHoliday（）方法应返回isWeekDay（）相反的值

编写一个程序演示如何使用此枚举，该程序具有一个以Weekday作为参数并根据Weekday是否为假日打印消息的方法。
我们建议main方法循环遍历Weekday枚举中的所有值，并将它们作为参数发送给该方法。
提示：Java中的每个枚举都有一个静态values（）方法，该方法返回枚举中值的数组，因此可以为此使用for-each-loop（增强的for循环）。
提示：每个枚举都有一个toString（）实现，该实现返回在枚举中声明的常量名称，可以重写该方法返回自定义的值例如“星期五”

#### 2.
声明一个Weekday sat = Weekday.SATURDAY。
在Weekday.values（）上使用一个带有day作为循环变量的循环，并使用 day.compareTo（sat）打印出每个值，以及它是否小于，等于或大于sat，
compareTo（）方法返回一个int，负值表示该枚举对象序号小于sat, 0表示相等，正值表示该枚举对象序号大于sat。