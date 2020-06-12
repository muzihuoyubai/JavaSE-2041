### 目的
掌握构造方法的使用方式

### 练习
在包路径`club.banyuan`下定义一个人类（Person），该类中有两个私有属性，姓名（name）和年龄（age）。
定义构造方法，用来初始化数据成员。再定义显示（speak）方法，将姓名和年龄打印出来。

在建立一个`class Main`用来测试代码，确保以下代码运行正常
```
Person person = new Person();
Person zhangsan = new Person("张三", 18);
Person lisi = new Person("李四");
```