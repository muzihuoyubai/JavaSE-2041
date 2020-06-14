### 1.
创建一个狗类

属性
-- String 品种
-- int 智商

方法
-- String getInfo  
返回  描述+品种，根据智商的值输出描述。（<20为傻， 20~80为普通的，>80为聪明的）例如 傻哈士奇，普通的柯基，聪明的金毛

-- printInfo
向控制台输出 getInfo 获取的内容

-- playWith(club.banyuan.cat.Cat)
向控制台输出 狗品种和猫品种一起玩， 例如哈士奇和波斯猫一起玩

### 2.
创建一个猫类

属性
-- String 品种
-- String 毛色

方法
-- String getInfo 
返回 毛色+品种， 例如白色波斯猫，黑色英短

-- print
向控制台输出 getInfo中的内容

-- playWith(Dog)
向控制台输出 猫类getInfo+狗类的getInfo 一起玩，例如 白色波斯猫和傻哈士奇一起玩， 黑色英短和普通的柯基一起玩

### 3.
编写一个测试类Main测试类的方法，分别创建以下几个对象，并且调用print和playWith查看输出结果

```
狗类对象
哈士奇  -100  
金毛  100
柯基  40

猫类对象
波斯  白色
英短  黑色
```

### 4.
将狗类放置到包路径club.banyuan.dog 路径下，狗类的全限定类名为 club.banyuan.dog.Dog

将猫类放置到包路径club.banyuan.cat 路径下，猫类的全限定类名为 club.banyuan.cat.club.banyuan.cat.Cat

将测试类放置到包路径club.banyuan.main 路径下，测试类的全限定类名为 club.banyuan.main.club.banyuan.main.Main

最后保证修改包路径后编译运行成功





