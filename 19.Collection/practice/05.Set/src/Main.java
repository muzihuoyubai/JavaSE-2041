public class Main {

  public static void main(String[] args) {
    ClassRoom cr = new ClassRoom();
    cr.addStd(new Student(1,"张三",18));
    cr.addStd(new Student(2,"李四",20));
    cr.addStd(new Student(3,"王五",22));
    cr.addStd(new Student(4,"赵六",17));
    cr.addStd(new Student(5,"田七",19));
    cr.addStd(new Student(2,"刘八",16));

    cr.print();

    System.out.println(cr.sortById());
    System.out.println(cr.sortById(false));

  }
}
