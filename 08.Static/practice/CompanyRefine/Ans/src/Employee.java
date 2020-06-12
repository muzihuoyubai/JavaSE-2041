public class Employee {

    private int workHour;
    private String name;
    private int baseSalary;
    // private final static int defaultSalary = 3000;
    public static final int DEFAULT_SALARY = 3000;
    // private final String gender;

    public Employee(String name, int workHour, int baseSalary) {
        this.workHour = workHour;
        this.name = name;
        this.baseSalary = baseSalary;

    }

    public Employee(String name, int workHour) {
        this(name, workHour, DEFAULT_SALARY);

    }

    public Employee() {


    }

    // 创建一个构造方法初始化雇员的工作时长、工资和名字

    // 创建第二个构造方法初始化雇员的工作时长和名字
    // 创建一个静态的成员，默认基本工资值为3000，
    // 给调用第二个构造方法创建的对象基本工资设置为默认基本工资

    // 把所有的set方法返回this，使用链式设置一个Employee的对象的内容

    public Employee setWorkHour(int hour) {
        workHour = hour;
        return this;
    }

    public Employee setName(String aName) {
        name = aName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setBaseSalary(int salary) {
        baseSalary = salary;
        return this;
    }

    public int getSalary() {
        int rlt = baseSalary;
        if (workHour > 196) {
            rlt += (workHour - 196) * 200;
        }
        return rlt;
    }
}