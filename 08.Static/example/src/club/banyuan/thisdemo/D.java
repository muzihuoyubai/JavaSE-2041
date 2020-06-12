package club.banyuan.thisdemo;

/**

*/
public class D {



    private String prop = "1";
    private String title;

    {
        // 构造代码块
        System.out.println("1");
    }



    {
        // 构造代码块
        System.out.println("初始化C");
        System.out.println(prop);
        prop = "3";
    }



    {
        // 构造代码块
        System.out.println("2");
    }

    // 静态代码块
    static {
        System.out.println("static block");
    }

    public D() {
        prop = "2";
    }

    public D(String prop) {
        this(prop, "default");
        // this();
        // this.prop = prop;
        // title = "default";
    }

    public D(String prop, String title) {
        this.prop = prop;
        this.title = title;
    }

    // public D(String title) {
    //     this.title = title;
    //     prop = "default";
    // }


    public D setProp(String prop) {
        this.prop = prop;
        return this;
    }

    public String getProp() {
        return prop;
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.getProp());

        // System.out.println(a.getProp());
    }
}