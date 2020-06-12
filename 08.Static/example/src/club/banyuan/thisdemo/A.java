package club.banyuan.thisdemo;

/**
	this，用来区分局部变量名和成员变量名
*/
public class A {

    private String prop;

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getProp() {
        return prop;
    }

    public static void main(String[] args) {
        A a = new A();
        a.setProp("test");
        System.out.println(a.getProp());
    }
}