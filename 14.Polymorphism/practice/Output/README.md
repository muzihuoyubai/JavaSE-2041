### 以下程序的输出结果是
#### 1.
```
class Base {
    final public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
```

#### 2.
```
class Base {
    public static void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public static void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
```

#### 3.
```
class Base {
    public void Print() {
        System.out.println("Base");
    }         
}
 
class Derived extends Base {    
    public void Print() {
        System.out.println("Derived");
    }
}
 
class Main{
    public static void DoPrint( Base o ) {
        o.Print();   
    }
    public static void main(String[] args) {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
    }
}
```

#### 4.

```
class Base {
    public void foo() { System.out.println("Base"); }
}
  
class Derived extends Base {
    private void foo() { System.out.println("Derived"); } 
}
  
public class Main {
    public static void main(String args[]) {
        Base b = new Derived();
        b.foo();
    }
} 
```

#### 5.

```
class Base {
    public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
public class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
```

#### 6.
```
class A
{
    int i = 10;
}
 
class B extends A
{
    int i = 20;
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new B();
 
        System.out.println(a.i);
    }
}
```

#### 7.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getData(); 
    } 
} 
```

#### 8.
```
class Test 
{ 
    void myMethod() 
    { 
        System.out.println("Test");
    } 
} 
class Derived extends Test
{ 
    void myMethod() 
    { 
        System.out.println("Derived");
    } 
      
    public static void main(String[] args) 
    { 
        Derived object = new Test(); 
        object.myMethod(); 
    } 
} 
```
#### 9.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
      
    protected void getValue() 
    { 
        System.out.println("ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getValue(); 
    } 
} 
```