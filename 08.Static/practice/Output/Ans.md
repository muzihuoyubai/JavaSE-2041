#### 1.以下代码的输出结果是

```
public class StaticDemo {

  int num1 = 6;
  static int num2 = 10;

  public static void main(String args[]) {
    StaticDemo s1 = new StaticDemo();
    StaticDemo s2 = new StaticDemo();
    s1.num1 = 15;
    s1.num2 = 17;
    s2.num1 = 22;
    s2.num2 = 28;
    System.out.println(s1.num1 + " " + s1.num2 + " " + s2.num1 + " " + s2.num2);
  }
}
```

```
A. 15 17 22 28
B. 15 17 22 17
C. 15 28 22 28
D. 22 17 22 28
E. 22 28 22 28
F. 编译错误
```

Ans: C

num2是静态变量，因此所有类的对象共享一个num2，后一个对象对num2的值进行了修改，其他对象.num2后结果也会发生变化  
num1是实例变量，因此每个对象都一个独立的存储区域，互相不影响。  
对于静态变量的使用，推荐使用`类名.`的方式，而不是`对象名.`的方式


#### 2.以下选项插入到代码片段中可以编译通过的是
```
public class Demo {

  final String exam1 = "O";
  static String exam2 = "C";
  String exam3 = "A";
  final String exam4;

  {
    // CODE SNIPPET 1
    //exam1 = "A"
    exam2 = "J";
    exam4 = "O"; // 编译通过，可以在这里对final变量内容进行第一次初始化
  }

  static {
    // CODE SNIPPET 2
    exam1 = "P"; // 编译错误 不能对final变量进行二次赋值
    exam3 = "B"; // 编译错误 不允许访问实例变量
    exam2 = "8";
  }
}
```

```
A. exam1 = "A"; // CODE SNIPPET 1
B. exam2 = "J"; // CODE SNIPPET 1
C. exam1 = "P"; // CODE SNIPPET 2
D. exam2 = "8"; // CODE SNIPPET 2
E. 编译错误
F. 运行错误
```

Ans: B  D  

final的成员变量只允许被赋值一次，要么出现在定义变量的时候进行初始化。要么出现在构造代码块中。并且必须要在对象创建的时候进行初始化。  
static的代码块中不允许出现实例成员或方法。可以用来给final static的成员进行初始化。

#### 3.以下代码的输出结果是

```
public class StaticDemo {

  static String n1 = examName("O");
  // String n3 = examName("S");
  // String n2 = examName1("I");
  // static String n4 = examName1("O"); // 不允许调用实例方法

  {
    n1 = examName("A");
  }

  static {
    n1 = examName("C");
  }

  public static void main(String[] args) {
    /*
    成员变量初始化的时候允许调用方法，静态变量初始化可以调用静态方法，实例变量初始化可以调用静态方法或实例方法
    实际上方法调用的语句，可以被认为是放置到代码块中，实例变量的初始化语句放到构造代码块中。静态变量的初始化语句放到静态代码块中。语句的先后顺序由代码编写顺序决定。
     */
    /*
    情况1，结果是 O C A
    加载类，对类的静态域内容进行初始化，静态变量，执行静态代码块的代码。静态初始化只会执行一次。
    创建对象，执行构造代码块中的代码，每次创建对象都会执行。
     */
    StaticDemo sd = new StaticDemo();

    /*
      情况2, O C T A ， 静态初始化只会执行一次。
     */
    // StaticDemo.examName("T");
    // StaticDemo sd = new StaticDemo();
  }

  public static String examName(String s) {
    System.out.println(s);
    return s;
  }

  public String examName1(String s) {
    System.out.println(s);
    return s;
  }
}
```
```
A. O C A
B. C A O
C. O A C
D. C A O
E. 编译错误
F. 运行错误
```

Ans: A

#### 4. 以下代码哪一行会编译错误
```
public class StaticDemo {
  StaticDemo sd = new StaticDemo();
  void method1() {
    method4();  // 1
    StaticDemo.method2(); // 2
    StaticDemo.method3(); // 3 // 不允许使用类名.的方式调用实例方法或实例变量
  }
  static void method2() {
  }
  void method3() {
    method1(); //4
    method2(); //5
    sd.method2(); //6
  }
  static void method4() {
  }
}
```
```
A. 1
B. 2
C. 3
D. 4
E. 5
F. 6
```

Ans：3


#### 5. 以下代码的输出结果是
```
public class StaticDemo {
  int num1 = 3;
  static int num2 = 5;
  StaticDemo(int num1, int num2) {
    if (num2 < 30) {
      this.num2 = num2;
    }
    num1 = num1;
  }

  public static void main(String[] args) {
    StaticDemo s1 = new StaticDemo(9, 10);
    // s1.num1 // 3
    // s1.num2 // 10
    StaticDemo s2 = new StaticDemo(12, 22);
    // s2.num1 // 3
    // s2.num2 // 22
    // s1.num2 // 22
    // StaticDemo.num2 // 22
    System.out.println(s1.num1 + " " + s1.num2 + " " + s2.num1 + " " + s2.num2);
  }
}
```
```
A. 9 10 12 22
B. 9 22 12 22
C. 9 10 12 10
D. 3 22 3 22
E. 编译错误
```

Ans: D

#### 6. 以下代码的输出结果是
```
class Test1 {

  int x = 10;

  public static void main(String[] args) {
    Test1 t1 = new Test1();
    Test1 t2 = new Test1();
    t1.x = 20;
    System.out.print(t1.x + " ");
    System.out.println(t2.x);
  }
} 
```
```
A. 10 10
B. 20 20
C. 10 20
D. 20 10
```

Ans: D

定义成员变量时对成员变量进行初始化，影响到每一个被创建出来的对象的值


#### 7. 以下代码的输出结果是
```
class Test1 {

  static int i = 1;

  public static void main(String[] args) {
    for (int i = 1; i < 10; i++) {
      i = i + 2;
      System.out.print(i + " ");
      // 不能使用this，如果想要使用 静态成员i，可以使用类名的方式进行引用
      // System.out.println(Test1.i);
    }
  }
} 
```
```
A. 3 6 9
B. 3 6 9 …. 27
C. 编译错误
D. 没有输出
```

Ans: A

#### 8. 以下代码的输出结果是
```
class Test1 {

  static int i = 1;

  public static void main(String[] args) {
    int i = 1;
    for (Test1.i = 1; Test1.i < 10; Test1.i++) {
      i = i + 2;
      System.out.print(i + " ");
    }
  }
} 
```
```
A. 1 3 9
B. 1 2 3 … 9
C. 3 5 7 9 11 13 15 17 19
D. 无输出
```

Ans: C

#### 9. 以下代码的输出结果是
```
class Test1 {

  static int i = 1;

  public static void main(String[] args) {
    static int i = 1;
    for (Test1.i = 1; Test1.i < 10; Test1.i++) {
      i = i + 2;
      System.out.print(i + " ");
    }
  }
} 
```
```
A. 编译报错
B. 1 3 9
C. 3 5 7 9 11 13 15 17 19
D. 1 2 3 … 9
```

Ans: A

static不允许出现在方法内部，仅用来修饰成员变量和方法


#### 10. 以下代码的输出结果是

```
class Test1 {

  public static void main(String[] args) {
    static int arr1[] = {11, 22, 33};
    static int arr2[] = {11, 22, 33, 44, 55};
    static int ptr[];
    ptr = arr1;
    arr1 = arr2;
    arr2 = ptr;
    System.out.print(arr1.length + " ");
    System.out.println(arr2.length);
  }
} 
```
```
A. 编译错误
B. 5 5
C. 5 3
D. 3 5
```

Ans: A

如果去掉static，编译通过，结果是两个数组的引用互换

#### 11. 以下代码的输出结果是

```
class Test1 {

  public static void main(String[] args) {
    int x = 20;
    System.out.println(x);
  }

  static {
    int x = 10; // 这里的x是局部变量，作用范围仅限在大括号的区域内
    System.out.print(x + " ");
  }
} 
```
```
A. 10 20
B. 20 10
C. 10 10
D. 20 20
```

Ans: A

#### 12. 以下代码的输出结果是
```
class Test1 {

  int x = 10;

  public static void main(String[] args) {
    System.out.println(x);
  }

  static {
    System.out.print(x + " ");
  }
} 
```
```
A. 10 10
B. 编译错误
C. 运行异常
D. 无输出
```

Ans: B

静态代码块中无法访问实例变量或方法(非静态)

#### 13. 以下代码的输出结果是
```
class Test1 {

    int x = 10;

    public
    static void main(String[] args) {
        Test1 t1 = new Test1();
        System.out.println(t1.x);
    }

    static {
        int x = 20;
        System.out.print(x + " "); 
    } 
} 
```
```
A. 10 20
B. 20 10
C. 10 10
D. 编译错误
```

Ans: B

#### 14. 以下代码的输出结果是

```
class Test1 {

  int x = 10;
  // 可以加static 让编译通过

  public static void main(String[] args) {
    System.out.println(Test1.x); // 编译错误，不能使用类名的方式访问实例成员
    // System.out.println(new Test1().x); // 可以创建一个对象，在使用实例成员
  }

  static {
    int x = 20;
    System.out.print(x + " ");
  }
} 
```
```
A. 10 10
B. 20 20
C. 20 10
D. 编译错误
```

#### 15. 以下代码的输出结果是
```
class Test1 {

  static int x = 10;

  public static void main(String[] args) {
    Test1 t1 = new Test1();
    Test1 t2 = new Test1();

    t1.x = 20;
    System.out.print(t1.x + " ");
    System.out.println(t2.x);
  }
} 
```
```
A. 10 10
B. 20 20
C. 10 20
D. 20 10
```

Ans: B

t1.x 和 t2.x 都是指的 Test1.x