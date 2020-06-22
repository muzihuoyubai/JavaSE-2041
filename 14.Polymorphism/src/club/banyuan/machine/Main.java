package club.banyuan.machine;

import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;

public class Main {

  public static Fridge createFridge(int heightInCM) {
    System.out.println("创建一个冰箱，高度为:" + heightInCM);
    return new Fridge(heightInCM);
  }

  public static void putinElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%dcm高的大象，放到%dcm高的冰箱中\n", elephant.getHeightInCM(), fridge.getHeightInCM());
    if (fridge.getHeightInCM() > elephant.getHeightInCM()) {
      fridge.setAnimal(elephant);
    } else {
      System.out.println("大象太大了！");
    }
  }

  public static void putinLion(Lion lion, Fridge fridge) {
    System.out.printf("把%dcm高的狮子，放到%dcm高的冰箱中\n", lion.getHeightInCM(), fridge.getHeightInCM());
    if (fridge.getHeightInCM() > lion.getHeightInCM()) {
      fridge.setAnimal(lion);
    } else {
      System.out.println("狮子太大了！");
    }

  }

  public static Elephant createElephant(int heightInCM) {
    // 对象(object)、实例(instance)
    // 实例化
    System.out.println("创建一个大象，高度为:" + heightInCM);
    return new Elephant(heightInCM);
  }

  public static Lion createLion(int heightInCM) {
    System.out.println("创建一个狮子，高度为：" + heightInCM);
    Lion lion = new Lion(200);
    lion.setHeightInCM(200);
    return lion;
  }


  public static void main(String[] args) {
    Elephant elephant = createElephant(300);
    Fridge fridge = createFridge(500);
    putinElephant(elephant, fridge);
    Lion lion = createLion(200);
    putinLion(lion, fridge);
  }
}
