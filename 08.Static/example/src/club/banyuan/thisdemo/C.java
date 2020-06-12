package club.banyuan.thisdemo;

/**
    this 在构造方法的第一句话中，可以引用其他的构造方法(不能递归调用当前的构造方法)
*/
public class C {

    private String prop;
    private String title;

    public C() {
        // System.out.println("构造了一个C");
        // prop = "default";
        // title = "default";
        this("default", "default");
    }

    public C(String prop) {
        this(prop, "default");
        // this();
        // this.prop = prop;
        // title = "default";
    }

    public C(String prop, String title) {
        this.prop = prop;
        this.title = title;
    }

    // public C(String title) {
    //     this.title = title;
    //     prop = "default";
    // }


    public C setProp(String prop) {
        this(prop, "test");
        this.prop = prop;
        return this;
    }

    public String getProp() {
        return prop;
    }

    public static void main(String[] args) {
        C c = new C();

        // System.out.println(a.getProp());
    }
}