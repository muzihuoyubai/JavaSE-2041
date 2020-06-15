package club.banyuan.main;
import club.banyuan.animal.Elephant;
import club.banyuan.machine.Fridge;


public class Main {

    static void putInElephant(Elephant elephant, Fridge fridge) {
        System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.getHeightInCM(), fridge.getHeightInCM());
        if (elephant.getHeightInCM() < fridge.getHeightInCM()) {
            // 使用对象方法
            fridge.setStorage(elephant);
            System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.getStorage().getHeightInCM());
        } else {
            System.out.printf("冰箱装不下!\n");
        }
    }

    public static void main(String[] args) {
        Elephant elephant = new Elephant(300);
        Fridge fridge = new Fridge(500);
        putInElephant(elephant, fridge);
    }
}