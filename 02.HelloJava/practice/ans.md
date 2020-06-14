## 练习答案和解析

1. 编译运行`Hello.java`，请记录打开终端开始到程序运行期间所有输入的终端命令

   ```shell
   # mac 下
   cd ~/projects/javase/HelloJava
   javac Hello.java
   java hello
   ```

   ```shell
   # windows 下
   d:
   cd d:\projects\javase\HelloJava
   javac Hello.java
   java hello
   ```

2. 将`HelloJava`目录下的`Hello.class`文件删除，编辑`Hello.java`将`class`后面的名称修改为`test`，然后编译`Hello.java`文件

   1. 生成的class文件名是什么

      生成test.class文件，说明编译后的文件名和文件内部class声明的名称一致

   2. 请尝试使用`java`运行编译后的文件，应该输入什么命令

      `java test`，说明java运行时传入的是class的名字

3. 保持上一题的状态，编辑Hello.java将class后面的名称修改为Test，然后编译Hello.java

   1. 是否生成新的class文件
   
      是否生成文件和操作系统有关，对于不区分路径大小写的操作系统(windows、MacOS)，则不生成，区分路径大小写的(Linux) 则生成

      `javac`编译传入的java文件，并且在java文件同级目录下生成class文件。对于编译生成出来的class文件，如果目录下有这个文件，就把编译后的内容进行覆盖，如果没有这个文件则创建和class同名的文件。

   2. 请尝试使用`java`运行编译后的文件，应该输入什么命令

      `java Test`，说明运行时java传入的是class的名字大小写必须和声明的一致，如果使用`java test`将报错找不到这个类`java.lang.NoClassDefFoundError`

   3. 将test.class 重命名为test1.class尝试运行，是否可以运行成功，如果不成功记录错误

      无法运行

      <pre>
      错误: 找不到或无法加载主类 test
      原因: java.lang.ClassNotFoundException: test
      </pre>

   4. 将test.class 重命名为TEST.class尝试运行，是否可以运行成功，如果不成功记录错误
      
      运行`java Test`，在大小写不敏感的操作系统下可以运行，否则不能运行。
        
4. 仿照`Hello.java`写一个`HelloWorld.java`, 其中class声明为`HelloWorld`，向屏幕输出`Hello World!`

   ```java
   class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello World!");
       }
   }
   ```

## 总结

`javac` 根据指定的文件名来编译文件，生成的class文件命名和文件内部定义的名称一致，生成class文件之前先到路径位置查找是否有相同名字的class文件，查找的时候在大小写不敏感的操作系统下不区分文件名大小写，在大小写敏感的操作系统下区分大小写。如果有这个文件，就把编译后的内容进行覆盖，如果没有这个文件则创建和class同名的文件。

`java` 命令启动虚拟机加载class文件，加载文件时，会根据传入java的名称在当前路径下找寻相同名称的class文件。如果对于某些操作系统不区分大小写，则查找文件名的时候也不区分大小写。相反，则需要严格匹配文件的大小写。

如果找不到文件，则会出现`java.lang.ClassNotFoundException`错误。

如果找到了文件，但是文件内部定义的class名称大小写和传入`java`的不匹配，则会出现`java.lang.NoClassDefFoundError`。