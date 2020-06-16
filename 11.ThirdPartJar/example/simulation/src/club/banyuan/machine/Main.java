package club.banyuan.machine;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;

public class Main {

    public static Fridge createFridge(int heightInCM) {
        System.out.println("创建一个冰箱，高度为:" + heightInCM);
        Fridge fridge = new Fridge();
        fridge.heightInCM = heightInCM;
        return fridge;
    }

    public static void putinElephant(Elephant elephant, Fridge fridge) {
        System.out.printf("把%dcm高的大象，放到%dcm高的冰箱中\n", elephant.getHeightInCM(), fridge.heightInCM);
        if (fridge.heightInCM > elephant.getHeightInCM()) {
            fridge.elephant = elephant;
        } else {
            System.out.println("大象太大了！");
        }
    }

    public static void putinLion(Lion lion, Fridge fridge) {
        System.out.printf("把%dcm高的狮子，放到%dcm高的冰箱中\n", lion.heightInCM, fridge.heightInCM);
        if (fridge.heightInCM > lion.heightInCM) {
            fridge.lion = lion;
        } else {
            System.out.println("狮子太大了！");
        }

    }

    // full qualified name
    // 全限定名
    public static Elephant createElephant(int heightInCM) {
        // 对象(object)、实例(instance)
        // 实例化
        System.out.println("创建一个大象，高度为:" + heightInCM);
        Elephant elephant = new Elephant();
        elephant.setHeightInCM(heightInCM);
        return elephant;
    }

    public static Lion createLion(int heightInCM) {
        System.out.println("创建一个狮子，高度为：" + heightInCM);
        Lion lion = new Lion();
        lion.heightInCM = heightInCM;
        return lion;
    }


    public static void main(String[] args) {
        Elephant elephant = createElephant(300);
        Fridge fridge = createFridge(500);
        putinElephant(elephant, fridge);
        Lion lion = createLion(200);
        putinLion(lion, fridge);


        // Elephant elephantTwo = createElephant(350);
        // fridge.elephant = elephantTwo;

        // System.out.println(fridge.elephant.getHeightInCM());
        // System.out.println(fridge.lion.heightInCM);

        // Fridge fridgeTwo = new Fridge();
        // fridgeTwo.heightInCM = 300;
        // fridgeTwo.elephant = fridge.elephant;
        // System.out.println(fridgeTwo.elephant.getHeightInCM());

        // fridgeTwo.elephant.setHeightInCM(400);
        // System.out.println(elephantTwo.getHeightInCM());


        // System.out.println(fridgeTwo.elephant == elephantTwo);


        // elephant = createElephant(400);
    }
}
