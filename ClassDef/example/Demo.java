class Elephant {
    int heightInCM;
}

class Fridge {
    // field 字段 域
    int heightInCM;
    Elephant elephant;
}

class Main {

    public static Fridge createFridge(int heightInCM) {
        System.out.println("创建一个冰箱，高度为:" + heightInCM);
        Fridge fridge = new Fridge();
        fridge.heightInCM = heightInCM;
        return fridge;
    }

    public static void putinElephant(Elephant elephant, Fridge fridge) {
        System.out.printf("把%dcm高的大象，放到%dcm高的冰箱中\n", elephant.heightInCM, fridge.heightInCM);
        if (fridge.heightInCM > elephant.heightInCM) {
            fridge.elephant = elephant;
        } else {
            System.out.println("大象太大了！");
        }
    }

    public static Elephant createElephant(int heightInCM) {
        // 对象(object)、实例(instance)
        // 实例化
        System.out.println("创建一个大象，高度为:" + heightInCM);
        Elephant elephant = new Elephant();
        elephant.heightInCM = heightInCM;
        return elephant;
    }


    public static void main(String[] args) {
        Elephant elephant = createElephant(300);
        Fridge fridge = createFridge(500);
        putinElephant(elephant, fridge);


    }
}