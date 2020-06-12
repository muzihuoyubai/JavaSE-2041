### 定义Time class

包含属性
- int hour
- int minute
- int second

包含方法

// 设置属性值
setTime(int aHour,int aMinute,int second)

// 返回 12:22:40 格式的字符串
String toString()

// 调用此方法会使得 second + 1，如果second达到了60 则分钟+1，如果分钟达到了60则小时+1，小时为24小时格式
nextSecond()