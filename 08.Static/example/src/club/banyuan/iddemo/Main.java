package club.banyuan.iddemo;
import club.banyuan.animal.Elephant;

public class Main {

    public static void main(String[] args) {


        // total = createElephant(10, total);
        // total = createElephant(10, total);

        // createElephant(10);
        // createElephant(10);

        // Elephant e1 = new Elephant(300);

        Elephant e2 = new Elephant();
        Elephant e3 = new Elephant(123);


        // Elephant e1 = new Elephant();

        // System.out.println(e1.total); // 0

        // Elephant e2 = new Elephant();
        // e2.total ++;

        // System.out.println(e2.total); // 1
        // System.out.println(e1.total); // 1

        // System.out.println(Elephant.total); // 1
        // System.out.println(Elephant.getTotal());
        // System.out.println(new Elephant().getTotal());
        // System.out.println(Elephant.getTotal());


        // Elephant.staticMethod();

        // Elephant e1 = new Elephant();
        // e1.setId(1);

        // Elephant e2 = new Elephant();
        // e2.setId(2);

        // e1.print();
        // e2.print();
    }

    public static int createElephant(int num, int total) {

        Elephant [] elephant = new Elephant[num];
        for (int i = 0; i < elephant.length ; i++ ) {
            elephant[i] = new Elephant();
            elephant[i].setId(total++);
        }

        for (Elephant one : elephant) {
            one.print();
        }
        return total;
    }

    public static void createElephant(int num) {

        Elephant [] elephant = new Elephant[num];
        for (int i = 0; i < elephant.length ; i++ ) {
            elephant[i] = new Elephant();
            elephant[i].setId(elephant[i].total++);
        }

        for (Elephant one : elephant) {
            one.print();
        }

    }


}