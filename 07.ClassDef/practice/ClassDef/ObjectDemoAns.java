class Elephant {

    int heightInCM;
}

class Lion {

    int heightInCM;
}

class Fridge {

    int heightInCM;
    Elephant storage;
    Lion lionStorage;

    void store(Elephant elephant) {
        if (storage != null || lionStorage != null) {
            System.out.println("冰箱已经满了！");
            return;
        }
        storage = elephant;
    }

    void store(Lion lion) {
        if (storage != null || lionStorage != null) {
            System.out.println("冰箱已经满了！");
            return;
        }
        lionStorage = lion;
    }

    Elephant remove() {
        Elephant rlt = storage;
        storage = null;
        return rlt;
    }
}

class ObjectDemo {
    static Elephant createElephant(int heightInCM) {
        System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
        // 使用定义的类作为数据类型
        // 使用new 创建一个对象（实例）
        Elephant elephant = new Elephant();
        // 使用. 访问对象的属性，可以对属性赋值或使用
        elephant.heightInCM = heightInCM;
        return elephant;
    }

    static Lion createLion(int heightInCM) {
        System.out.printf("创建一个狮子，高度%d厘米\n", heightInCM);
        // 使用定义的类作为数据类型
        // 使用new 创建一个对象（实例）
        Lion lion = new Lion();
        // 使用. 访问对象的属性，可以对属性赋值或使用
        lion.heightInCM = heightInCM;
        return lion;
    }

    static Fridge createFridge(int heightInCM) {
        System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
        Fridge fridge = new Fridge();
        fridge.heightInCM = heightInCM;
        return fridge;
    }

    static void putInElephant(Elephant elephant, Fridge fridge) {
        System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.heightInCM, fridge.heightInCM);
        if (elephant.heightInCM < fridge.heightInCM) {

            // 使用对象方法
            fridge.store(elephant);
            System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.storage.heightInCM);
        } else {
            System.out.printf("冰箱装不下!\n");
        }

    }

    public static void main(String[] args) {
        Elephant elephant = createElephant(300);
        Fridge fridge = createFridge(500);
        putInElephant(elephant, fridge);

        // 调用remove方法之后，冰箱保存数据的变量内容被清空
        Elephant elephant1 = fridge.remove();
        System.out.println(elephant == elephant1);
        System.out.println(fridge.storage);

        fridge.store(new Lion());
        fridge.store(createLion(123));
        // fridge.store(elephant);
    }
}


