public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("手机", 2000);
        Product p2 = new Product("打印机", 1000);

        System.out.println(p1.getScanCode());
        System.out.println(p2.getScanCode());

        System.out.println(p1.getInfo());
        System.out.println(p2.getInfo());

        p1.setNum(100);
        p2.setNum(200);

        System.out.println(p1.buy(90));
        System.out.println(p2.buy(200));
        System.out.println(p2.buy(1));


    }
}