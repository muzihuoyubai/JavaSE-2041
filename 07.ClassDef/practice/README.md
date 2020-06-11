class Dog {
    String type;
    int iq;
    void print() {
        System.out.println();
    }
    
    public static void main(String[] args){
        Dog one = new Dog();
        one.type = "哈士奇";
        one.iq = -100;
        one.print();
        }
}

class Animal {
    String type;
    String color;
    String iq;
}

狗
属性
哈士奇  -100  
金毛  100
柯基  40
方法
print
类型 :  < 20 傻    20 ~ 80 还可以  80 + 聪明

class Cat {
    String type;
    String color;
}
猫
波斯  白色
英短  黑色
方法
print
白色的波斯
黑色的英短


设计类的时候考虑数据的关联关系
方法定义语法 需要加括号
sublime保存的时候保存为.java后缀获取语法高亮
main方法定义在class的大括号中

调用方法的时候传入自身

方法位置，必须要放到类的大括号中，不能放到其他方法内部，不能放到类的外部


猫 club.banyuan.cat.Cat

playWith(Dog dog)
print
System.out.println("和狗一起玩")
dog.prinf

狗 club.banyuan.dog.Dog
playWith(Cat cat)
printf
System.out.println("和猫一起玩")
cat.print

Main
club.banyuan.main.Main





