### 实现Product类具备以下属性和方法

属性
- name : String
- price : double
- scanCode : int
- num : int

方法
- 构造方法(String name,double price)
- String getName()
- int getScanCode()
- double getPrice()
- void changePrice(double)
- int getNum()
- void setNum(int)
- String getInfo()
- boolean buy(int)

ScanCode 是一个4位数字，首位数字不能为0，将在构造对象的时候自动生成，保证每一个Product对象的ScanCode是唯一的
buy 方法将num 减去传入的数字，如果传入数字较大表示库存不足，num不做修改则返回false，否则返回true

getInfo() 返回一个字符串如下
```
--- 产品信息 ---
名称: 手机
编码：1001
价格: 2001.00元
```

自己编写一个测试用的类，测试所有的方法功能正常