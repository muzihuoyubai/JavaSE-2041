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

Ans: 15 28 22 28

num2 是静态的，所有对象共享一个（不建议使用`对象名.`的方式，建议使用`类名.`的方式操作静态变量）。

#### 2.以下选项插入到代码片段中可以编译通过的是
```
public class Demo {

  final String exam1 = "O";
  static String exam2 = "C";

  {
    // CODE SNIPPET 1
  }

  static {
    // CODE SNIPPET 2
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

Ans:

A. 编译错误。不能对final修饰的变量重新赋值  
B. 编译通过。可以在构造代码块中对静态变量进行赋值  
C. 编译错误。不能对final修饰变量重新赋值，并且静态代码块中不能出现非静态的变量和方法
D. 编译通过。静态代码块中可以对静态变量进行赋值

#### 3.以下代码的输出结果是

```
public class StaticDemo {

  static String n1 = examName("O");

  {
    n1 = examName("A");
  }

  static {
    n1 = examName("C");
  }

  public static void main(String[] args) {
    StaticDemo sd = new StaticDemo();

  }

  public static String examName(String s) {
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

Ans:

A.   
可以在赋值的时候通过调用方法的方式进行赋值。对于静态成员变量，可以调用静态方法。对于实例成员变量，可以调用静态方法或实例方法  
调用方法的语句，可以认为被放置到了对应的代码块中（实例变量放到构造代码块中，静态变量放到静态代码块中），和代码块中代码的顺序，按照语句编写的顺序从上到下排列。  
静态代码块的语句最先被执行，执行发生的时间点是当前类第一次被加载（声明类的变量不会触发加载，而是需要new对象或者调用静态方法或成员的时候触发加载）的时候，并且只执行一次。  
构造代码块代码每次在对象创建的时候都会被执行。


#### 4. 以下代码哪一行会编译错误
```
public class StaticDemo {

  StaticDemo sd = new StaticDemo();

  void method1() {
    method4();  // 1
    StaticDemo.method2(); // 2
    StaticDemo.method3(); // 3

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

Ans: C

对于实例方法，不能使用类名的方式进行调用。


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

  public static void main(String args[]) {

    StaticDemo s1 = new StaticDemo(9, 10);
    StaticDemo s2 = new StaticDemo(12, 22);

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

Ans:D

#### 6. 以下代码的输出结果是
```
class Test1 { 
    int x = 10; 
public static void main(String[] args) 
    { 
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
#### 7. 以下代码的输出结果是
```
class Test1 { 
	static int i = 1; 
public static void main(String[] args) 
	{ 
		for (int i = 1; i < 10; i++) { 
			i = i + 2; 
			System.out.print(i + " "); 
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
#### 8. 以下代码的输出结果是
```
class Test1 { 
    static int i = 1; 
public static void main(String[] args) 
    { 
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
#### 9. 以下代码的输出结果是
```
class Test1 { 
    static int i = 1; 
public static void main(String[] args) 
    { 
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
#### 10. 以下代码的输出结果是

```
class Test1 { 
public static void main(String[] args) 
    { 
        static int arr1[] = { 11, 22, 33 }; 
        static int arr2[] = { 11, 22, 33, 44, 55 }; 
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
#### 11. 以下代码的输出结果是

```
class Test1 { 
public static void main(String[] args) { 
        int x = 20; 
        System.out.println(x); 
    } 
    static
    { 
        int x = 10; 
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
#### 12. 以下代码的输出结果是
```
class Test1 { 
    int x = 10; 
public
    static void main(String[] args) 
    { 
        System.out.println(x); 
    } 
    static
    { 
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
#### 13. 以下代码的输出结果是
```
class Test1 { 
    int x = 10; 
public
    static void main(String[] args) 
    { 
        Test1 t1 = new Test1(); 
        System.out.println(t1.x); 
    } 
    static
    { 
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
#### 14. 以下代码的输出结果是

```
class Test1 { 
    int x = 10; 
public
    static void main(String[] args) 
    { 
        System.out.println(Test1.x); 
    } 
    static
    { 
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
public
    static void main(String[] args) 
    { 
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