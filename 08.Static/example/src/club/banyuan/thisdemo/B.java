package club.banyuan.thisdemo;

/*
this 可以被当做对象类使用，可以作为方法返回值，可以使用此特性设计链式调用的方法
*/
public class B {

    private String prop;
    private String title;

    public B setProp(String prop) {
        this.prop = prop;
        return this;
    }

    public String getProp() {
        return prop;
    }

    public static void main(String[] args) {
        B b = new B();
        b.setProp("test").setProp("123").setProp("321");
        // System.out.println(a.getProp());
    }
}