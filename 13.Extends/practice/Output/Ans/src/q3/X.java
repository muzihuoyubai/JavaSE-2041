package q3;

class X
{
    // 增加无参的构造方法
    public X(int i)
    {
        System.out.println(1);
    }
}
 
class Y extends X
{
    public Y()
    {
        // 指定构造方法 super(10);
        System.out.println(2);
    }
    // 编译报错，父类中没有默认的无参构造方法
}